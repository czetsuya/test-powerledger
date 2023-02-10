package com.powerledger.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "battery")
@EqualsAndHashCode(callSuper = true)
public class BatteryEntity extends BaseEntity {

  @Column(name = "battery_name")
  private String name;

  @Column(name = "post_code")
  private int postCode;

  @Column(name = "watt_capacity")
  private double wattCapacity;
}
