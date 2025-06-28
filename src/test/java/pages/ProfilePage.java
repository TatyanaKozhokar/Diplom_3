package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class ProfilePage {
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    private final WebDriver driver;
    public final String PROFILE_PAGE_URL = "https://stellarburgers.nomoreparties.site/account";

    @Step("Проверка ссылки")
    public void checkLink(){
        assertEquals(PROFILE_PAGE_URL, driver.getCurrentUrl());
    }

}
