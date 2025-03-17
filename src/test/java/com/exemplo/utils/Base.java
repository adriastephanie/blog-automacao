package com.exemplo.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class Base {

    protected WebDriver driver;

    // Constante para o tipo de navegador
    private static final String DEFAULT_BROWSER = "chrome";

    @BeforeEach
    public void setUp() {
        // Inicializa o driver antes de cada teste
        driver = Driver.getDriver(DEFAULT_BROWSER);
    }

    @AfterEach
    public void tearDown() {
        // Fecha o driver após cada teste
        Driver.quitDriver();
    }
}
