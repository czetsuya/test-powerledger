package com.powerledger.mappers;

import com.powerledger.services.pojos.Batteries;
import com.powerledger.web.controllers.models.BatteriesV1;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface Web2ServiceMapper {

  Batteries asBatteries(BatteriesV1 batteriesV1);
}
