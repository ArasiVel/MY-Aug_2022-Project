package com.test.models;

import java.util.ArrayList;

public class GetEmployeeRootPOJO {
	
		
	    public String status;
	    public ArrayList<GetEmployeePOJO> data;
	    public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public ArrayList<GetEmployeePOJO> getData() {
			return data;
		}
		public void setData(ArrayList<GetEmployeePOJO> data) {
			this.data = data;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String message;
	

}
