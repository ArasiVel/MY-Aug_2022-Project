package com.test.simpleCRUD;

import com.test.helpers.UserServiceHelper;

import io.restassured.response.Response;

public class GetEmployee extends UserServiceHelper{
		public static void getempwithid() {
		Response response = getEmployeewithid();
		ResponsePrint(response);
		verifystatuscode(response,200);
		validate_equal(response,"status","success");
		validatecontentType(response,"application/json");
		validate_equal(response,"data.employeeName","Garrett Winters");
		validate_equal(response,"data.employeeSalary","170750");
		validate_equal(response,"data.employeeAge","63");
		}

		}

