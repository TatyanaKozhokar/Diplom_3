package pages;

import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class RegisterPage {
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    private final WebDriver driver;

    public final String LOGIN_LINK = "https://stellarburgers.nomoreparties.site/login";
    public final String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";

    private final By nameField = By.xpath("//input[@name='name']");
    private final By emailField = By.xpath("//label[text()='Email']/following-sibling::input");
    private final By passwordField = By.xpath("//input[@name='Пароль']");
    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By invalidPassword = By.xpath("//p[text()='Некорректный пароль']");
    private final By logInButton = By.xpath("//a[text()='Войти']");


    @Step("Заполнение поля Имя")
    public void setName(String data){
            driver.findElement(nameField).click();
            driver.findElement(nameField).sendKeys(data);
    }

    @Step("Заполнение поля Email")
    public void setEmail(String data){
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(data);
    }

    @Step("Заполнение формы Пароль")
    public void setPassword(String data){
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(data);
    }

    @Step("Заполнение всей формы")
    public void fillRegistrationForm(String name, String email, String password){
        setName(name);
        setEmail(email);
        setPassword(password);
    }

    @Step("Нажатие кнопки Зарегистрироваться")
    public void clickRegistrationButton(){
        driver.findElement(registerButton).click();
    }

    @Step("Поле Некорректный пароль")
    public boolean isInvalidPasswordDisplayed(){
        return driver.findElement(invalidPassword).isDisplayed();
    }

    @Step("Нажатие кнопки Войти")
    public void pressLoginButton(){
        driver.findElement(logInButton).click();
    }


    @Step("Проверка ссылки")
    public void checkLink(){
        assertEquals(LOGIN_LINK, driver.getCurrentUrl());
    }

    public void waitForNextPage(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.urlContains(LOGIN_LINK));}

}
