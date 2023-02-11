package com.powerledger.web.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.powerledger.Application;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@ActiveProfiles("test")
@ExtendWith({SpringExtension.class})
@SpringBootTest(classes = {Application.class})
@Tag("functional")
@AutoConfigureMockMvc
public abstract class FunctionalRestTest {

  @Autowired
  protected ObjectMapper objectMapper;

  @Autowired
  protected MockMvc mockMvc;

  protected ResultActions perform(
      MockHttpServletRequestBuilder request) throws Exception {

    return mockMvc.perform(request);
  }

  protected ResultActions performAsync(
      final MockHttpServletRequestBuilder request,
      ResultMatcher resultMatcher)
      throws Exception {

    MvcResult mvcResult =
        perform(request)
            .andExpect(resultMatcher)
            .andExpect(request().asyncStarted())
            .andReturn();

    return mockMvc
        .perform(asyncDispatch(mvcResult));
  }
}
