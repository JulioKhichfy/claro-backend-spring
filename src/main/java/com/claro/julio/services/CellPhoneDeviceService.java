package com.claro.julio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claro.julio.domain.CellPhoneDevice;
import com.claro.julio.repositories.CellPhoneDeviceRepository;

@Service
public class CellPhoneDeviceService {

	@Autowired
	private CellPhoneDeviceRepository repo;

	public CellPhoneDevice buscar(Integer id) {
		Optional<CellPhoneDevice> cell = repo.findById(id);
		return cell.orElse(null);
	}	
}
