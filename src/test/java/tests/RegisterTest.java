package tests;

import driver.WebDriverFactory;
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
    @Before
    public void SetUp() {
        driver = WebDriverFactory.setupDriver();
        registerPage = new RegisterPage(driver);
        driver.get(registerPage.getRegiterPageUrl());
    }

    @Description("Проверка регистрации при заполнении формы валидными данными")
    @Test
    public void registrationValid(){
        registerPage.fillRegistrationForm(faker.name().name(), faker.internet().emailAddress(), faker.internet().password());
        registerPage.clickRegistrationButton();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains(registerPage.getLoginLink()));
        registerPage.checkLink();
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
