package by.itechart.product_service_demo.mapper;

import by.itechart.product_service_demo.dto.ProductDto;
import by.itechart.product_service_demo.dto.ProductIdDto;
import by.itechart.product_service_demo.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper
public interface ProductMapper {

    Product productIdDtoToProduct(ProductIdDto productIdDto);

    @Mapping(target = "id", ignore = true)
    Product productDtoToProduct(ProductDto productDto);

    ProductDto productToProductDto(Product product);

    ProductIdDto productToProductIdDto(Product product);

    List<ProductDto> productPageToProductDtoPage(Page<Product> products);
}
