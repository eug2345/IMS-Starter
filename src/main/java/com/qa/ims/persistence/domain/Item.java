package com.qa.ims.persistence.domain;

public class Item {
	
	private Long id;
	private String itemtName;
	private double itemPrice;
	
	public Item(Item item, double itemPrice) {
		
		super();
		this.itemtName = "item";
		this.itemPrice = itemPrice;
	}
	public Item(Long id, String item_Name, double string) { 
		super();
		this.id = id;
		this.itemtName = item_Name;
		this.itemPrice = string;
	}
	public Item(long l, String string, String string2) {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItemtName() { 
		return itemtName;
	}
	public void setItemtName(String itemtName) {
		this.itemtName = itemtName;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", itemtName=" + itemtName + ", itemPrice=" + itemPrice + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(itemPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((itemtName == null) ? 0 : itemtName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(itemPrice) != Double.doubleToLongBits(other.itemPrice))
			return false;
		if (itemtName == null) {
			if (other.itemtName != null)
				return false;
		} else if (!itemtName.equals(other.itemtName))
			return false;
		return true;
	
	}
	
	}
	
	
	
	
	
	



