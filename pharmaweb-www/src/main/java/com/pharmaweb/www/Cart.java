package com.pharmaweb.www;

import java.util.ArrayList;
import java.util.List;

import com.pharmaweb.controller.IMedicineBean;
import com.pharmaweb.model.entities.LotProduit;
import com.pharmaweb.model.entities.PharmacieStock;
import com.pharmaweb.www.CartLine;

/**
 * 
 * @author Anthony DENAUD
 * 
 */
public class Cart {

	private List<CartLine> lines;
	private IMedicineBean bean;

	public Cart(IMedicineBean bean) {
		this.bean = bean;
		this.lines = new ArrayList<CartLine>();
	}

	public Cart(IMedicineBean bean, List<CartLine> lines) {
		this.lines = lines;
		this.bean = bean;
	}

	public List<CartLine> getLines() {
		return lines;
	}

	public void setLines(List<CartLine> lines) {
		this.lines = lines;
	}

	public void delete(int idProduit) {
		int index = containsProduct(idProduit);
		if (index >= 0 && lines.get(index).getQuantite() > 0) {
			lines.get(index).setQuantite(lines.get(index).getQuantite()-1);
		} else {
			this.lines.remove(this.lines.get(index));
		}
	}

	public void add(int idProduit) {
		if (lines.size() == 0) {
			this.lines.add(new CartLine(this.bean.getByID(idProduit), 1, this.getProductPrice(idProduit)));
		} else {
			int index = containsProduct(idProduit);
			if (index >= 0) {
				lines.get(index).setQuantite(lines.get(index).getQuantite()+1);
			} else {
				this.lines.add(new CartLine(this.bean.getByID(idProduit), 1, this.getProductPrice(idProduit)));
			}
		}
	}

	private int containsProduct(int idProduit) {
		int result = -1;

		for (CartLine line : this.lines) {

			if (line.getProduit().getIdProduit() == idProduit) {
				result = lines.indexOf(line);
			}
		}
		return result;
	}
	
	private double getProductPrice(int idProduit){
		//TODO fix pharmacie id
		LotProduit lot = bean.getLotFromProduct(idProduit, 1, 1);
		PharmacieStock stock = this.bean.getPharmacieStockByLot((int) lot.getIdLotProduit());
		return stock.getPrixUnitaireProduit().doubleValue();
	}

	public double getTotalHT() {
		
		double total = 0;
		
		for (CartLine line : this.lines) {
			total += (line.getPuht() * line.getQuantite());
		}
		
		return total;
	}
}
