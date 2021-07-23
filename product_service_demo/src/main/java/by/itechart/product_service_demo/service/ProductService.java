package by.itechart.product_service_demo.service;

import by.itechart.product_service_demo.exception.ProductNotFoundException;
import by.itechart.product_service_demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    Product getProductById(String id) throws ProductNotFoundException;

    Product updateProduct(String id, Product product) throws ProductNotFoundException;

    void deleteProductById(String id);

    Page<Product> getAllProducts(Pageable pageable);
}
