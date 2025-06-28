package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public final String LOGIN_PAGE = "https://stellarburgers.nomoreparties.site/login";
    public final String HOME_PAGE = "https://stellarburgers.nomoreparties.site";

    private final WebDriver driver;
    private final By emailField = By.xpath("//input[@name='name']");
    private final By passwordField = By.xpath("//input[@name='Пароль']");
    private final By enterButton = By.xpath("//button[text()='Войти']");

    @Step("Заполнение поля Email")
    public void setEmailField(String data){
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(data);
    }

    @Step("Заполнение формы Пароль")
    public void setPassword(String data){
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(data);
    }

    @Step("Заполнение всей формы")
    public void fillEnterForm(String email, String password){
        setEmailField(email);
        setPassword(password);
    }

    @Step("Нажатие кнопки Войти")
    public void pressLoginButton(){
        driver.findElement(enterButton).click();
    }

    @Step("Проверка ссылки")
    public void checkLink(){
        assertEquals(HOME_PAGE, driver.getCurrentUrl());
    }

    public void waitForNextPage(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains(HOME_PAGE));}


}
