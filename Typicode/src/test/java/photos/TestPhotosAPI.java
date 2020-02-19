package photos;

import base.TypicodeAPIClient;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPhotosAPI extends TypicodeAPIClient {
    PhotosAPIClient photosAPIClient;
    @BeforeClass
    public void setUpPhotosAPI(){
        this.photosAPIClient = new PhotosAPIClient();
    }
    @Test
    public void testUserGetAllPhotos(){
        ValidatableResponse response = photosAPIClient.getAllPhotos();
        response.statusCode(200);
    }
    @Test
    public void testUserCanPostPhotoSuccessfully(){
        int albumId = 1;
        String title = "fun day";
        String url= "https://via.placeholder.com/600/24f355";
        String thumbnailUrl= "https://via.placeholder.com/150/24f355";
        JSONObject json = new JSONObject();
        json.put("albumId",albumId);
        json.put("id",51);
        json.put("title",title);
        json.put("url",url);
        json.put("thumbnailUrl",thumbnailUrl);
        ValidatableResponse response = this.photosAPIClient.addPhotos(json);
        response.statusCode(HttpStatus.SC_CREATED);
        int actualAlbumId = response.extract().body().path("albumId");
        String actualTitle = response.extract().body().path("title");
        String actualUrl = response.extract().body().path("url");
        String actualThumbNailUrl = response.extract().body().path("thumbnailUrl");
        Assert.assertEquals(actualAlbumId,albumId);
        Assert.assertEquals(actualTitle,title);
        Assert.assertEquals(actualUrl, url);
        Assert.assertEquals(actualThumbNailUrl,thumbnailUrl);

    }
    @Test
    public void testUserCanDeletePhotosSuccessfully(){
        int albumId = 10;
        String title= "hello world";
        String url= "https://via.placeholder.com/600/92c952";
        String thumbnailUrl= "https://via.placeholder.com/150/92c952";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("albumId",albumId);
        jsonObject.put("id", 3);
        jsonObject.put("title",title);
        jsonObject.put("url",url);
        jsonObject.put("thumbnailUrl",thumbnailUrl);
        ValidatableResponse response = photosAPIClient.deletePhotos(jsonObject);
        response.statusCode(HttpStatus.SC_OK);
    }
}
