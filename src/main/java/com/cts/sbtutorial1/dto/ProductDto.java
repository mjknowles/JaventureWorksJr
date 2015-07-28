package com.cts.sbtutorial1.dto;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.cts.sbtutorial1.domain.Store;

@Component
public class ProductDto {
    private Integer id;

    private Store store;
    
    private String productId;
    private String description;
    private String imageUrl;
    private String name;
    private BigDecimal price;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
    
	
	@Override
    public String toString(){
    	return name;
    }
}
