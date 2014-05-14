package com.pharmaweb.model;

import javax.persistence.EntityManager;

/**
 * 
 * @author Anthony DENAUD
 *
 */
public class DAO {
	
	protected EntityManager entityManager;
	
	public DAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}
}
