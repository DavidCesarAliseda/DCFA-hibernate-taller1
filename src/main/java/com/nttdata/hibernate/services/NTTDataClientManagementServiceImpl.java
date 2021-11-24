package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.models.NTTDataClient;
import com.nttdata.hibernate.persistence.NTTDataClientDaoI;
import com.nttdata.hibernate.persistence.NTTDataClientDaoImpl;

public class NTTDataClientManagementServiceImpl implements NTTDataClientManagementServiceI {

	private NTTDataClientDaoI clienteDao;

	/**
	 * Método constructor
	 */
	public NTTDataClientManagementServiceImpl(Session session) {
		this.clienteDao = new NTTDataClientDaoImpl(session);
	}

	@Override
	public void insertNewClient(NTTDataClient newClient) {
		// Verificaci�n de nulidad e inexistencia.
		if (newClient != null && newClient.getId() == null) {

			// Insercci�n del nuevo jugador.
			clienteDao.insert(newClient);
		}

	}

	@Override
	public void updateClient(NTTDataClient updatedClient) {
		// Verificaci�n de nulidad e inexistencia.
		if (updatedClient != null && updatedClient.getId() != null) {

			// Insercci�n del nuevo jugador.
			clienteDao.update(updatedClient);
		}

	}

	@Override
	public void deleteClient(NTTDataClient deletedClient) {
		// Verificaci�n de nulidad e inexistencia.
		if (deletedClient != null && deletedClient.getId() != null) {

			// Insercci�n del nuevo jugador.
			clienteDao.delete(deletedClient);
		}

	}

	@Override
	public NTTDataClient searchById(Long clientId) {
		// Resultado.
		NTTDataClient client = null;

		// Verificaci�n de nulidad.
		if (clientId != null) {

			// Obtenci�n del jugador por ID.
			client = clienteDao.searchById(clientId);
		}

		return client;
	}

	@Override
	public List<NTTDataClient> searchAll() {
		List<NTTDataClient> clientList = new ArrayList<NTTDataClient>();
		clientList = clienteDao.searchAll();
		return clientList;
	}

	@Override
	public List<NTTDataClient> searchByNameAndSurname(String name, String surname1) {
		// Resultado.
		List<NTTDataClient> clientList = new ArrayList<NTTDataClient>();

		// Obtenci�n de jugadores.
		clientList = clienteDao.searchByNameAndSurname(name, surname1);

		return clientList;
	}

}
