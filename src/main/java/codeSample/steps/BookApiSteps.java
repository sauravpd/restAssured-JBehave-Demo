package codeSample.steps;

import static io.restassured.RestAssured.given;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class BookApiSteps extends Steps
{
	private String getBookByISBNNumberEndpoint = "https://www.googleapis.com/books/v1/volumes";
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	@Given("a book exists with an isbn of $isbnNumber")
	public void a_book_exists_with_an_isbn_of(String isbnNumber) throws Throwable 
	{
		request=given().queryParam("q",isbnNumber);
	}

	@When("a user retrieves the book by isbn number ")
	public void a_user_retrieves_the_book_by_isbn_number() throws Throwable 
	{
		response=request.when().get(getBookByISBNNumberEndpoint);
	}

	@Then("the status code is $statusCode")
	public void the_status_code_is(String statusCode) throws Throwable 
	{
		Assert.assertEquals(response.getStatusCode(),Integer.parseInt(statusCode));
	}
}
