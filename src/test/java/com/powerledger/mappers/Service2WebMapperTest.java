package com.powerledger.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.powerledger.services.pojos.BatteryPostRange;
import com.powerledger.web.controllers.models.BatteryPostRangeV1;
import java.util.List;
import org.junit.jupiter.api.Test;

class Service2WebMapperTest {

  private Service2WebMapper service2WebMapper = new Service2WebMapperImpl();

  @Test
  void shouldConvertBatteryPostRangePojoToModel() {

    BatteryPostRange batteryPostRange = BatteryPostRange.builder()
        .names(List.of("A", "B", "C", "D"))
        .totalWatts(140d)
        .averageWatts(35d)
        .build();

    BatteryPostRangeV1 actual = service2WebMapper.asBatteryPostRangeV1(batteryPostRange);

    assertEquals(4, actual.getNames().size());
    assertEquals(140d, actual.getTotalWatts());
    assertEquals(35d, actual.getAverageWatts());
  }
}