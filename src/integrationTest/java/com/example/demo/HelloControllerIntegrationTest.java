package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HelloController helloController;

    @Test
    void contextLoads() {
        assertThat(helloController).isNotNull();
    }

    @Test
    void testRootEndpoint() throws Exception {
        // 'MediaType' is NOT visible here and so test does not even run...
        // We get an error for the compileIntegrationTestJava task:
        //    `class file for org.springframework.http.MediaType not found`
//        org.springframework.http.MediaType a;

        mockMvc.perform(get("/")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

}
