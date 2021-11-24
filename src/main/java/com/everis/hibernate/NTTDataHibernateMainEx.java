package com.everis.hibernate;

import java.util.Date;

import org.hibernate.Session;

import com.nttdata.hibernate.models.NTTDataClient;
import com.nttdata.hibernate.services.NTTDataClientManagementServiceI;
import com.nttdata.hibernate.services.NTTDataClientManagementServiceImpl;

/**
 * Taller1 - Hibernate - 
 * 
 * Clase principal
 * 
 * @author David Cesar Fernandez Aliseda
 *
 */
public class NTTDataHibernateMainEx {

	/**
	 * Metodo principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Apertura de sesión.
		final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios.
		final NTTDataClientManagementServiceI clientService = new NTTDataClientManagementServiceImpl(session);

		// Auditoría.
		final String updatedUser = "NTTDATACLIENT_SYS";
		final Date updatedDate = new Date();
		
		NTTDataClient c1 = new NTTDataClient("Pepe", "Garcia", "Gonzalez", "52269541F");
		c1.setUpdatedUser(updatedUser);
		c1.setUpdatedDate(updatedDate);
		clientService.insertNewClient(c1);
		
		NTTDataClient c2 = new NTTDataClient("Manuel", "Sanchez", "Fernandez", "52269541G");
		c2.setUpdatedUser(updatedUser);
		c2.setUpdatedDate(updatedDate);
		clientService.insertNewClient(c2);
		
		c2.setSurname2("Gonzalez");
		clientService.updateClient(c2);
		
		System.out.println(clientService.searchById((long) 1));
		System.out.println(clientService.searchAll());
		System.out.println(clientService.searchByNameAndSurname("Manuel", "Sanchez"));
		clientService.deleteClient(c2);
	
		
		session.close();
	}

}
