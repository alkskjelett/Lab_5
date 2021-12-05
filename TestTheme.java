package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestTheme {
    private WebDriver driver;

    public void testTheme() throws Exception {
        WebElement themeBtn = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/span"));
        themeBtn.click();
        WebElement theme = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]"));
        if (!theme.getAttribute("title").equals("Светлое оформление")) throw new Exception("Смена темы на светлое не работает");
        themeBtn.click();
        if (!theme.getAttribute("title").equals("Темное оформление")) throw new Exception("Смена темы на тёмное не работает");
        else System.out.println("Тест на смену темы пройдет");
    }

    public TestTheme(WebDriver driver) {
        this.driver = driver;
    }
}
