package com.powerledger.web.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.powerledger.fixtures.BatteryFixtures;
import com.powerledger.web.controllers.models.BatteriesV1;
import com.powerledger.web.controllers.models.BatteryPostRangeResponseV1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

class BatteryControllerFunctionalTest extends FunctionalRestTest {

  @Test
  void shouldCreateBatteriesOk() throws Exception {

    MockHttpServletRequestBuilder req = createRequest();

    performAsync(req, status().isOk());
  }

  @Test
  void shouldReturnBatteryStatsFromCreated() throws Exception {

    MockHttpServletRequestBuilder req = createRequest();

    performAsync(req, status().isOk());

    req = MockMvcRequestBuilders
        .get(EndpointConstants.PATH_BATTERIES)
        .queryParam(EndpointConstants.PARAM_FROM, "2")
        .queryParam(EndpointConstants.PARAM_TO, "5");

    String resp = performAsync(req, status().isOk())
        .andReturn()
        .getResponse()
        .getContentAsString();

    BatteryPostRangeResponseV1 result = objectMapper.readValue(resp, BatteryPostRangeResponseV1.class);

    assertEquals(4, result.getNames().size());
    assertEquals("B", result.getNames().get(0));
    assertEquals(140, result.getTotalWatts());
    assertEquals(35, result.getAverageWatts());
  }

  @Test
  void shouldThrowAnErrorWhenListIsEmpty() {

    Assertions.assertThrows(AssertionError.class, () -> {
      MockHttpServletRequestBuilder req = MockMvcRequestBuilders
          .post(EndpointConstants.PATH_BATTERIES)
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(new BatteriesV1()));

      performAsync(req, status().isBadRequest());
    });
  }

  private MockHttpServletRequestBuilder createRequest() throws JsonProcessingException {

    return MockMvcRequestBuilders
        .post(EndpointConstants.PATH_BATTERIES)
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(BatteryFixtures.getBatteryModels()));
  }
}