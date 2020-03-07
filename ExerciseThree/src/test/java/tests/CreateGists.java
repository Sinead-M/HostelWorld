package tests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.apache.commons.io.IOUtils;

public class CreateGists {

  @Test
  public void createGist() throws IOException {

    RestAssured.baseURI = "https://api.github.com/gists";

    RequestSpecification httpRequest = RestAssured.given();

    httpRequest.header("Authorization", "token 23173fa641f733b1bb6d756d670307edc168429f");

    Map json = retrieveJsonReqest();

    httpRequest.body(json);

    Response response = httpRequest.request(Method.POST);

    String responseBody = response.getBody().asString();

    System.out.println("Response Body is -> " + responseBody);
  }

  private Map<String, Object> retrieveJsonReqest() throws IOException {
    Map<String, Object> jsonAsMap = new HashMap<>();
    jsonAsMap.put("description", "Hello World");
    jsonAsMap.put("public", "false");
    return jsonAsMap;
  }
}
