package tests;

import api.LoginData;
import api.UserApi;
import api.UserData;
import driver.WebDriverFactory;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import jdk.jfr.Description;
import net.datafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.RegisterPage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class RegisterTest {
    private WebDriver driver;
    RegisterPage registerPage;
    Faker faker = new Faker();
    LoginData loginData;
    UserApi userApi = new UserApi();
    String email;
    String password;
    String accessToken;

    @Before
    public void setUp() {
        driver = WebDriverFactory.setupDriver();
        registerPage = new RegisterPage(driver);
        driver.get(registerPage.REGISTER_PAGE_URL);
    }

    @Description("Проверка регистрации при заполнении формы валидными данными")
    @Test
    public void registrationValid(){
        email = faker.internet().emailAddress();
        password = faker.internet().password();
        registerPage.fillRegistrationForm(faker.name().name(), email, password);
        registerPage.clickRegistrationButton();
        registerPage.waitForNextPage();
        registerPage.checkLink();
        RestAssured.baseURI = UserApi.BASE_URL;
        loginData = new LoginData(email, password);
        accessToken = userApi.loginAndGetAccessToken(loginData);
        userApi.deleteUser(accessToken);
    }

    @Description("Проверка регистрации при заполнении формы коротким паролем")
    @Test
    public void registrationInvalidPassword(){
        registerPage.fillRegistrationForm(faker.name().name(), faker.internet().emailAddress(), faker.internet().password(2, 5));
        registerPage.clickRegistrationButton();
        assertTrue(registerPage.isInvalidPasswordDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
