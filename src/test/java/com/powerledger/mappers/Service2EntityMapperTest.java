package com.powerledger.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.powerledger.fixtures.BatteryFixtures;
import com.powerledger.persistence.entities.BatteryEntity;
import com.powerledger.services.pojos.Battery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Service2EntityMapperTest {

  private Service2EntityMapper service2EntityMapper = new Service2EntityMapperImpl();

  @Test
  void shouldConvertBatteryPojoToEntity() {

    Battery battery = BatteryFixtures.getBattery("batt1", 1, 100);

    BatteryEntity actual = service2EntityMapper.asBatteryEntity(battery);

    assertEquals("batt1", actual.getName());
    assertEquals(1, actual.getPostCode());
    assertEquals(100, actual.getWattCapacity());
  }
}