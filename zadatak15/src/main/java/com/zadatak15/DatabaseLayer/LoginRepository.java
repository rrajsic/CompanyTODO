package com.zadatak15.DatabaseLayer;

import javax.persistence.EntityManager;

import DataLayer.Login;
import DataLayer.UserType;

/*
 * Communicates with database using Entity Manager which is set in constructor.
 * This class is used for getting UserType (Admin, SuperUser, User).
 */
public class LoginRepository implements ILoginRepository{

	private EntityManager entityManager;

	public LoginRepository(EntityManager entityManager) {
		this.entityManager=entityManager;
	}

	/*
	 * Gets UserType from DB using username and password which are corresponding to username and password rows in Login table in DB
	 */
	public UserType getUsertype(String username, String password) {
		Login login = entityManager.createQuery("SELECT l FROM Login l WHERE l.username =:username",Login.class)
				.setParameter("username", username)
				.getSingleResult();
		if(login != null && login.getPassword().equals(password)) {
			return login.getUserType();
		}else {
			return null;
		}
	}

}
