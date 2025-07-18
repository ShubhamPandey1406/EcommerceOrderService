package com.pm.EccommerceOrderService.clients;

import com.pm.EccommerceOrderService.dto.ProductDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductServiceClient {

    private final RestTemplateBuilder restTemplateBuilder;

    public ProductServiceClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public ProductDTO getProductById(Long productId)
    {
        RestTemplate template=restTemplateBuilder.build();

        String url="http://localhost:3001/api/products/" + productId;

        ResponseEntity<ProductDTO> response= template.getForEntity(url, ProductDTO.class);
        return response.getBody();
    }
}
