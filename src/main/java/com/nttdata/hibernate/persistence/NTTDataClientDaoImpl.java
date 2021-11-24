package com.nttdata.hibernate.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.nttdata.hibernate.models.NTTDataClient;
/**
 * Taller 1 - Hibernate
 * 
 * DAO implementado de tabla NTTDataClient
 * 
 * @author David Cesar Fernandez Aliseda
 *
 */
public class NTTDataClientDaoImpl extends CommonDaoImpl<NTTDataClient> implements NTTDataClientDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public NTTDataClientDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NTTDataClient> searchByNameAndSurname(String name, String surname1) {
		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza jugadores en función del nombre.
		final List<NTTDataClient> clientsList = session
				.createQuery("FROM NTTDataClient WHERE name= '" + name + "' AND surname1='" + surname1 + "'").list();

		return clientsList;
	}

}
