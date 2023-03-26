package com.timeapi.timeapi;

import com.timeapi.timeapi.controller.TimeController;
import com.timeapi.timeapi.service.TimeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class TimeApiTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void test_should_return_400() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/time?timezone=Europe")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void test_should_return_res() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/time?timezone=America/Adak")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.abbreviation").value("HDT"));
    }
}
