package com.powerledger.services.pojos;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BatteryPostRange {

  private List<String> names;
  private double totalWatts;
  private double averageWatts;
}
