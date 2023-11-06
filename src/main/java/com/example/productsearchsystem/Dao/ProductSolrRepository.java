package com.example.productsearchsystem.Dao;

import com.example.productsearchsystem.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface ProductSolrRepository extends SolrCrudRepository<Product, Long> {
    Product findBySkuId(Long skuId);

    @Query("prod_description:*?0*")
    public Page<Product> findByProdDescription(String searchTerm, Pageable pageable);

    @Query("prod_description:*?0* OR title:*?0* OR size:*?0* OR color:*?0* OR featured_color:*?0* OR product_category:*?0*")
    public Page<Product> findByCustomQuery(String searchTerm, Pageable pageable);

}
