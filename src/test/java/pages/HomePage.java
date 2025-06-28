package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    private final By orderButton = By.xpath("//button[text()='Оформить заказ']");
    public final String HOMEPAGE_URL = "https://stellarburgers.nomoreparties.site";
    final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";


    @Step("Кнопка Личный Кабинет")
    public void pressPersonalAccountButton(){
        driver.findElement(personalAccountButton).click();
    }

    @Step("Кнопка Войти в аккаунт")
    public void pressEnterInAccountButton(){
        driver.findElement(enterInAccountButton).click();
    }

    @Step("Проверка ссылки")
    public void checkLink(){
        assertEquals(LOGIN_URL, driver.getCurrentUrl());
    }

    @Step("Нажатие переключателя Булки")
    public void pressBunButton(){
        driver.findElement(bunsButton).click();
    }

    @Step("Нажатие переключателя Соусы")
    public void pressSaucesButton(){
        driver.findElement(saucesButton).click();
    }

    @Step("Нажатие переключателя Начинки")
    public void pressFillingsButton(){
        driver.findElement(fillingsButton).click();
    }

    @Step("Получение локатора кнопки Соусы")
    public WebElement getSaucesButton(){
        return driver.findElement(saucesButton);
    }

    @Step("Получение локатора кнопки Булки")
    public WebElement getBunsButton(){
        return driver.findElement(bunsButton);
    }

    @Step("Получение локатора кнопки Начинки")
    public WebElement getFillingsButton(){
        return driver.findElement(fillingsButton);
    }

    public boolean isOrderButtonDisplayed(){
        return driver.findElement(orderButton).isDisplayed();
    }

    public void waitForSauces(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.attributeContains(getSaucesButton(), "class", "current"));
    }

    public void waitForBuns(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.attributeContains(getBunsButton(), "class", "current"));
    }
    public void waitForNextPage(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(orderButton));}


    }





