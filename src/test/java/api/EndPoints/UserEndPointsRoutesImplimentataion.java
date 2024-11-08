package api.EndPoints;




import static io.restassured.RestAssured.given;

import api.Payload.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//Implimentation of endpoints
//User Endpoints.java
//Creat for CRUD operatios(cread,Retriev,update,Delete)


public class UserEndPointsRoutesImplimentataion {

	
	
	public static Response creatUser(UserPojo payload) {
		
		
	Response response=given()
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.body(payload)
	
	.when()
	.post(Routes.post_url);
	
	
		return response;
		
	}
	
	
	public static Response readUser(String userName) {
		
		
		Response response=given()
				.pathParam("username", userName)
				
				.when()
				.get(Routes.get_url);
		
		
		return response;
		
	}
	
	
	
	public static Response UpdateUser(String userName,UserPojo payload) {
		
		
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", "userName")
		.body(payload)
		
		.when()
		.put(Routes.update_url);
		
		
			return response;
			
		}
	
	
public static Response DeleteUser(String userName) {
		
		
		Response response=given()
		
		.pathParam("username", "userName")
	
		
		.when()
		.delete(Routes.delete_url);
		
		
			return response;
			
		}
	
	
}
