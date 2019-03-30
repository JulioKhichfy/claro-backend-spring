package com.claro.julio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claro.julio.domain.CellPhoneDevice;

@Repository
public interface CellPhoneDeviceRepository  extends JpaRepository<CellPhoneDevice, Integer>{

}
