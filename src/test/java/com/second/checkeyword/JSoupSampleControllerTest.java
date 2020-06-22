package com.second.checkeyword;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
@RunWith(SpringRunner.class)
@WebMvcTest
public class JSoupSampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void sampleTest()throws Exception{
        mockMvc.perform(get("/sample"))
                .andExpect(status().isOk())
                .andDo(print());
    }

}