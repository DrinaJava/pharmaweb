package com.pharmaweb.controller.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Bean {
	@PersistenceContext(unitName="pharmawebEJB")
	protected EntityManager em;	


}
