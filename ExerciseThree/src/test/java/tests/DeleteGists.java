package tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DeleteGists {

  @Test
  public void DeleteGist() {

    RestAssured.baseURI = "https://api.github.com/gists/" + System.getProperty("gistID");

    RequestSpecification httpRequest = RestAssured.given();

    httpRequest.header("Authorization", "token " + System.getProperty("accessToken"));

    Response response = httpRequest.request(Method.DELETE);

    String responseHeader = response.getStatusLine();

    assertThat(responseHeader.contains("204"), is(true));
  }

}
