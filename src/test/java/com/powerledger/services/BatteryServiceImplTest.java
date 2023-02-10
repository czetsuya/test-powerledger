package com.powerledger.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

import com.powerledger.fixtures.BatteryFixtures;
import com.powerledger.mappers.Service2EntityMapper;
import com.powerledger.persistence.repositories.BatteryRepository;
import com.powerledger.services.pojos.Batteries;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BatteryServiceImplTest {

  private BatteryService batteryService;

  @Mock
  private Service2EntityMapper service2EntityMapper;

  @Mock
  private BatteryRepository batteryRepository;

  @BeforeEach
  void setUp() {
    batteryService = new BatteryServiceImpl(batteryRepository, service2EntityMapper);
  }

  @Test
  void shouldCreateBatteryEntitiesGivenPojos() throws ExecutionException, InterruptedException {

    Batteries batteries = Batteries.builder()
        .batteries(BatteryFixtures.getBatteries())
        .build();

    batteryService.createBatteries(batteries)
        .get();

    Mockito.verify(batteryRepository, times(1)).saveAll(any());
    Mockito.verify(service2EntityMapper, times(4)).asBatteryEntity(any());
  }
}