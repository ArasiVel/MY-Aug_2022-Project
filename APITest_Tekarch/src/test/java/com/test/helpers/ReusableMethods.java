package com.test.helpers;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.Properties;

	import org.hamcrest.Matchers;
	import com.test.constants.SourcePath;
	import io.restassured.response.Response;

	public class ReusableMethods {


public FileInputStream stream=null;
public static void writeProperty(String id) throws IOException {
File file = new File(SourcePath.CONFIG_PROPERTIES_PATH);
FileOutputStream os = new FileOutputStream(file);
Properties propertyFile = new Properties();
propertyFile.put("id1", id);
propertyFile.store(os, "id");
}

public static int getStatusCode(Response res) {
return res.getStatusCode();

}
public static void verifystatuscode(Response res, int code) {
res.then().statusCode(code);

}
public static String getContentType(Response res) {
return res.getContentType();
}
public static void validatecontentType(Response res,String contenttype) {
res.then().contentType(contenttype);
}

public static String GetDataFromResponse(Response res, String path) {
String result=res.jsonPath().getString(path);
return result;
}
public static void validate_equal(Response res,String path,String match) {
res.then().body(path,Matchers.equalTo(match));

}
public static void ResponsePrint(Response res) {
res.prettyPrint();
	}

	}


