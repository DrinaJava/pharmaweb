package com.pharmaweb.controller.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import com.pharmaweb.contoller.IOrderBean;
import com.pharmaweb.model.OrderDAO;
import com.pharmaweb.model.entities.CommandeClient;
import com.pharmaweb.model.entities.CommandeLotProduit;
/**
 * @author Mnky
 *
 */
/**
 * Session Bean implementation class OrderBean
 */
@Stateless
public class OrderBean extends Bean implements IOrderBean {

	private OrderDAO orderDAO;

	@PostConstruct
	protected void init(){
		this.orderDAO = new OrderDAO(this.em);
	}

	@Override
	public List<CommandeClient> getAll() {
		return this.orderDAO.getAll();
	}


	@Override
	public CommandeClient getOrderById(final int id) {
		return this.orderDAO.getOrderById(id);
	}

	/* (non-Javadoc)
	 * @see com.pharmaweb.contoller.IOrderBean#getOrderLine(int)
	 */
	@Override
	public List<CommandeLotProduit> getOrderLines(final int idOrder) {
		return this.orderDAO.getOrderLines(idOrder);
	}

}
