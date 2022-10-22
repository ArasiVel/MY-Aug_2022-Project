package com.test.models;


	public class CreatedUserPOJORootResponse {
		public String status;
	    public CreatedUserPOJOResponse data;
	    public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public CreatedUserPOJOResponse getData() {
			return data;
		}
		public void setData(CreatedUserPOJOResponse data) {
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

