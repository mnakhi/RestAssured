package photos;

import base.TypicodeAPIClient;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class PhotosAPIClient extends TypicodeAPIClient {
    private String PHOTOS_ENDPOINT = "/photos";
    private String DELETE_PHOTOS_ENDPOINT = "/posts/id";

    public ValidatableResponse getAllPhotos(){
        return when().get(this.baseUri+PHOTOS_ENDPOINT)
                .then();
    }
    public ValidatableResponse addPhotos(Object json){
        return given().header("Content-Type","application/json")
                .body(json)
                .when()
                .post(this.baseUri+PHOTOS_ENDPOINT)
                .then();
    }
    public ValidatableResponse deletePhotos(Object json){
        return given().header("Content-Type","application/json")
                .body(json)
                .when()
                .delete(baseUri+DELETE_PHOTOS_ENDPOINT)
                .then();
    }

}
