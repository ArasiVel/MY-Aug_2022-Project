package com.test.helpers;

import java.lang.reflect.Method;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.test.constants.EndPoints;
import com.test.models.AddUserPOJO;
import com.test.models.DeleteUserPOJO;

import com.test.models.GetEmployeeRootPOJO;
import com.test.utils.CommonUtilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserServiceHelper extends ReusableMethods{

@BeforeClass
public void setUp() {
CommonUtilities CU = new CommonUtilities();
Properties PropertiesFile = CU.loadfile("getdataProperties");
RestAssured.baseURI = CU.getProperty("baseuri",PropertiesFile);
}

public static Response getuser() {
Response res = RestAssured
.given()
.when()
.get(EndPoints.GET_DATA);
return res;
}

public static Response createuser() {
CommonUtilities CU = new CommonUtilities();
Properties PropertiesFile = CU.loadfile("getdataProperties");
AddUserPOJO createuserdetails = new AddUserPOJO();
createuserdetails.setEmployee_name(CU.getProperty("name",PropertiesFile));
createuserdetails.setEmployee_salary(CU.getProperty("salary",PropertiesFile));
createuserdetails.setEmployee_age(CU.getProperty("age",PropertiesFile));
createuserdetails.setProfile_image(CU.getProperty("image",PropertiesFile));
System.out.println("got createuserdetails details");
Response res = RestAssured
.given()
.contentType(ContentType.JSON)
.body(createuserdetails)
.when()
.post(EndPoints.CREATE_DATA);
System.out.println("response got it");
return res;

}

public static Response deleteuser() {
	CommonUtilities CU1 = new CommonUtilities();
Properties PropFile1 = CU1.loadfile("getdataProperties");
DeleteUserPOJO deleteuserid = new DeleteUserPOJO();
deleteuserid.setId1(CU1.getProperty("id1",PropFile1));
String idvalue = deleteuserid.getId1();
Response res = RestAssured
.given()
.pathParam("id",idvalue)
.contentType(ContentType.JSON)
.when()
.delete(EndPoints.DELETE_DATA);
return res;
}
public static Response deleteuserAgain() {
	CommonUtilities CU1 = new CommonUtilities();
Properties PropFile1 = CU1.loadfile("getdataProperties");
DeleteUserPOJO deleteuserid = new DeleteUserPOJO();
deleteuserid.setId1(CU1.getProperty("id1",PropFile1));
String idvalue = deleteuserid.getId1();
Response res = RestAssured
.given()
.pathParam("id", 0)
.contentType(ContentType.JSON)
.when()
.delete(EndPoints.DELETE_DATA);
return res;
}
public static Response getEmployeewithid() {
Response res = RestAssured
.given()
.pathParam("id",2)
.contentType(ContentType.JSON)
.when()
.get(EndPoints.GET_SINGLE_DATA);
return res;
}
}




	
	
		
	
	
