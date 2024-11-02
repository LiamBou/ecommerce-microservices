package com.ecommerce.productservice.service;

import com.ecommerce.productservice.dto.ProductRequest;
import com.ecommerce.productservice.dto.ProductResponse;
import com.ecommerce.productservice.exception.ProductNotFoundException;
import com.ecommerce.productservice.model.Product;
import com.ecommerce.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .race(productRequest.race())
                .color(productRequest.color())
                .price(productRequest.price())
                .description(productRequest.description())
                .image(productRequest.image())
                .build();

        productRepository.save(product);
        log.info("Product created successfully");
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getRace(),
                product.getColor(),
                product.getPrice(),
                product.getDescription(),
                product.getImage()
        );
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getRace(),
                        product.getColor(),
                        product.getPrice(),
                        product.getDescription(),
                        product.getImage()
                ))
                .toList();
    }

    public ProductResponse getProductById(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getRace(),
                product.getColor(),
                product.getPrice(),
                product.getDescription(),
                product.getImage()
        );
    }

    public void deleteProduct(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        productRepository.delete(product);
    }
}
