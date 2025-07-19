package com.pm.EccommerceOrderService.clients;

import com.pm.EccommerceOrderService.dto.ProductDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductServiceClient {

    private final RestTemplate restTemplate;


    public ProductServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ProductDTO getProductById(Long productId)
    {
      //  RestTemplate template=restTemplateBuilder.build();

        String url="http://ECOMMERCEAPIINTEGRATION/api/products/" + productId;

        ResponseEntity<ProductDTO> response= restTemplate.getForEntity(url, ProductDTO.class);
        return response.getBody();
    }
}
