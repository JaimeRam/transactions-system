package com.transactions.application.rest;

import com.google.gson.Gson;
import com.transactions.application.rest.api.TransactionStatusRequest;
import com.transactions.application.rest.api.TransactionStatusResponse;
import com.transactions.domain.transactions.ChannelEnum;
import com.transactions.domain.transactions.TransactionStatusEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TransactionStatusTest {

  public static final String ENDPOINT_URI = "/transaction-status";

  @Autowired
  private MockMvc mockMvc;

  @Test
  void transactionStatusTest() throws Exception {
    mockMvc.perform(get(ENDPOINT_URI)
            .contentType(MediaType.APPLICATION_JSON)
            .content(new Gson().toJson(getTransactionStatusRequest())))
        .andExpect(status().isOk())
        .andExpect(content()
            .json(new Gson().toJson(getExpectedTransactionStatusResponse())));
  }

  private TransactionStatusRequest getTransactionStatusRequest() {
    return new TransactionStatusRequest("12345A", ChannelEnum.CLIENT);
  }

  private TransactionStatusResponse getExpectedTransactionStatusResponse() {
    return new TransactionStatusResponse("12345A", TransactionStatusEnum.SETTLED.name(), 190.2,
        null);
  }
}
