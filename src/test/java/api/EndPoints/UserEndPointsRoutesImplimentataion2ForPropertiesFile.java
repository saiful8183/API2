package api.EndPoints;




import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.Payload.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//Implimentation of endpoints
//User Endpoints.java
//Creat for CRUD operatios(cread,Retriev,update,Delete)


public class UserEndPointsRoutesImplimentataion2ForPropertiesFile {

	
	
 static ResourceBundle getURL() {
		
		
	 
	 
	 // Created for getting URL from properties fille
	 
	 
		ResourceBundle routes=ResourceBundle.getBundle("Routes");//Load the properties file.here Routes is properti file name which automatically witt trigared propertifile.
		
		return routes;
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static Response creatUser(UserPojo payload) {
		
		
		
		String post_url=getURL().getString("post_url");  //for properties file
		
		
		
		
		
	Response response=given()
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.body(payload)
	
	.when()
	.post(post_url);
	
	
		return response;
		
	}
	
	
	public static Response readUser(String userName) {
		
		
		String get_url=getURL().getString("get_url");   //for properties file
		
		
		
		Response response=given()
				.pathParam("username", userName)
				
				.when()
				.get(get_url);
		
		
		return response;
		
	}
	
	
	
	public static Response UpdateUser(String userName,UserPojo payload) {
		
		
		
		
		String update_url=getURL().getString("update_url");   //for properties file
		
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", "userName")
		.body(payload)
		
		.when()
		.put(update_url);
		
		
			return response;
			
		}
	
	
public static Response DeleteUser(String userName) {
		
		
	
	String delate_url=getURL().getString("delate_url");   //for properties file
	
		Response response=given()
		
		.pathParam("username", "userName")
	
		
		.when()
		.delete(delate_url);
		
		
			return response;
			
		}
	
	
}
