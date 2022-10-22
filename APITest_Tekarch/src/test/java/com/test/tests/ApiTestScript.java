package com.test.tests;

import org.testng.annotations.Test;

import com.test.helpers.UserServiceHelper;
import com.test.simpleCRUD.CreateEmployee;
import com.test.simpleCRUD.DeleteEmployee;
import com.test.simpleCRUD.GetAllEmployee;
import com.test.simpleCRUD.GetEmployee;

import io.restassured.response.Response;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



public class ApiTestScript extends UserServiceHelper {


@Test(priority = 1)

public static void TC01AllEmployeedata() {
GetAllEmployee.getEmployees();
}

@Test(priority = 2)

public static void TC02CreateEmployeedata() {
System.out.println("Adding employee:");
CreateEmployee.AddEmployee();
}
@Test(priority = 3)
public static void TC03DeleteEmployee() {
DeleteEmployee.delete_emp();
}
@Test(priority = 4)
public static void TC04DeleteAlreadydeletedEmployee() {
DeleteEmployee.deleteuserAgain();

}
@Test(priority = 5)
public static void TC05GetEmpWithId() {
GetEmployee.getempwithid();
}

}
