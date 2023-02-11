package com.powerledger.services;

import com.powerledger.mappers.Service2EntityMapper;
import com.powerledger.persistence.entities.BatteryEntity;
import com.powerledger.persistence.repositories.BatteryRepository;
import com.powerledger.services.pojos.Batteries;
import com.powerledger.services.pojos.BatteryPostRange;
import jakarta.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BatteryServiceImpl implements BatteryService {

  private final BatteryRepository batteryRepository;
  private final Service2EntityMapper service2EntityMapper;

  @Override
  @Transactional(rollbackOn = {SQLException.class})
  public CompletableFuture<Void> createBatteries(Batteries batteries) {

    log.debug("Creating batteries");

    return CompletableFuture.runAsync(() -> batteryRepository.saveAll(
        batteries.getValues().stream()
            .map(service2EntityMapper::asBatteryEntity)
            .toList())
    );
  }

  @Override
  public CompletableFuture<BatteryPostRange> getBatteries(int from, int to) {

    return CompletableFuture.supplyAsync(() -> {

      List<BatteryEntity> batteries = batteryRepository.findByPostCodeBetween(from, to);

      return BatteryPostRange.builder()
          .names(getSortedNames(batteries))
          .averageWatts(getAverageWatts(batteries))
          .totalWatts(getTotalWatts(batteries))
          .build();
    });
  }

  private double getTotalWatts(final List<BatteryEntity> arr) {

    return arr.stream()
        .mapToDouble(BatteryEntity::getWattCapacity)
        .sum();
  }

  private double getAverageWatts(final List<BatteryEntity> arr) {

    return arr.stream()
        .mapToDouble(BatteryEntity::getWattCapacity)
        .average()
        .orElse(0d);
  }

  private List<String> getSortedNames(final List<BatteryEntity> arr) {

    return arr.stream()
        .map(BatteryEntity::getName)
        .sorted()
        .toList();
  }
}
