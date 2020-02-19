package users;

import base.TypicodeAPIClient;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class UsersAPIClient extends TypicodeAPIClient {
    private String USER_ENDPOINT="/users";
    public ValidatableResponse getAllUsers(){
        return when().get(baseUri+USER_ENDPOINT)
                .then();
    }
    public ValidatableResponse addUsers(Object json){
        return given().header("Content-Type","application/json")
                .body(json)
                .when()
                .post(this.baseUri+USER_ENDPOINT)
                .then();
    }
}
