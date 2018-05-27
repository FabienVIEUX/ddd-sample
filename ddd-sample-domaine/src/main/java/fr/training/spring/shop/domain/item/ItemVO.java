package fr.training.spring.shop.domain.item;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class ItemVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String description;

	private int price;

	public ItemVO() {
		super();
	}

	public ItemVO(@NotNull String description, int price) {
		this.description = description;
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(@NotNull String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
