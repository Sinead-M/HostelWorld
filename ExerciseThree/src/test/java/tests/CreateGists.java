package tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import net.sf.json.JSONObject;

public class CreateGists {

  @Test
  public void createGist() {

    RestAssured.baseURI = "https://api.github.com/gists";

    RequestSpecification httpRequest = RestAssured.given();

    httpRequest.header("Authorization", "token " + System.getProperty("accessToken"));

    String json = createJson();

    httpRequest.body(json);

    Response response = httpRequest.request(Method.POST);

    String responseHeader = response.getStatusLine();

    assertThat(responseHeader.contains("201"), is(true));
  }

  private String createJson() {
    JSONObject fileContent = new JSONObject();
    JSONObject fileName = new JSONObject();
    JSONObject request = new JSONObject();

    fileContent.put("content", "class HelloWorld\\n   def initialize(name)\\n      @name = name.capitalize\\n   "
        + "end\\n   def sayHi\\n      puts \\\"Hello !\\\"\\n   end\\nend\\n\\nhello = HelloWorld.new(\\\"World\\\")\\nhello.sayHi");
    fileName.put("hello_world.rb", fileContent);
    request.put("description", "Sinead Test");
    request.put("public", false);
    request.put("files", fileName);
    return request.toString();
  }
}
