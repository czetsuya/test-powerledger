package com.powerledger.web.controllers.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class BatteryV1 {

  private String name;

  private int postCode;

  private double wattCapacity;
}
