package com.innerconsulting.scoreneo.services;

import com.innerconsulting.scoreneo.model.Product;
import com.innerconsulting.scoreneo.model.Score;
import com.innerconsulting.scoreneo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return this.productRepository.save(product);
    }
    public Product findProductById(Long id) {
        return this.productRepository.findById(id).orElse(null);
    }

    public Iterable<Product> findAllProducts() {
        return this.productRepository.findAll();
    }

    public void deleteProductById(Long id) {
        this.productRepository.deleteById(id);
    }
}
