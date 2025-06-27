package pages;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By enterInAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By bunsButton = By.xpath("//div[contains(@class, 'tab_tab__')]//span[text()='Булки']/..");
    private final By saucesButton = By.xpath("//div[contains(@class, 'tab_tab__')]//span[text()='Соусы']/..");
    private final By fillingsButton = By.xpath("//div[contains(@class, 'tab_tab__')]//span[text()='Начинки']/..");

    @Description("Стартовая ссылка страницы")
    public String getHomepageUrl() {
        return "https://stellarburgers.nomoreparties.site";}

    @Description("Кнопка Личный Кабинет")
    public void pressPersonalAccountButton(){
        driver.findElement(personalAccountButton).click();
    }

    @Description("Кнопка Войти в аккаунт")
    public void pressEnterInAccountButton(){
        driver.findElement(enterInAccountButton).click();
    }

    @Description("Проверка ссылки")
    public void checkLink(){
        String loginLink = "https://stellarburgers.nomoreparties.site/login";
        assertEquals(loginLink, driver.getCurrentUrl());
    }

    @Description("Нажатие переключателя Булки")
    public void pressBunButton(){
        driver.findElement(bunsButton).click();
    }

    @Description("Нажатие переключателя Соусы")
    public void pressSaucesButton(){
        driver.findElement(saucesButton).click();
    }

    @Description("Нажатие переключателя Начинки")
    public void pressFillingsButton(){
        driver.findElement(fillingsButton).click();
    }

    @Description("Получение локатора кнопки Соусы")
    public WebElement getSaucesButton(){
        return driver.findElement(saucesButton);
    }

    @Description("Получение локатора кнопки Булки")
    public WebElement getBunsButton(){
        return driver.findElement(bunsButton);
    }

    @Description("Получение локатора кнопки Начинки")
    public WebElement getFillingsButton(){
        return driver.findElement(fillingsButton);
    }



    }





