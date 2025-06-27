package pages;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import static org.junit.Assert.assertEquals;

public class RegisterPage {
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    private final WebDriver driver;

    public String getLoginLink() {
        return loginLink;
    }

    String loginLink = "https://stellarburgers.nomoreparties.site/login";

    public String getRegiterPageUrl() {
        return registerPageUrl;
    }

    String registerPageUrl=  "https://stellarburgers.nomoreparties.site/register";

    private final By nameField = By.xpath("//input[@name='name']");
    private final By emailField = By.xpath("//label[text()='Email']/following-sibling::input");
    private final By passwordField = By.xpath("//input[@name='Пароль']");
    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By invalidPassword = By.xpath("//p[text()='Некорректный пароль']");
    private final By logInButton = By.xpath("//a[text()='Войти']");


    @Description("Заполнение поля Имя")
    public void setName(String data){
            driver.findElement(nameField).click();
            driver.findElement(nameField).sendKeys(data);
    }

    @Description("Заполнение поля Email")
    public void setEmail(String data){
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(data);
    }

    @Description("Заполнение формы Пароль")
    public void setPassword(String data){
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(data);
    }

    @Description("Заполнение всей формы")
    public void fillRegistrationForm(String name, String email, String password){
        setName(name);
        setEmail(email);
        setPassword(password);
    }

    @Description("Нажатие кнопки Зарегистрироваться")
    public void clickRegistrationButton(){
        driver.findElement(registerButton).click();
    }

    @Description("Поле Некорректный пароль")
    public boolean isInvalidPasswordDisplayed(){
        return driver.findElement(invalidPassword).isDisplayed();
    }

    @Description("Нажатие кнопки Войти")
    public void pressLoginButton(){
        driver.findElement(logInButton).click();
    }


    @Description("Проверка ссылки")
    public void checkLink(){
        assertEquals(loginLink, driver.getCurrentUrl());
    }

}
