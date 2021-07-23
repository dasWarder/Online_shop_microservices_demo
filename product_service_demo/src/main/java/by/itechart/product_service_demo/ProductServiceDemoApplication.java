package by.itechart.product_service_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProductServiceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceDemoApplication.class, args);
    }

}
