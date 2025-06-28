package tests;

import api.UserApi;
import driver.WebDriverFactory;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import jdk.jfr.Description;
import net.datafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.*;
import api.UserData;

import static org.junit.Assert.assertTrue;


public class LoginButtonTest {
    private WebDriver driver;
    Faker faker = new Faker();
    String email;
    String password;
    UserData userData;
    UserApi userApi = new UserApi();
    String accessToken;
    ProfilePage profilePage;
    HomePage homePage;
    RegisterPage registerPage;
    LoginPage loginPage;


    @Before
    public void setUp() {
        RestAssured.baseURI = UserApi.BASE_URL;
        email = faker.internet().emailAddress();
        password = faker.internet().password();
        userData = new UserData(email, password, faker.name().name());
        accessToken = userApi.createUserAndGetAccessToken(userData);
        driver = WebDriverFactory.setupDriver();
        registerPage = new RegisterPage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Description("Тест кнопки Войти на странице Регистрации")
    @Test
    public void registrationPageLoginButtonTest(){
        driver.get(registerPage.REGISTER_PAGE_URL);
        registerPage.pressLoginButton();
        loginPage.fillEnterForm(email, password);
        loginPage.pressLoginButton();
        loginPage.waitForNextPage();
        homePage.waitForNextPage();
        assertTrue(homePage.isOrderButtonDisplayed());


    }

    @Description("Тест кнопки Войти на странице Восстановления пароля")
    @Test
    public void forgotPasswordPageLoginButtonTest(){
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        driver.get(forgotPasswordPage.FG_PASSWORD_URL);
        forgotPasswordPage.pressLoginButton();
        forgotPasswordPage.checkLink();
        loginPage.fillEnterForm(email, password);
        loginPage.pressLoginButton();
        homePage.waitForNextPage();
        assertTrue(homePage.isOrderButtonDisplayed());
    }

    @Description("Тест кнопки Личный кабинет")
    @Test
    public void homePagePersonalAccountButtonTest(){
        homePage = new HomePage(driver);
        driver.get(homePage.HOMEPAGE_URL);
        homePage.pressPersonalAccountButton();
        homePage.checkLink();
        loginPage.fillEnterForm(email, password);
        loginPage.pressLoginButton();
        homePage.waitForNextPage();
        assertTrue(homePage.isOrderButtonDisplayed());
    }

    @Description("Тест кнопки Войти в аккаунт на главной странице")
    @Test
    public void enterInAccountAccountButtonTest(){
        driver.get(homePage.HOMEPAGE_URL);
        homePage.pressEnterInAccountButton();
        homePage.checkLink();
        loginPage.fillEnterForm(email, password);
        loginPage.pressLoginButton();
        homePage.waitForNextPage();
        assertTrue(homePage.isOrderButtonDisplayed());
    }


    @DisplayName("Вход в аккаунт, удаление пользователя и закрытие браузера")
    @After
    public void loginAndTearDown() {
        userApi.deleteUser(accessToken);
        if (driver != null) {
            driver.quit();
        }
    }


}
