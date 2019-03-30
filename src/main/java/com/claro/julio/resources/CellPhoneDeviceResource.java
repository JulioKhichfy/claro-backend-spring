package com.claro.julio.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.claro.julio.domain.CellPhoneDevice;
import com.claro.julio.services.CellPhoneDeviceService;

@RestController
@RequestMapping(value="/claro")
public class CellPhoneDeviceResource {
	
	@Autowired
	private CellPhoneDeviceService service;
	
	@RequestMapping(value="/mobile", method=RequestMethod.POST)
	public String insertCellPhone() {
		return "";
	}
	
	@RequestMapping(value="/mobile", method=RequestMethod.GET)
	public List<CellPhoneDevice> getAllCellPhone() {
		return new ArrayList<CellPhoneDevice>();
	}
	
	@RequestMapping(value="/mobile/{id}", method=RequestMethod.GET)
	public  ResponseEntity<?> getCellPhoneByCode(@PathVariable Integer id) {
		CellPhoneDevice obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
