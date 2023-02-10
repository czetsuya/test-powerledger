package com.powerledger.services;

import com.powerledger.services.pojos.Batteries;
import com.powerledger.services.pojos.BatteryPostRange;
import java.util.concurrent.CompletableFuture;

public interface BatteryService {

  CompletableFuture<Void> createBatteries(Batteries asBatteries);

  CompletableFuture<BatteryPostRange> getBatteries(int from, int to);
}
