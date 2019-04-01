package com.claro.julio.services;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claro.julio.domain.CellPhoneDevice;
import com.claro.julio.repositories.CellPhoneDeviceRepository;

@Service
public class DBService {

	@Autowired
	private CellPhoneDeviceRepository cellPhoneDeviceRepository;

	public void instantiateTestDatabase() throws ParseException {

		System.out.println("carregando o banco...");
		DateFormat f = DateFormat.getDateInstance();
		Date d1 = f.parse("26/11/2015");
		Date d2 = f.parse("25/12/2015");
		Date d3 = f.parse("01/11/2015");

		CellPhoneDevice cpv1 = new CellPhoneDevice(null, new BigDecimal("1990.00"),
				"653d9688-af26-4ff1-b1a6-58c474fba27f", "Moto G5 Plus", "Motorola",
				"http://www3.claro.com.br/sites/default/files/claro-net-simples_5654b06692637-224x170_565c9453ee1bf.png​",
				d1);

		CellPhoneDevice cpv2 = new CellPhoneDevice(null, new BigDecimal("3990.00"),
				"d10e528f-9f2c-4271-9dc1-967bef224695", "IPhone 7 Plus", "Apple",
				"http://www3.claro.com.br/sites/default/files/claro-net-simples_5654b06692637-224x170_565c9453ee1bf.png​",
				d2);

		CellPhoneDevice cpv3 = new CellPhoneDevice(null, new BigDecimal("699.00"),
				"ba59f136-9d1f-42bf-8f4a-826dca8dde5b​", "J7", "Samsung",
				"http://www3.claro.com.br/sites/default/files/claro-net-simples_5654b06692637-224x170_565c9453ee1bf.png​",
				d3);

		cellPhoneDeviceRepository.saveAll(Arrays.asList(cpv1, cpv2, cpv3));
		System.out.println("fim da carga do banco...");
	}

}
