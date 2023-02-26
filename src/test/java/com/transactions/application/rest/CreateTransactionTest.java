package com.transactions.application.rest;

import com.google.gson.Gson;
import com.transactions.application.rest.api.CreateTransactionRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CreateTransactionTest {

  public static final String ENDPOINT_URI = "/create-transaction";

  @Autowired
  private MockMvc mockMvc;

  @Test
  void createTransactionTest() throws Exception {
    mockMvc.perform(post(ENDPOINT_URI)
            .contentType(MediaType.APPLICATION_JSON)
            .content(new Gson().toJson(getTransactionRequest())))
        .andExpect(status().isCreated());
  }

  private CreateTransactionRequest getTransactionRequest() {
    return CreateTransactionRequest.builder()
        .amount(150.24)
        .fee(3.15)
        .accountIban("ES6604879643251647165385")
        .build();
  }
}
