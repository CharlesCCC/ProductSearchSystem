package com.example.productsearchsystem.Service;

import com.example.productsearchsystem.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SolrSearchService {

    Product save(Product product);

    Iterable<Product> saveAll(List<Product> products);

    void delete(Product product);

    Product findBySkuId(Long skuId);

    public Page<Product> findByProdDescription(String searchTerm, Pageable pageable);

    Page<Product> findByCustomQuery(String searchTerm, Pageable pageable);
}
