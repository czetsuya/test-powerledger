package com.powerledger.web.controllers.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BatteryPostRangeV1 {

  private List<String> names;
  private double totalWatts;
  private double averageWatts;
}
