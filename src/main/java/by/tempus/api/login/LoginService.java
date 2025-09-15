package by.tempus.api.login;

import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class LoginService {

    private final String URL = "https://tempus.by/bitrix/services/main/ajax.php";
    private Response response;

    public void doRequest() {

        response = given()
                .formParams(getFormParams("mail1@mail.ru", "23456"))
                .queryParams(getQueryParams())
                .when()
                .post(URL);
    }

    public void doRequest(String email, String password) {
        response = given()
                .formParams(LoginService.getFormParams(email, password))
                .queryParams(getQueryParams())
                .when()
                .post(URL);
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getErrorMessage() {
        return response.path("errors[0].message");
    }

    public static Map<String, String> getFormParams() {
        Map<String, String> formParam = new HashMap<>();
        formParam.put("email", "mail1@mail.ru");
        formParam.put("password", "23456");
        return formParam;
    }

    public static Map<String, String> getFormParams(String email, String password) {
        Map<String, String> formParam = new HashMap<>();
        formParam.put("email", email);
        formParam.put("password", password);
        return formParam;
    }
    public static Map<String, String> getQueryParams() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("action", "imedia:main.api.Auth.loginByEmail");
        return queryParams;
    }
}
