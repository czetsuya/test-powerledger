package com.powerledger.mappers;

import com.powerledger.persistence.entities.BatteryEntity;
import com.powerledger.services.pojos.Battery;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface Service2EntityMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "version", ignore = true)
  BatteryEntity asBatteryEntity(Battery battery);
}
