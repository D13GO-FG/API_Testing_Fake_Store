package org.fakeStore.dataObjects;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"title", "price", "description", "categoryId", "images"})
public class ProductDetails {
    private String title;
    private int price;
    private String description;
    private int categoryId;
    private List<String> images;

    public ProductDetails(String title, int price, String description, int categoryId, List<String> images){
        this.title = title;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
        this.images = images;
    }

    public ProductDetails() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
