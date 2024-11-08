package api.Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.EndPoints.UserEndPointsRoutesImplimentataion;
import api.Payload.UserPojo;
import api.Utilities.Dataproviders;
import io.restassured.response.Response;

public class DataDriverTest  {


	
	@Test(priority=1,dataProvider="Data",dataProviderClass=Dataproviders.class)

public void TestPostuser(String userID,String userName,String fname,String lname,String useremail,String pwd,String ph) {
	
	
		UserPojo pojo=new UserPojo();
	
	
	
		pojo.setId(Integer.parseInt(userID));

		pojo.setUsername(userName);

		pojo.setFirstName(fname);
		pojo.setLastName(lname);

		pojo.setEmail(useremail);
		pojo.setPassword(pwd);

		pojo.setPhone(ph);

	
		
		
		Response response = UserEndPointsRoutesImplimentataion.creatUser(pojo);
		//response.then().log().all();

		AssertJUnit.assertEquals(response.getStatusCode(), 200);

	
}
	
	
	
	
	
	
	
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=Dataproviders.class)
	public void TestDeleteUserByName(String userName) {
		
		
		Response response = UserEndPointsRoutesImplimentataion.DeleteUser(userName);
		AssertJUnit.assertEquals(response.getStatusCode(),200);

		
		
	}
	
	
	
	
	
	
	
	
	
}
