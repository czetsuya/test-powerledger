package com.powerledger.mappers;

import com.powerledger.services.pojos.BatteryPostRange;
import com.powerledger.web.controllers.models.BatteryPostRangeResponseV1;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface Service2WebMapper {

  BatteryPostRangeResponseV1 asBatteryPostRangeV1(BatteryPostRange batteryPostRange);
}
