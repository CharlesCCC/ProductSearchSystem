package com.example.productsearchsystem.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class UploadControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void uploadFile_ValidFile_ReturnsCreatedStatus() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "test.csv", MediaType.TEXT_PLAIN_VALUE, "file content".getBytes());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.multipart("/api/v1/upload")
                        .file(file))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();

        assertEquals("Upload file successful，total items: 0", result.getResponse().getContentAsString());
    }

    @Test
    void uploadFile_EmptyFile_ReturnsBadRequest() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "", MediaType.TEXT_PLAIN_VALUE, "".getBytes());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.multipart("/api/v1/upload")
                        .file(file))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                        .andReturn();
        assertEquals("Please upload a non-empty file.", result.getResponse().getContentAsString());
    }
}

