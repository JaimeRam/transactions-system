package com.transactions.application.rest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SearchTransactionTest {

  public static final String ENDPOINT_URI = "/search-transaction";
  public static final String ACCOUNT_IBAN = "ES9820385778983000760236";
  public static final String EXPECTED_JSON_FILE_TEST = "src/test/resources/ExpectedSearchTransactionResult.json";
  public static final String EXPECTED_JSON_FILE_TEST_WITH_ORDER = "src/test/resources/ExpectedSearchTransactionResultByDescOrder.json";


  @Autowired
  private MockMvc mockMvc;

  @Test
  void searchTransactionTest() throws Exception {
    mockMvc.perform(get(ENDPOINT_URI + "/" + ACCOUNT_IBAN))
        .andExpect(status().isOk())
        .andExpect(content()
            .json(getExpectedSearchTransactionResult()));
  }

  @Test
  void searchTransactionByDescOrderTest() throws Exception {
    mockMvc.perform(get(ENDPOINT_URI + "/" + ACCOUNT_IBAN)
            .param("sort", "desc"))
        .andExpect(status().isOk())
        .andExpect(content()
            .json(getExpectedSearchTransactionResultByDescOrder()));
  }

  private String getExpectedSearchTransactionResult() throws IOException {
    return Files.readString(Path.of(EXPECTED_JSON_FILE_TEST));
  }

  private String getExpectedSearchTransactionResultByDescOrder() throws IOException {
    return Files.readString(
        Path.of(EXPECTED_JSON_FILE_TEST_WITH_ORDER));
  }
}
