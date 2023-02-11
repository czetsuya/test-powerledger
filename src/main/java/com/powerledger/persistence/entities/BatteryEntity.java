package com.powerledger.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "battery")
@GenericGenerator(name = "ID_GENERATOR",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {@Parameter(name = "sequence_name", value = "battery_seq")}
)
public class BatteryEntity extends BaseEntity {

  @Column(name = "battery_name")
  private String name;

  @Column(name = "post_code")
  private int postCode;

  @Column(name = "watt_capacity")
  private double wattCapacity;
}
