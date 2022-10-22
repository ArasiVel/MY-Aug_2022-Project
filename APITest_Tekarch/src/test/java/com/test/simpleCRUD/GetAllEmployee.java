package com.test.simpleCRUD;

import java.io.IOException;

import org.testng.annotations.Test;
import com.test.helpers.UserServiceHelper;

import com.test.models.GetEmployeeRootPOJO;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
	
	public class GetAllEmployee extends UserServiceHelper {
		
			public static void getEmployees() {

			Response res = getuser();
			GetEmployeeRootPOJO employeelist = res.as(GetEmployeeRootPOJO.class);
			System.out.println(employeelist);
			getStatusCode(res);
			verifystatuscode(res,200);
			validate_equal(res,"status","success");
			String size = GetDataFromResponse(res,"data.size()");
			System.out.println("No of employees datas :"+size);

		}
}
