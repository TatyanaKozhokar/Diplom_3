package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class ForgotPasswordPage {
    private final WebDriver driver;
    private final String LOGIN_LINK = "https://stellarburgers.nomoreparties.site/login";
    public final String FG_PASSWORD_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By loginButton = By.xpath("//a[text()='Войти']");

    @Step("Нажатие кнопки Войти")
    public void pressLoginButton(){
        driver.findElement(loginButton).click();
    }

    @Step("Проверка открываемой ссылки")
    public void checkLink(){
        assertEquals(LOGIN_LINK, driver.getCurrentUrl());
    }
}

