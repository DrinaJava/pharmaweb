package com.pharmaweb.controller.bean;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Bean {
	@PersistenceContext(unitName="pharmawebEJB")
	protected EntityManager em;	

	@PostConstruct
	protected void init(){

	}
}
