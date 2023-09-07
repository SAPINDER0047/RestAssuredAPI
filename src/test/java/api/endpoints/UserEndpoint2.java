package api.endpoints;
import static io. restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class UserEndpoint2 {
	
	static ResourceBundle getUrl()
	{
		ResourceBundle routes=ResourceBundle.getBundle("Routes");   //here Load propertie file
		return routes;
		
	}
 public static Response CreateUser(User payload)
 {
	 //create string variable
	 String post_url=getUrl().getString("post_url");
	Response response=given().
	 accept(ContentType.JSON).
	 contentType(ContentType.JSON).
	 body(payload)
	 .when()
	 .post(post_url);
	return response;
 }
 
 public static Response GetUser(String username)
 {
	 String get_url=getUrl().getString("get_url");
	Response response=given().
	 accept(ContentType.JSON).
	pathParam("username", username)
	 
	 .when()
	 .get(get_url);
	return response;
 }
 public static Response UpdateUser(String username, User payload)
 {
	 String update_url=getUrl().getString("update_url");
	Response response=given().
	 accept(ContentType.JSON).
	 contentType(ContentType.JSON).pathParam("username", username)
	 .body(payload)
	 .when()
	 .put(update_url);
	return response;
 }
 
	
 public static Response DeleteUser(String username)
 {
	 String delete_url=getUrl().getString("delete_url");
	Response response=given()
	 .accept(ContentType.JSON)
	 .pathParam("username", username)
	 .when()
	 .delete(delete_url);
	return response;
 }
 
	
	
}
