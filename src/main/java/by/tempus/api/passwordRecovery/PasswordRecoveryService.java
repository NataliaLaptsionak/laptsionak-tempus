package by.tempus.api.passwordRecovery;

import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PasswordRecoveryService {

    private final String URL = "https://tempus.by/bitrix/services/main/ajax.php";
    private Response response;

    public void doRequest(String email) {
        response = given()
                .formParams(getFormParams(email))
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

    private Map<String, String> getFormParams(String email) {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("email", email);
        formParams.put("action", "imedis.main.api.auth.restore");
        return formParams;
    }

    public static Map<String, String> getQueryParams() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("action", "imedia:main.api.Auth.restore");
        return queryParams;
    }
}
