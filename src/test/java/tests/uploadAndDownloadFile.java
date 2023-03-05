package tests;

import io.restassured.response.Response;
import org.fakeStore.endpoints.APIConstants;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class uploadAndDownloadFile extends BaseTest{
    private String getFileName;
    @Test(priority = 1)
    public void testUploadFile(){
        File myFile = new File("src/test/resources/digital_monster.png");
        Response response = given()
                .spec(requestSpecification)
                .multiPart("file", myFile)
                .contentType("multipart/form-data")
                .when()
                .post(APIConstants.uploadFile);

        assertActions.verifyStatusCode(response);
        assertActions.verifyResponseBody((String) apiActions.getDataFromJsonPath(response, "originalname"), myFile.getName(), "It's not the same original name");

        getFileName = response.getBody().jsonPath().getString("filename");

        System.out.println(response.body().prettyPeek());
    }

    @Test(priority = 2)
    public void testDownloadFile(){
        Response response = given()
                .spec(requestSpecification)
                .pathParams("name", getFileName)
                .when()
                .get(APIConstants.downloadFile);

        assertActions.verifyStatusCode(response);
        assertActions.verifyResponseContentType(response, "image/png");
    }
}
