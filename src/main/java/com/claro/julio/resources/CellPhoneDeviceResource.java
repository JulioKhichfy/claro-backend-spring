package com.claro.julio.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.claro.julio.domain.CellPhoneDevice;
import com.claro.julio.services.CellPhoneDeviceService;

@RestController
@RequestMapping(value="/claro")
public class CellPhoneDeviceResource {
	
	@Autowired
	private CellPhoneDeviceService service;
	
	@RequestMapping(value="/mobile", method=RequestMethod.POST)
	public ResponseEntity<Void> insertCellPhone(@RequestBody CellPhoneDevice cell) {
		cell = service.insert(cell);
		//retorno da nova URI do recurso criado
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(cell.getId()).toUri();
		//buildAndExpand pede o id do novo celular criado.
		//TODO:devo usar o code e não o id
		return ResponseEntity.created(uri).build();
		
	}
	
	@RequestMapping(value="/mobile", method=RequestMethod.GET)
	public List<CellPhoneDevice> getAllCellPhone() {
		List<CellPhoneDevice>list = service.findAll();
		return list;
	}
	
	@RequestMapping(value="/mobile/{id}", method=RequestMethod.GET)
	public  ResponseEntity<CellPhoneDevice> getCellPhoneByCode(@PathVariable Integer id) {
		CellPhoneDevice obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/mobile/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody CellPhoneDevice obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/mobile/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
