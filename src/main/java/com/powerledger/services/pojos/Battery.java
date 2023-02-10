package com.powerledger.services.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Battery {

  private String name;

  private int postCode;

  private double wattCapacity;
}
