package com.nttdata.hibernate.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import com.nttdata.hibernate.persistence.AbstractEntity;

/**
 * Esta clase define el objeto NTTDataClient el cual representa un cliente.
 * @author David César Fernández Aliseda
 * @version 17/11/21/A
 */

@Entity
@Table(name = "NTTDATA_CLIENTE")
public class NTTDataClient extends AbstractEntity implements Serializable{
	
	private Long id;
	private String name;
	private String surname1;
	private String surname2;
	private String dni;
	
	/**
     * Constructor para NTTDataClient
     */
	
	public NTTDataClient(String name, String surname1, String surname2, String dni) {
		super();
		this.name = name;
		this.surname1 = surname1;
		this.surname2 = surname2;
		this.dni = dni;
	}

	//ID
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	//Name
	@Column(name = "CLIENT_NAME", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//Surname1
	@Column(name = "CLIENT_SURNAME1", nullable = false)
	public String getSurname1() {
		return surname1;
	}
	public void setSurname1(String surname1) {
		this.surname1 = surname1;
	}
	//Surname2
	@Column(name = "CLIENT_SURNAME2", nullable = false)
	public String getSurname2() {
		return surname2;
	}
	public void setSurname2(String surname2) {
		this.surname2 = surname2;
	}
	//DNI
	@Column(name = "CLIENT_DNI", unique=true ,nullable = false, length=9)
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	/**
     * Método para construir una cadena con el los atributos del objeto.
     */
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", name=" + name + ", surname1=" + surname1 + ", surname2=" + surname2 + ", dni="
				+ dni + "]";
	}
	
	@Transient
	public Class<?> getClase() {
		return NTTDataClient.class;
	}
	
	
	
	
}
