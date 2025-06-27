package tests;

import driver.WebDriverFactory;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest {
    private WebDriver driver;
    HomePage homePage;

    @Before
    public void SetUp() {
        driver = WebDriverFactory.setupDriver();
        homePage = new HomePage(driver);
        driver.get(homePage.getHomepageUrl());
    }

    @Description("Тест переключателя Булки")
    @Test
    public void testBunsButton() {
        homePage.pressSaucesButton();
        homePage.pressBunButton();
        assertTrue(homePage.getBunsButton().getAttribute("class").contains("current"));
    }

    @Description("Тест переключателя Соусы")
    @Test
    public void testSaucesButton() {
        homePage.pressSaucesButton();
        assertTrue(homePage.getSaucesButton().getAttribute("class").contains("current"));
    }

    @Description("Тест переключателя Начинкиgit remote add origin https://github.com/TatyanaKozhokar/Diplom_3.git")
    @Test
    public void testFillingsButton() {
        homePage.pressFillingsButton();
        assertTrue(homePage.getFillingsButton().getAttribute("class").contains("current"));
    }



    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
