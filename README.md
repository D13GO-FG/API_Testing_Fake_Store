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

### Test Scenario
- Verify the flow of all user-related methods in an integrated manner.

|     Test Cases      | Test Description                                                                | Method                                                                                              |                               Expected Result                                |
|:-------------------:|:--------------------------------------------------------------------------------|:----------------------------------------------------------------------------------------------------|:----------------------------------------------------------------------------:|
|   Add a new user    | Verify if Post request successfully worked sending back a respond               | POST https://api.escuelajs.co/api/v1/users                                                          | Status code 200<br/>Name added<br/>Email added<br/>password<br/>Avatar added |
|  Get a user by Id   | Verify if Get request send back a response with data in JSON format             | GET https://api.escuelajs.co/api/v1/users/{id}                                                      |                               Status code 200                                |
| Update a user by Id | Verify if PUT request with the new data change the previous product information | PUT https://api.escuelajs.co/api/v1/users/{id}                                                      |           Status code 200<br/>Name changed<br/> Email changed<br/>           |
| Check email is used | Verify if an email is already registered in the API (false to confirmed)        | POST https://api.escuelajs.co/api/v1/users/is-available                                             |              Status code 200<br/>Verify isAvailable: false<br/>              |

### Test Scenario
- Verify the flow of all files-related methods in an integrated manner.

|       Test Cases       | Test Description                                                                      | Method                                            |                   Expected Result                    |
|:----------------------:|:--------------------------------------------------------------------------------------|:--------------------------------------------------|:----------------------------------------------------:|
|     Upload a file      | Verify if Post request successfully worked and response with the file's original name | POST https://api.escuelajs.co/api/v1/files/upload |    Status code 200<br/>Original name correct<br/>    |
| Download previous file | Verify if Get request send back a status 200 and check if content type is image png   | GET https://api.escuelajs.co/api/v1/files/{name}  | Status code 200 <br/>Content-Type equal to image/png |

### Test Scenario
- Verify the flow of all authentication-related methods in an integrated manner.

|                 Test Cases                  | Test Description                                                                           | Method                                                    |                                           Expected Result                                           |
|:-------------------------------------------:|:-------------------------------------------------------------------------------------------|:----------------------------------------------------------|:---------------------------------------------------------------------------------------------------:|
|               Authentication                | Verify successful authentication getting access token and refresh token                    | [POST] https://api.escuelajs.co/api/v1/auth/login         |                Status code 200<br/>Access token non null<br/>Refresh token non null                 |
|            Get user with session            | Verify if email and password are the same that previous credentials used in authentication | [GET] https://api.escuelajs.co/api/v1/auth/profile        | Status code 200 <br/>Email equal to previous credentials<br/>Password equal to previous credentials |
| Get a new access token with a refresh token | Verify if access token and refresh token are different than previous ones                  | [POST] https://api.escuelajs.co/api/v1/auth/refresh-token |            Status code 200 <br/>Access token is different<br/>Refresh token is different            |

### Test Scenario
- Verify the flow of the correct filter to get product in the API

|          Test Cases           | Test Description                                      | Method                                                                                                                |                          Expected Result                           |
|:-----------------------------:|:------------------------------------------------------|:----------------------------------------------------------------------------------------------------------------------|:------------------------------------------------------------------:|
|  Get Pagination of products   | Verify successful pagination base in query parameters | [GET] https://api.escuelajs.co/api/v1/products?offset=0&limit=10                                                      |               Status code 200<br/>Equal size of list               |
| Get products by word in title | Verify if elements have in the title key word         | [GET] https://api.escuelajs.co/api/v1/products/?title=Generic                                                         | Status code 200 <br/>First product has title with the word generic |
|     Get products by price     | Verify successful elements appeared                   | [GET] https://api.escuelajs.co/api/v1/products/price=100                                                              |                          Status code 200                           |
|  Get products by price range  | Verify successful elements appeared                   | [GET] https://api.escuelajs.co/api/v1/products/?price_min=900&price_max=1000                                          |                          Status code 200                           |
|   Get products by category    | Verify if elements are of a specific category         | [GET] https://api.escuelajs.co/api/v1/products/?categoryId=1                                                          |     Status code 200<br/>First product have to be that category     |
| Get products by multi filters | Verify if elements are all the filters                | [GET]https://api.escuelajs.co/api/v1/products/?title=Generic&price_min=900&price_max=1000&categoryId=1                |                          Status code 200                           |
|                               |                                                       | [GET]https://api.escuelajs.co/api/v1/products/?price_min=900&price_max=1000&categoryId=1                              |                          Status code 200                           |

