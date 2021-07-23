package by.itechart.product_service_demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/api/test")
public class TestController {

    @Value("${test.name}")
    private String name;

    @GetMapping
    public ResponseEntity<String> getAnswer() {

        String response = "Hello from the config, " + name;

        return ResponseEntity.ok(response);
    }
}
