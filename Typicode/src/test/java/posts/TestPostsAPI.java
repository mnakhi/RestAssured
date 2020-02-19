package posts;

import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPostsAPI {

    private PostsAPIClient postsAPIClient;

    @BeforeClass
    public void setUpPostsAPI() {
        this.postsAPIClient = new PostsAPIClient();
    }

    // write a test that calls on PostsAPIClient.getAllPosts()
    // also check to see if it returns a 200 status code
    @Test
    public void testGetAllPosts() {
        ValidatableResponse response = this.postsAPIClient.getAllPosts();
        response.statusCode(HttpStatus.SC_OK);
    }

    // write a test that creates a post
    @Test
    public void testUserCanCreateAPostUsingPojoSuccessfully() {
        PostPojo obj =
                new PostPojo(11, 101, "test title", "test body");
        ValidatableResponse response = this.postsAPIClient.createPost(obj);
        response.statusCode(HttpStatus.SC_CREATED);
    }

    @Test
    public void testUserCanCreateAPostSuccessfully() {
        int userId = 11;
        String title = "test title";
        String body = "test body";
        JSONObject json = new JSONObject();
        json.put("userId", userId);
        json.put("id", 101);
        json.put("title", title);
        json.put("body", body);
        ValidatableResponse response = this.postsAPIClient.createPost(json);
        response.statusCode(HttpStatus.SC_CREATED);
        int actualUserId = response.extract().body().path("userId");
        String actualTitle = response.extract().body().path("title");
        String actualBody = response.extract().body().path("body");
        Assert.assertEquals(actualUserId, userId);
        Assert.assertEquals(actualTitle, title);
        Assert.assertEquals(actualBody, body);
    }
    @Test
    public void testUserCanCreateACommentSuccessfully() {
        int postId = 11;
        String name = "id labore ex et quam laborum";
        String email = "fakeid@yahoo.com";
        String body="laudantium enim quasi est quidem magnam voluptate ipsam eos\\ntempora quo necessitatibus\\ndolor quam autem quasi\\nreiciendis et nam sapiente accusantium";
        JSONObject json = new JSONObject();
        json.put("postId", postId);
        json.put("id", 11);
        json.put("name", name);
        json.put("email", email);
        json.put("body", body);
        ValidatableResponse response = this.postsAPIClient.createPost(json);
        response.statusCode(HttpStatus.SC_CREATED);
        int actualPostId = response.extract().body().path("postId");
        String actualName = response.extract().body().path("name");
        String actualEmail = response.extract().body().path("email");
        String actualBody = response.extract().body().path("body");
        Assert.assertEquals(actualPostId, postId);
        Assert.assertEquals(actualName, name);
        Assert.assertEquals(actualEmail, email);
        Assert.assertEquals(actualBody, body);
    }
}
