package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WebDriverFactory {
    public static WebDriver setupDriver() {
        String browser = ConfigReader.getProperty("browser").toLowerCase();

        if (browser.equals(Constants.YANDEX)) {
            System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/WebDriver/yandexdriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:/Users/Tatyanochka/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
            return new ChromeDriver(options);
        } else {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }

    }
}
