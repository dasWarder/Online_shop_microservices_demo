package by.itechart.product_service_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductIdDto {

    private String id;

    private String name;

    private String description;

    private BigDecimal price;
}
