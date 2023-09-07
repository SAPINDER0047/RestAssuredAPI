package api.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoint;
import api.payload.User;
import io.restassured.response.Response;

public class UserTestCase {
	
	//(this is object to create fake data)
	Faker faker;
	User userPayload;
	public static Logger logger;
	
	@BeforeClass
	public void generateTestData()
	{
		faker=new Faker();
		userPayload=new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		//obtain logger
		logger=LogManager.getLogger("RestAssuredHybridFramework");
		
		
	}
	@Test(priority = 1)
	
	public void testCreateUser() {
		
		Response response=UserEndpoint.CreateUser(userPayload);
	      
		 System.out.println("Creata User Data");
		//log the response
		response.then().log().all();
		
		//validation
		
	  Assert.assertEquals(response.getStatusCode(),200);
	
	//log
	  logger.info("create user executed.");
	}
	
	
@Test(priority = 2)
	
	public void testGetUser() {
		
		Response response=UserEndpoint.GetUser(this.userPayload.getUsername());
	  
   System.out.println("Read User data.");		
		//log the response
		response.then().log().all();
		
		//validation
		
	  Assert.assertEquals(response.getStatusCode(),200);
	//log
	  logger.info("Get User Data executed.");
	}
@Test(priority = 3)

public void testUpdateUser() {
	
	userPayload.setFirstName(faker.name().firstName());
	
	Response response=UserEndpoint.UpdateUser(this.userPayload.getUsername(),userPayload);

	//log the response
	response.then().log().all();
	
	//validation
	
  Assert.assertEquals(response.getStatusCode(),200);

  //Read User Data to Check if First name is update
  Response responsePostUpdate=UserEndpoint.GetUser(this.userPayload.getUsername());
 
	 System.out.println(" After Update User data."); 
  responsePostUpdate.then().log().all();
  
//log
  logger.info("Update user executed.");
  
}

@Test(priority = 4)

public void testDeleteUser() {
	
	
	
	Response response=UserEndpoint.DeleteUser(this.userPayload.getUsername());
    
	 System.out.println("User Delete Data");
	//log the response
	response.then().log().all();
	
	//validation
	
  Assert.assertEquals(response.getStatusCode(),200);
//log
  logger.info("Delete user executed.");
}

}
