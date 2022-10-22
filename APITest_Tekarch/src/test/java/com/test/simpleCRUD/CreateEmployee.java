package com.test.simpleCRUD;

import java.io.IOException;

import com.test.helpers.UserServiceHelper;
import com.test.models.CreatedUserPOJORootResponse;

import io.restassured.response.Response;

public class CreateEmployee extends UserServiceHelper {
public static void AddEmployee() {
System.out.println("add employee");
Response res = createuser();;
CreatedUserPOJORootResponse EmployeeList = res.as(CreatedUserPOJORootResponse.class);
System.out.println(EmployeeList);
ResponsePrint(res);
getStatusCode(res);
verifystatuscode(res,200);
validate_equal(res,"status","success");
String name = GetDataFromResponse(res,"data.employeeName");
String age = GetDataFromResponse(res,"data.employeeAge");
String salary = GetDataFromResponse(res,"data.employeeSalary");
String id = GetDataFromResponse(res,"data.id");
System.out.println("name is :"+name);
System.out.println("age is :"+age);
System.out.println("salary is :"+salary);
System.out.println("id is :"+id);

validate_equal(res,"data.employeeName","test");
validate_equal(res,"data.employeeSalary","123");
validate_equal(res,"data.employeeAge","23");
try {
writeProperty(id);
} catch (IOException e) {
e.printStackTrace();
}
}

}

	
	

