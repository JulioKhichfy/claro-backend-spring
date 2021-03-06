package com.claro.julio.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class CellPhoneDevice implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=1, max=40, message="O tamanho deve ser entre 1 e 40 caracteres")
	private String model;
	
	@DecimalMin("0.01")
	@Digits(integer=6, fraction=2)
	private BigDecimal price;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String code;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String brand;
	
	@NotNull
	private String photo;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@NotNull
	private Date date;
	
	public CellPhoneDevice() {
		
	}
	
	public CellPhoneDevice(Integer id,BigDecimal price,String code,String model,String brand, String photo,Date date) {
		super();
		this.id= id;
		this.model= model;
		this.price =price;
		this.code =code;
		this.brand =brand;
		this.photo =photo;
		this.date =date;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CellPhoneDevice other = (CellPhoneDevice) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
