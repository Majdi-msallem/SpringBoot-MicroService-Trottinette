package org.esprit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Trottinette {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String name;
	private String  Description;
	private int price;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image ;
	public Trottinette(Long id, String name, String description, int price, String image) {
		this.id = id;
		this.name = name;
		Description = description;
		this.price = price;
		this.image = image;
	}
	public Trottinette() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Trottinette [id=" + id + ", name=" + name + ", Description=" + Description + ", price=" + price
				+ ", image=" + image + "]";
	}
	
		

}
