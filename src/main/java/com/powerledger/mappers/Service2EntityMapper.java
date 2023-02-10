package com.powerledger.mappers;

import com.powerledger.persistence.entities.BatteryEntity;
import com.powerledger.services.pojos.Battery;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface Service2EntityMapper {

  BatteryEntity asBatteryEntity(Battery battery);
}
