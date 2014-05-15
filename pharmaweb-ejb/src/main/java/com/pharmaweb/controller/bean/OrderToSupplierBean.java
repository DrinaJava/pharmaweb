package com.pharmaweb.controller.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import com.pharmaweb.controller.IOrderToSupplierBean;
import com.pharmaweb.model.OrderToSupplierDAO;
import com.pharmaweb.model.entities.CommandeFournisseur;
import com.pharmaweb.model.entities.CommandeFournisseurProduit;
/**
 * @author Mnky
 *
 */
/**
 * Session Bean implementation class OrderToSupplierBean
 */
@Stateless
public class OrderToSupplierBean extends Bean implements IOrderToSupplierBean {

	private OrderToSupplierDAO orderToSupplierDAO;

	@PostConstruct
	protected void init(){
		this.orderToSupplierDAO = new OrderToSupplierDAO(this.em);
	}

	@Override
	public List<CommandeFournisseur> getAll() {
		return this.orderToSupplierDAO.getAll();

	}


	@Override
	public CommandeFournisseur getOrderById( final int id) {
		return this.orderToSupplierDAO.getOrderById(id);

	}


	@Override
	public List<CommandeFournisseurProduit> getOrderLines( final int idOrderToSupplier) {
		return this.orderToSupplierDAO.getOrderLines(idOrderToSupplier);
	}

}
