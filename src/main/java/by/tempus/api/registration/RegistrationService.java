package by.tempus.api.registration;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RegistrationService {
    private Response response;

    public void doRegistrationRequest(String fullName, String email, String phone, String password, String passwordRepeat) {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";
        response = given()
                .queryParams(getQueryParams())
                .formParams(getFormParams(fullName, email, phone, password, passwordRepeat))
                .when()
                .post(URL);
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getErrorMessage() {
        return response.path("errors[0].message");
    }

    private Map<String, String> getFormParams(String fullName, String email, String phone, String password, String passwordRepeat) {
        Map<String, String> formParam = new HashMap<>();
        formParam.put("fullName", fullName);
        formParam.put("email", email);
        formParam.put("phone", phone);
        formParam.put("password", password);
        formParam.put("passwordRepeat", passwordRepeat);
        return formParam;
    }

    private Map<String, String> getQueryParams() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("action", "imedia:main.api.Auth.registration");
        return queryParams;
    }
}
