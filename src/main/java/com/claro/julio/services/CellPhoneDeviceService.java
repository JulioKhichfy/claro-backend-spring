package com.claro.julio.services;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.claro.julio.domain.CellPhoneDevice;
import com.claro.julio.repositories.CellPhoneDeviceRepository;
import com.claro.julio.services.exceptions.ObjectNotFoundException;

@Service
public class CellPhoneDeviceService {

	@Autowired
	private CellPhoneDeviceRepository repo;

	public CellPhoneDevice find(Integer id) {
		Optional<CellPhoneDevice> cell = repo.findById(id);
		// capturada por resources - @ControllerAdvice -
		return cell.orElseThrow(() -> new ObjectNotFoundException(
				"Celular não encontrado: " + id + ", Tipo: " + CellPhoneDevice.class.getName()));
	}

	public List<CellPhoneDevice> findAll() {
		return repo.findAll();
	}

	@Transactional
	public CellPhoneDevice insert(CellPhoneDevice cell) {
		cell.setId(null);
		return repo.save(cell);
	}

	public CellPhoneDevice update(CellPhoneDevice obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
