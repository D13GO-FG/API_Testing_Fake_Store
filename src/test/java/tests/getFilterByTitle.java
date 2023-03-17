package tests;

import io.restassured.response.Response;
import org.fakeStore.endpoints.APIConstants;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getFilterByTitle extends BaseTest{
    @Test
    public void testGetFilterByTitle(){
        Response response = given()
                .spec(requestSpecification)
                .queryParam("title", "Generic")
                .when()
                .get(APIConstants.createProduct);
        assertActions.verifyStatusCode(response);
        System.out.println((String) apiActions.getDataFromJsonPath(response, "[0].title"));
        assertActions.verifyResponseBodyElementContentString(apiActions.getDataFromJsonPath(response, "[0].title"), "Generic", "Title don't content generic");
        System.out.println(response.body().prettyPeek());
    }
}
