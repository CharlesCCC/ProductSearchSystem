package com.example.productsearchsystem.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createProduct_ValidProduct_ReturnsDescription() throws Exception {
        String productJson = "{\"id\": 1, \"name\": \"Test Product\", \"description\": \"Test Description\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        assertEquals("Product Created", result.getResponse().getContentAsString());
    }

    @Test
    void readProduct_ExistingProductId_ReturnsProduct() throws Exception {
        long productId = 1;

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/product/{productId}", productId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // Assert the response content or further processing of the product object
    }

    @Test
    void updateProduct_ValidProduct_ReturnsDescription() throws Exception {
        String productJson = "{\"id\": 1, \"name\": \"Updated Product\", \"description\": \"Updated Description\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        assertEquals("Order Updated", result.getResponse().getContentAsString());
    }

    @Test
    void findOrder_ValidDescriptionAndPage_ReturnsProductList() throws Exception {
        String prodDesc = "Test";
        int page = 0;
        int pageSize = 10;

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/product/desc/{prodDesc}/{page}/{pageSize}", prodDesc, page, pageSize))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // Assert the response content or further processing of the product list
    }

    @Test
    void findOrderBySearchTerm_ValidSearchTermAndPage_ReturnsProductList() throws Exception {
        String searchTerm = "Test";
        int page = 0;
        int pageSize = 10;

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/product/search/{searchTerm}/{page}/{pageSize}", searchTerm, page, pageSize))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // Assert the response content or further processing of the product list
    }
}

