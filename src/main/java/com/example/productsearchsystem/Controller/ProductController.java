package com.example.productsearchsystem.Controller;

import com.example.productsearchsystem.Entity.Product;
import com.example.productsearchsystem.Service.SolrSearchService;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    final SolrSearchService solrProductService;

    public ProductController(SolrSearchService solrProductService) {
        this.solrProductService = solrProductService;
    }

    @PostMapping()
    public String createProduct(@RequestBody Product product) {
        String description = "Product Created";
        solrProductService.save(product);
        return description;
    }

    @GetMapping("/{productId}")
    public Product readProduct(@PathVariable Long productId) {
        return solrProductService.findBySkuId(productId);
    }

    @PutMapping()
    public String updateProduct(@RequestBody Product product) {
        String description = "Product Updated";
        solrProductService.save(product);
        return description;
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable Long productId) {
        String description = "Product Deleted";
        solrProductService.delete(solrProductService.findBySkuId(productId));
        return description;
    }

    @GetMapping("/desc/{prodDesc}/{page}/{pageSize}")
    public List<Product> findProduct(@PathVariable String prodDesc, @PathVariable int page, @PathVariable int pageSize) {
        return solrProductService.findByProdDescription(prodDesc, PageRequest.of(page, pageSize)).getContent();
    }

    @GetMapping("/search/{searchTerm}/{page}/{pageSize}")
    public List<Product> findProductBySearchTerm(@PathVariable String searchTerm, @PathVariable int page, @PathVariable int pageSize) {
        return solrProductService.findByCustomQuery(searchTerm, PageRequest.of(page, pageSize)).getContent();
    }
}
