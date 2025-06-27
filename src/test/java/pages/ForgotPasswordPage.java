package pages;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class ForgotPasswordPage {
    private final WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By loginButton = By.xpath("//a[text()='Войти']");

    @Description("Стартовая ссылка страницы")
    public String getForgotPasswordUrl() {
        return "https://stellarburgers.nomoreparties.site/forgot-password";}

    @Description("Нажатие кнопки Войти")
    public void pressLoginButton(){
        driver.findElement(loginButton).click();
    }

    @Description("Проверка открываемой ссылки")
    public void checkLink(){
        String loginLink = "https://stellarburgers.nomoreparties.site/login";
        assertEquals(loginLink, driver.getCurrentUrl());
    }
}

