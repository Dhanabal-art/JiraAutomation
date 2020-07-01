package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utility {
	static RequestSpecification request;
	static ResponseSpecification response;
	public RequestSpecification addRequestSpecification() throws IOException
	{
		if(request==null)
		{
			PrintStream st=new PrintStream(new FileOutputStream("logs.txt"));
			request=new RequestSpecBuilder().setBaseUri(getTestData("baseURI"))
					.addFilter(RequestLoggingFilter.logRequestTo(st))
					.addFilter(ResponseLoggingFilter.logResponseTo(st))
					.setContentType(ContentType.JSON).build();
			return request;
		}
		return request;
	}
	
	public String getTestData(String key) throws IOException
	{
		String value;
		Properties prob=new Properties();
		FileInputStream input=new FileInputStream(System.getProperty("user.dir")+"\\common.properties");
		prob.load(input);
		return value=prob.getProperty(key);
	}
	public ResponseSpecification addResponseSpecBuilder()
	{
		return response=new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
	}

}
