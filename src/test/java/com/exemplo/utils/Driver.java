package com.exemplo.utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


public class Driver {

    private static WebDriver driver;

    // Constantes para navegadores
    private static final String FIREFOX = "firefox";
    private static final String EDGE = "edge";
    private static final String CHROME = "chrome";

    // Constantes para argumentos de navegadores
    private static final String FIREFOX_PRIVATE_MODE = "-private";
    private static final String EDGE_PRIVATE_MODE = "-inprivate";
    private static final String CHROME_INCOGNITO = "--incognito";

    private Driver() {
        // Construtor privado para evitar instanciação direta
    }


    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            driver = createDriver(browser);
        }
        return driver;
    }

    private static WebDriver createDriver(String browser) {
        WebDriver driver = null;

        switch (browser.toLowerCase()) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments(FIREFOX_PRIVATE_MODE);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments(EDGE_PRIVATE_MODE);
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(CHROME_INCOGNITO);
                driver = new ChromeDriver(chromeOptions);
                break;
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }


    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}