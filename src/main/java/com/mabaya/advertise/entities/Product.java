package com.mabaya.advertise.entities;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int price;
	private String title;
	private String category;

	public Product() {
	}

	public Product(String title, String catergory, int price) {

		this.setTitle(title);
		this.setCategory(catergory);
		this.setPrice(price);
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		StringBuilder product = new StringBuilder("Product [id=");

		product.append(this.id);
		product.append(", title=");
		product.append(this.title);
		product.append(", category=");
		product.append(this.category);
		product.append(", price=");
		product.append(this.price);
		product.append("]");
		return product.toString();
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof Product))
			return false;
		Product product = (Product) o;
		return Objects.equals(this.id, product.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}

}
