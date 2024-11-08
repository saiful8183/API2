package api.Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.EndPoints.UserEndPointsRoutesImplimentataion;
import api.EndPoints.UserEndPointsRoutesImplimentataion2ForPropertiesFile;
import api.Payload.UserPojo;
import api.Utilities.ExtentReportManager;
import io.restassured.response.Response;

public class UserTests2UserEndPointsRoutesImplimentataion2ForPropertiesFile {

	Faker faker;
	UserPojo userPaylod;
	public Logger logger;  //for logs

	@BeforeClass
	public void Setup() {

		faker = new Faker();
		userPaylod = new UserPojo();

		userPaylod.setId(faker.idNumber().hashCode());

		userPaylod.setUsername(faker.name().username());

		userPaylod.setFirstName(faker.name().firstName());
		userPaylod.setLastName(faker.name().lastName());

		userPaylod.setEmail(faker.internet().safeEmailAddress());
		userPaylod.setPassword(faker.internet().password(5, 10));

		userPaylod.setPhone(faker.phoneNumber().cellPhone());

		
		
		//Logs
		
		
		logger=LogManager.getLogger(this.getClass());		
		
		
		
	}

	@Test(priority = 1)
	public void TestPostuser() {

		
		logger.info("===========Creating User==================");
		
		Response response = UserEndPointsRoutesImplimentataion2ForPropertiesFile.creatUser(userPaylod);
		response.then().log().all();

		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		logger.info("=========== User is created==================");

	}

	@Test(priority = 2)
	public void testGetUserByName() {

		
		logger.info("=========== Reading User info==================");
		Response response = UserEndPointsRoutesImplimentataion2ForPropertiesFile.readUser(this.userPaylod.getUsername());
		response.then().log().all();

		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		logger.info("=========== User info is displayed==================");

	}

	@Test(priority = 3)
	public void TestUpdateuserByName() {

		
		
		logger.info("=========== Updating User ==================");

		// Update data using payload

		userPaylod.setFirstName(faker.name().firstName());
		userPaylod.setLastName(faker.name().lastName());

		userPaylod.setEmail(faker.internet().safeEmailAddress());

		Response response = UserEndPointsRoutesImplimentataion2ForPropertiesFile.UpdateUser(this.userPaylod.getUsername(), userPaylod);

		response.then().log().body();

		response.then().log().body().statusCode(200);

		
		logger.info("=========== User is updated ==================");

		// Assert.assertEquals(response.getStatusCode(), 200);

		// Chicking data after update

		Response responseafterUpdate = UserEndPointsRoutesImplimentataion2ForPropertiesFile.readUser(this.userPaylod.getUsername());
		response.then().log().all();

		AssertJUnit.assertEquals(responseafterUpdate.getStatusCode(), 200);

	}

	@Test(priority = 4)
	public void testDeleteUserByName() {

		
		logger.info("=========== Deleting User==================");

		Response response = UserEndPointsRoutesImplimentataion2ForPropertiesFile.DeleteUser(this.userPaylod.getUsername());
		AssertJUnit.assertEquals(response.getStatusCode(),404);
		logger.info("===========  User deleted==================");

	}
	@Test(priority = 4)
	public void testDeleteUserByName2() {
		
		
		logger.info("=========== Deleting User==================");
		
		Response response = UserEndPointsRoutesImplimentataion2ForPropertiesFile.DeleteUser(this.userPaylod.getUsername());
		AssertJUnit.assertEquals(response.getStatusCode(),404);
		logger.info("===========  User deleted==================");
		
	}

}
