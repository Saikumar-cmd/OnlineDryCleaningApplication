package com.cg.drycleaning.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class CustomerItem {
	@Id
	private long itemId;
	private String name;
	private String color;
	private String category;
	private int quantity;
	private String material;
	private String description;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;


	public CustomerItem() {
		super();
	}

	public CustomerItem(long itemId, String name, String color, String category, int quantity, String material,
			String description, Customer customer) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.color = color;
		this.category = category;
		this.quantity = quantity;
		this.material = material;
		this.description = description;
		this.customer = customer;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonBackReference
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CustomerItem [itemId=" + itemId + ", name=" + name + ", color=" + color + ", category=" + category
				+ ", quantity=" + quantity + ", material=" + material + ", description=" + description + ", customer="
				+ customer + "]";
	}

}