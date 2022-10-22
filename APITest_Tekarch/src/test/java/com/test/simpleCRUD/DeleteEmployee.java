package com.test.simpleCRUD;

import org.hamcrest.Matchers;

import com.test.helpers.UserServiceHelper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;


	public class DeleteEmployee extends UserServiceHelper {
		public static void delete_emp() {
		Response Deleteresonse = deleteuser();
		ResponsePrint(Deleteresonse);
		verifystatuscode(Deleteresonse,200);
		validate_equal(Deleteresonse,"status","success");
		}
	
		public static void delete_again() {
			Response Deleteresponse = deleteuserAgain();
			ResponsePrint(Deleteresponse);
			verifystatuscode(Deleteresponse,400);
			validate_equal(Deleteresponse,"status","error");
			}
}
