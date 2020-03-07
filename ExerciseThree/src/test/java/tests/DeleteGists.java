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

    RestAssured.baseURI = "https://api.github.com/gists/f797bbb0930cc542b7ce524503aea903";

    RequestSpecification httpRequest = RestAssured.given();

    httpRequest.header("Authorization", "token 23173fa641f733b1bb6d756d670307edc168429f");

    Response response = httpRequest.request(Method.DELETE);

    String responseHeader = response.getStatusLine();

    assertThat(responseHeader.contains("204"), is(true));
  }

}
