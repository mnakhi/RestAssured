package users;

import base.TypicodeAPIClient;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestUsersAPI extends TypicodeAPIClient {
    UsersAPIClient usersAPIClient;
    @BeforeClass
    public void setUpUsersAPI(){
        this.usersAPIClient = new UsersAPIClient();
    }
    @Test
    public void testUserGetAllUsersList(){
        ValidatableResponse response = usersAPIClient.getAllUsers();
        response.statusCode(200);
    }
    @Test
    public void testUserCanAddUserSuccessfully(){
        String name= "John Smith";
        String username= "Johnn";
        String email = "Sincere@april.biz";
        String phone= "1-770-736-8031 x56442";
        String website= "hildegard.org";

    }
}
