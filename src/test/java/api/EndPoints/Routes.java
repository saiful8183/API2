package api.EndPoints;


 //Swagger URL: //https://petstore.swagger.io

//Creat user (post):    https://petstore.swagger.io/v2/user
//Get user (Get):       https://petstore.swagger.io/v2/user/{username}
//Update user(Put):     https://petstore.swagger.io/v2/user/{username}
//Delate user(Delete):  https://petstore.swagger.io/v2/user/{username}








public class Routes {

	
	
	
	public static String base_url="https://petstore.swagger.io/v2";
	
	//User Modul
	
	public static String post_url=base_url+"/user";	
	
	public static String get_url=base_url+"/user/{username}";	
	public static String update_url=base_url+"/user/{username}";	
	public static String delete_url=base_url+"/user/{username}";	
	
	
	
	
	
	
}
