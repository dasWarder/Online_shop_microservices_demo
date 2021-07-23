package by.itechart.product_service_demo.service;

import by.itechart.product_service_demo.dao.ProductRepository;
import by.itechart.product_service_demo.exception.ProductNotFoundException;
import by.itechart.product_service_demo.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static by.itechart.product_service_demo.util.ValidationUtil.validateParams;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {

        validateParams(product);
        log.info("Storing a product");

        Product storedProduct = productRepository.save(product);

        return storedProduct;
    }

    @Override
    public Product getProductById(String id) throws ProductNotFoundException {

        validateParams(id);
        log.info("Receive a product by ID {}", id);

        Optional<Product> possibleProductById = productRepository.findById(id);
        Product validProduct = possibleProductById.orElseThrow(ProductNotFoundException::new);

        return validProduct;
    }

    @Override
    public Product updateProduct(String id, Product product) throws ProductNotFoundException {

        validateParams(id, product);
        log.info("Update a product by ID {}", id);

        Product validProduct = getProductById(id);
        product.setId(validProduct.getId());
        Product updatedProduct = saveProduct(product);

        return updatedProduct;
    }

    @Override
    public void deleteProductById(String id) {

        validateParams(id);
        log.info("Delete a product with ID {}", id);

        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {

        log.info("Receive a list of all products");

       Page<Product> allProducts = productRepository.findAll(pageable);

        return allProducts;
    }
}
