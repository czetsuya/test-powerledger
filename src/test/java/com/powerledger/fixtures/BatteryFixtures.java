package com.powerledger.fixtures;

import com.powerledger.persistence.entities.BatteryEntity;
import com.powerledger.services.pojos.Battery;
import com.powerledger.web.controllers.models.BatteriesV1;
import com.powerledger.web.controllers.models.BatteryV1;
import java.util.List;

public class BatteryFixtures {

  public static BatteryV1 getBatteryModel(String name, int postCode, double wattCapatity) {

    return BatteryV1.builder()
        .name(name)
        .postCode(postCode)
        .wattCapacity(wattCapatity)
        .build();
  }

  public static Battery getBattery(String name, int postCode, double wattCapatity) {

    return Battery.builder()
        .name(name)
        .postCode(postCode)
        .wattCapacity(wattCapatity)
        .build();
  }

  public static BatteryEntity getBatteryEntity(String name, int postCode, double wattCapatity) {

    return BatteryEntity.builder()
        .name(name)
        .postCode(postCode)
        .wattCapacity(wattCapatity)
        .build();
  }

  public static List<Battery> getBatteries() {
    return List.of(
        getBattery("B", 2, 20),
        getBattery("A", 1, 10),
        getBattery("D", 4, 40),
        getBattery("C", 3, 40)
    );
  }

  public static BatteriesV1 getBatteryModels() {
    return
        BatteriesV1.builder()
            .values(
                List.of(
                    getBatteryModel("B", 2, 20),
                    getBatteryModel("F", 6, 60),
                    getBatteryModel("A", 1, 10),
                    getBatteryModel("D", 4, 40),
                    getBatteryModel("C", 3, 30),
                    getBatteryModel("E", 5, 50),
                    getBatteryModel("J", 10, 100),
                    getBatteryModel("H", 8, 80),
                    getBatteryModel("G", 7, 70),
                    getBatteryModel("I", 9, 90)
                ))
            .build();
  }
}
