package org.fakeStore.payload;

import com.github.javafaker.Faker;
import org.fakeStore.dataObjects.ProductDetails;
import org.fakeStore.dataObjects.UserDetails;

import java.util.List;

public class RequestPayloads {
    public ProductDetails setProductPayload(){
        ProductDetails productDetails = new ProductDetails();
        productDetails.setTitle("Pikachu pijana");
        productDetails.setPrice(500);
        productDetails.setDescription("Pijamas Unisexo Franela Adulto Cosplay Pikachu");
        productDetails.setCategoryId(1);
        productDetails.setImages(List.of("https://www.dhresource.com/albu_844327653_00/temp2.0x0.jpg"));
        return productDetails;
    }

    public ProductDetails setToUpdateProductPayload(){
        ProductDetails productDetails = new ProductDetails();
        productDetails.setTitle("Yoda pijana");
        productDetails.setPrice(550);
        return productDetails;
    }

    public UserDetails setUserPayload(){
        Faker faker = new Faker();
        UserDetails userDetails = new UserDetails();
        userDetails.setName(faker.name().firstName());
        userDetails.setEmail(faker.internet().emailAddress());
        userDetails.setPassword(faker.internet().password());
        userDetails.setAvatar(faker.avatar().image());
        return userDetails;
    }
}
