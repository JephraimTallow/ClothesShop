package com.bjss.clothesStore;

import java.math.BigDecimal;

import org.openqa.selenium.WebElement;

public class ClothingItem {

	private String name;
	private String size;
	private String colour;
	private BigDecimal price;
	
	public ClothingItem(){
	}
	
	public ClothingItem(WebElement name, WebElement size, String colour, WebElement price) {
		this.name = name.getText();
		String sizeStr = size.getText();
		this.size = sizeStr.substring(sizeStr.indexOf("Size : "));
		String priceStr = price.getText();
		this.price = new BigDecimal(priceStr.substring(priceStr.indexOf("$") + 1));
		this.colour = colour;
	}
	public ClothingItem(String name, String size, String colour, BigDecimal price) {
		this.name = name;
		this.size = size;
		this.colour = colour;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ClothingItem [name=" + name + ", size=" + size + ", colour=" + colour + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colour == null) ? 0 : colour.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		ClothingItem other = (ClothingItem) obj;
		if (colour == null) {
			if (other.colour != null)
				return false;
		} else if (!colour.equals(other.colour))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}

}
