package api;


import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApi {
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    static final String REGISTER = "/api/auth/register";
    static final String USER = "/api/auth/user";
    static final String LOGIN = "/api/auth/login";


    @Step("Создание пользователя через api")
    public String createUserAndGetAccessToken(api.UserData userData) {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(userData)
                .when()
                .post(REGISTER);
        JsonPath jsonPath = response.jsonPath();
        return jsonPath.getString("accessToken");
    }

    @Step("Авторизация и получение токена")
    public String loginAndGetAccessToken(api.LoginData loginData) {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(loginData)
                .when()
                .post(LOGIN);
        JsonPath jsonPath = response.jsonPath();
        return jsonPath.getString("accessToken");
    }

    @Step("Удаление пользователя")
    public void deleteUser(String accessToken){
        given()
                .header("Authorization", accessToken)
                .when()
                .delete(USER);
    }

}
