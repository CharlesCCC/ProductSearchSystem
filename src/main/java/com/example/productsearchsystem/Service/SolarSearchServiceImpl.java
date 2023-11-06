package com.example.productsearchsystem.Service;

import com.example.productsearchsystem.Dao.ProductSolrRepository;
import com.example.productsearchsystem.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolarSearchServiceImpl implements SolrSearchService {

    ProductSolrRepository productSolrRepository;

    public SolarSearchServiceImpl(ProductSolrRepository productSolrRepository) {
        this.productSolrRepository = productSolrRepository;
    }

    @Override
    public Product save(Product product) {
        return this.productSolrRepository.save(product);
    }

    @Override
    public Iterable<Product> saveAll(List<Product> products) {
        return this.productSolrRepository.saveAll(products);
    }

    @Override
    public void delete(Product product) {
        this.productSolrRepository.delete(product);
    }

    @Override
    public Product findBySkuId(Long skuId) {
        return productSolrRepository.findBySkuId(skuId);
    }

    @Override
    public Page<Product> findByProdDescription(String searchTerm, Pageable pageable) {
        return productSolrRepository.findByProdDescription(searchTerm, pageable);
    }

    @Override
    public Page<Product> findByCustomQuery(String searchTerm, Pageable pageable) {
        return productSolrRepository.findByCustomQuery(searchTerm, pageable);
    }
}
