package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import ResponseAddIssue.AddResponseExtract;
import Utils.AddIssuePayload;
import Utils.JsonParse;
import Utils.Payload;
import Utils.Utility;

public class JiraDefinition extends Utility{
	static String sessionID;
	static String sessionValue;
	static String BudID;
	Response response;
	RequestSpecification req;
	AddResponseExtract resp;
	//RequestSpecification req1;
	ResponseSpecification res;
	@Given("Session created with {string} and {string}")
	public void session_created_with_and(String username, String password) throws IOException {
		APIResources resorces=APIResources.valueOf("SessionCreation");
	req=given().spec(addRequestSpecification()).body(Payload.getSessionPayLoad());
	response=req.when().post(resorces.getResources()).then().spec(addResponseSpecBuilder()).extract().response();
	sessionID=JsonParse.getvalues(response, "session.name");
	sessionValue=JsonParse.getvalues(response, "session.value");
	System.out.println(sessionID+sessionValue);
	 System.out.println(sessionID+"="+sessionValue);
	}

	@Given("{string} payload is transferred")
	public void payload_is_transferred(String payload) throws IOException {
	    //System.out.println(sessionID+"="+sessionValue);
		req=given().log().all().headers("Cookie", sessionID+"="+sessionValue).log().all().spec(addRequestSpecification()).body(AddIssuePayload.getValues());
	}

	@When("{string} is called")
	public void is_called(String httpMethos) {
		APIResources resorces=APIResources.valueOf(httpMethos);
		resp=req.when().post(resorces.getResources()).as(AddResponseExtract.class);
	    
	}

	@Then("Issue is successfully created.")
	public void issue_is_successfully_created() {
		BudID=resp.getId();
		System.out.println(BudID);
	    
	}
	
	/*@Then("the issue is retrived successfully.")
	public void the_issue_is_retrived_successfully() {
	req=given().
	}*/

}
