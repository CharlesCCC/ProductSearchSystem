package com.example.productsearchsystem.Service;

import com.example.productsearchsystem.Dao.ProductSolrRepository;
import com.example.productsearchsystem.Entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SolarSearchServiceImplTest {

    @Mock
    private ProductSolrRepository productSolrRepository;

    private SolarSearchServiceImpl solarSearchService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        solarSearchService = new SolarSearchServiceImpl(productSolrRepository);
    }

    @Test
    void save_Product_SuccessfullySaved() {
        Product product = new Product(); // Create a sample product
        when(productSolrRepository.save(product)).thenReturn(product);

        Product savedProduct = solarSearchService.save(product);

        assertEquals(product, savedProduct);
        verify(productSolrRepository, times(1)).save(product);
    }

    @Test
    void saveAll_Products_SuccessfullySaved() {
        List<Product> products = new ArrayList<>(); // Create a list of sample products
        when(productSolrRepository.saveAll(products)).thenReturn(products);

        Iterable<Product> savedProducts = solarSearchService.saveAll(products);

        assertEquals(products, savedProducts);
        verify(productSolrRepository, times(1)).saveAll(products);
    }

    @Test
    void delete_Product_ProductDeleted() {
        Product product = new Product(); // Create a sample product

        solarSearchService.delete(product);

        verify(productSolrRepository, times(1)).delete(product);
    }

    @Test
    void findBySkuId_ExistingSkuId_ReturnsProduct() {
        Long skuId = 123L; // Sample SKU ID
        Product expectedProduct = new Product(); // Create a sample product
        when(productSolrRepository.findBySkuId(skuId)).thenReturn(expectedProduct);

        Product foundProduct = solarSearchService.findBySkuId(skuId);

        assertEquals(expectedProduct, foundProduct);
        verify(productSolrRepository, times(1)).findBySkuId(skuId);
    }

    @Test
    void findByProdDescription_ValidSearchTermAndPageable_ReturnsPageOfProducts() {
        String searchTerm = "example"; // Sample search term
        PageRequest pageable = PageRequest.of(0, 10);
        Page<Product> expectedPage = new PageImpl<>(new ArrayList<>()); // Create a sample page of products
        when(productSolrRepository.findByProdDescription(searchTerm, pageable)).thenReturn(expectedPage);

        Page<Product> foundPage = solarSearchService.findByProdDescription(searchTerm, pageable);

        assertEquals(expectedPage, foundPage);
        verify(productSolrRepository, times(1)).findByProdDescription(searchTerm, pageable);
    }

    @Test
    void findByCustomQuery_ValidSearchTermAndPageable_ReturnsPageOfProducts() {
        String searchTerm = "example"; // Sample search term
        PageRequest pageable = PageRequest.of(0, 10);
        Page<Product> expectedPage = new PageImpl<>(new ArrayList<>()); // Create a sample page of products
        when(productSolrRepository.findByCustomQuery(searchTerm, pageable)).thenReturn(expectedPage);

        Page<Product> foundPage = solarSearchService.findByCustomQuery(searchTerm, pageable);

        assertEquals(expectedPage, foundPage);
        verify(productSolrRepository, times(1)).findByCustomQuery(searchTerm, pageable);
    }
}
