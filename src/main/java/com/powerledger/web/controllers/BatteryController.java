package com.powerledger.web.controllers;

import com.powerledger.mappers.Service2WebMapper;
import com.powerledger.mappers.Web2ServiceMapper;
import com.powerledger.services.BatteryService;
import com.powerledger.web.controllers.models.BatteriesV1;
import com.powerledger.web.controllers.models.BatteryPostRangeV1;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
@Slf4j
@RequestMapping(EndpointConstants.PATH_BATTERIES)
public class BatteryController {

  private final BatteryService batteryService;
  private final Web2ServiceMapper web2ServiceMapper;
  private final Service2WebMapper service2WebMapper;

  @ResponseStatus(value = HttpStatus.OK)
  @PostMapping
  public CompletableFuture<Void> createBatteries(@RequestBody @NotNull @Valid BatteriesV1 batteries) {

    log.info("Creating list of batteries={}", batteries.getBatteries().size());

    return batteryService.createBatteries(web2ServiceMapper.asBatteries(batteries));
  }

  @ResponseStatus(value = HttpStatus.OK)
  @GetMapping
  public CompletableFuture<BatteryPostRangeV1> getBatteries(@RequestParam(EndpointConstants.PARAM_FROM) int from,
      @RequestParam(EndpointConstants.PARAM_TO) int to) {

    log.info("Retrieving batteries from={}, to={}", from, to);

    return batteryService.getBatteries(from, to)
        .thenApply(service2WebMapper::asBatteryPostRangeV1);
  }
}
