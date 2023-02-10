package com.powerledger.persistence.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.powerledger.fixtures.BatteryFixtures;
import com.powerledger.persistence.entities.BatteryEntity;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class BatteryRepositoryTest {

  @Autowired
  private BatteryRepository batteryRepository;

  @Test
  void whenFindByRangeThenReturnBatteryPostRange() {

    List<BatteryEntity> batteryEntities = getBatteryEntities();

    batteryRepository.saveAll(batteryEntities);

    List<BatteryEntity> actual = batteryRepository.findByPostCodeBetween(1, 4);

    assertEquals(4, actual.size());
    assertEquals("B", actual.get(0).getName());
    assertEquals("A", actual.get(1).getName());
    assertEquals("D", actual.get(2).getName());
    assertEquals("C", actual.get(3).getName());
  }

  @Test
  void whenFindByRangeNoMatchThenReturnEmptyList() {

    List<BatteryEntity> batteryEntities = getBatteryEntities();

    batteryRepository.saveAll(batteryEntities);

    List<BatteryEntity> actual = batteryRepository.findByPostCodeBetween(50, 60);

    assertEquals(0, actual.size());
  }

  private List<BatteryEntity> getBatteryEntities() {

    return List.of(
        BatteryFixtures.getBatteryEntity("B", 2, 20),
        BatteryFixtures.getBatteryEntity("R1", 10, 100),
        BatteryFixtures.getBatteryEntity("A", 1, 10),
        BatteryFixtures.getBatteryEntity("D", 4, 40),
        BatteryFixtures.getBatteryEntity("R1", 200, 200),
        BatteryFixtures.getBatteryEntity("C", 3, 30)
    );
  }
}