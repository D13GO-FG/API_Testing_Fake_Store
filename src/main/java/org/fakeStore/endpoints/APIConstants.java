package org.fakeStore.endpoints;

public class APIConstants {
    public final static String baseUrl = "https://api.escuelajs.co/api/v1";
    public final static String createProduct = "/products";
    public final static String getProduct = "/products/{id}";
    public final static String updateProduct = "/products/{id}";
    public final static String deleteProduct = "/products/{id}";

    public final static String createUser = "/users";
    public final static String getUser = "/users/{id}";
    public final static String updateUser = "/users/{id}";
    public final static String checkEmail = "/users/is-available";

    public final static String uploadFile = "files/upload";
    public final static String downloadFile = "files/{name}";

    public final static String authJWT = "/auth/login";
    public final static String authSession = "/auth/profile";
    public final static String authRefresh = "/auth/refresh-token";

}
