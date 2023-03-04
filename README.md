# API Testing
In this project you can find a framework to test the functionality of API base in a Fake Store where you can find methods for Products, Categories and Users. 

## Rest API
https://fakeapi.platzi.com/en/rest/products

### Using

- Rest Assured
- Java 17
- TestNG
- Jenkins CI

### Test Scenario
- Verify the flow of all product-related methods in an integrated manner.

|       Test Cases       | Test Description                                                                | Method                                                                                        |                                 Expected Result                                 |
|:----------------------:|:--------------------------------------------------------------------------------|:----------------------------------------------------------------------------------------------|:-------------------------------------------------------------------------------:|
|   Add a new product    | Verify if Post request successfully worked sending back a respond               | POST https://api.escuelajs.co/api/v1/products                                                 | Status code 200<br/>Title added<br/>Price added<br/>Description<br/>Image added |
|  Get a product by Id   | Verify if Get request send back a response with data in JSON format             | GET https://api.escuelajs.co/api/v1/products/{id}                                             |                                 Status code 200                                 |
| Update a product by Id | Verify if PUT request with the new data change the previous product information | PUT https://api.escuelajs.co/api/v1/products/{id}                                             |            Status code 200<br/>Title changed<br/> Price changed<br/>            |
| Delete a product by Id | Verify if Delete request remove successfully                                    | DELETE https://api.escuelajs.co/api/v1/products/{id}                                          |          Status code 200<br/>Verify true response with is deleted<br/>          |