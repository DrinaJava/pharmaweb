package com.pharmaweb.www;

import java.util.ArrayList;
import java.util.List;

import com.pharmaweb.controller.IMedicineBean;
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
			this.lines.add(new CartLine(this.bean.getByID(idProduit), 1));
		} else {
			int index = containsProduct(idProduit);
			if (index >= 0) {
				lines.get(index).setQuantite(lines.get(index).getQuantite()+1);
			} else {
				this.lines.add(new CartLine(this.bean.getByID(idProduit), 1));
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
}
