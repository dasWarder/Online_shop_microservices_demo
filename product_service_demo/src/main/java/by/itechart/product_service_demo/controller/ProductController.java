package by.itechart.product_service_demo.controller;


import by.itechart.product_service_demo.dto.ProductDto;
import by.itechart.product_service_demo.dto.ProductIdDto;
import by.itechart.product_service_demo.exception.ProductNotFoundException;
import by.itechart.product_service_demo.mapper.ProductMapper;
import by.itechart.product_service_demo.model.Product;
import by.itechart.product_service_demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductMapper productMapper;

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(@PageableDefault(page = 0, size = 10, sort = { "id" })
                                         Pageable pageable) {

        Page<Product> products = productService.getAllProducts(pageable);
        List<ProductDto> responsePage = productMapper.productPageToProductDtoPage(products);

        return ResponseEntity.ok(responsePage);
    }

    @PostMapping("/product")
    public ResponseEntity<ProductIdDto> saveProduct(@RequestBody ProductIdDto productDto) {

        Product requestProduct = productMapper.productIdDtoToProduct(productDto);
        Product storedProduct = productService.saveProduct(requestProduct);
        ProductIdDto responseDto = productMapper.productToProductIdDto(storedProduct);

        return ResponseEntity
                .created(URI.create("/api/products/product" + storedProduct.getId()))
                .body(responseDto);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductIdDto> getProductById(@PathVariable("id") String id) throws ProductNotFoundException {

        Product productById = productService.getProductById(id);
        ProductIdDto responseDto = productMapper.productToProductIdDto(productById);

        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductIdDto> updateProduct(@PathVariable("id") String id,
                                        @RequestBody ProductDto productDto) throws ProductNotFoundException {

        Product productForUpdating = productMapper.productDtoToProduct(productDto);
        Product updatedProduct = productService.updateProduct(id, productForUpdating);
        ProductIdDto responseDto = productMapper.productToProductIdDto(updatedProduct);

        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable("id") String id) {

        productService.deleteProductById(id);

        return ResponseEntity.noContent().build();
    }
}
