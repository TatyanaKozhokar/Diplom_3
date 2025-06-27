package tests;

import driver.WebDriverFactory;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ForgotPasswordPage;
import pages.HomePage;
import pages.RegisterPage;


public class LoginButtonTest {
    private WebDriver driver;

    @Before
    public void SetUp() {
        driver = WebDriverFactory.setupDriver();
    }

    @Description("Тест кнопки Войти на странице Регистрации")
    @Test
    public void registrationPageLoginButtonTest(){
        RegisterPage registerPage = new RegisterPage(driver);
        driver.get(registerPage.getRegiterPageUrl());
        registerPage.pressLoginButton();
        registerPage.checkLink();
    }

    @Description("Тест кнопки Войти на странице Восстановления пароля")
    @Test
    public void forgotPasswordPageLoginButtonTest(){
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        driver.get(forgotPasswordPage.getForgotPasswordUrl());
        forgotPasswordPage.pressLoginButton();
        forgotPasswordPage.checkLink();
    }

    @Description("Тест кнопки Личный кабинет")
    @Test
    public void homePagePersonalAccountButtonTest(){
        HomePage homePage = new HomePage(driver);
        driver.get(homePage.getHomepageUrl());
        homePage.pressPersonalAccountButton();
        homePage.checkLink();
    }

    @Description("Тест кнопки Войти в аккаунт на главной странице")
    @Test
    public void enterInAccountAccountButtonTest(){
        HomePage homePage = new HomePage(driver);
        driver.get(homePage.getHomepageUrl());
        homePage.pressEnterInAccountButton();
        homePage.checkLink();
    }



    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
