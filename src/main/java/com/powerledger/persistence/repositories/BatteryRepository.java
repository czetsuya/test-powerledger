package com.powerledger.persistence.repositories;

import com.powerledger.persistence.entities.BatteryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatteryRepository extends JpaRepository<BatteryEntity, Long> {

  List<BatteryEntity> findByPostCodeBetween(int from, int to);
}
