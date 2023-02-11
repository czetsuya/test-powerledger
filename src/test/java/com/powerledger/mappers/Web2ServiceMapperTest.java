package com.powerledger.mappers;

import static org.junit.jupiter.api.Assertions.*;

import com.powerledger.fixtures.BatteryFixtures;
import com.powerledger.services.pojos.Batteries;
import com.powerledger.services.pojos.Battery;
import com.powerledger.web.controllers.models.BatteriesV1;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Web2ServiceMapperTest {

  private final Web2ServiceMapper web2ServiceMapper = new Web2ServiceMapperImpl();

  @BeforeEach
  void setUp() {

  }

  @Test
  void shouldConvertBatteryModelToPojo() {

    BatteriesV1 batteriesV1 = BatteriesV1.builder()
        .values(List.of(
            BatteryFixtures.getBatteryModel("batt1", 1, 100)
        ))
        .build();

    Batteries actual = web2ServiceMapper.asBatteries(batteriesV1);
    Battery battery = actual.getValues().get(0);

    assertEquals("batt1", battery.getName());
    assertEquals(1, battery.getPostCode());
    assertEquals(100, battery.getWattCapacity());
  }
}