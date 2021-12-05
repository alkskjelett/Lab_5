package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class SearchTest {
    private WebDriver driver;

    public void TestSearch() throws Exception {
        MainTest.delay();
        WebElement searchField = driver.findElement(By.xpath("/html/body/div[1]/div/header/div/div[1]/form/div/input"));
        searchField.click();
        MainTest.delay();
        searchField.sendKeys("Токийский гуль");
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"quicksearch\"]/div/button"));
        searchButton.click();
        MainTest.delay();
        WebElement message = driver.findElement(By.xpath("//*[@id=\"fullsearch\"]/div/div[2]"));
        if (message == null) throw new Exception("Аниме \"Токийский гуль\" отсутствует, это недопустимо, значит это баг");
        else System.out.println("Тест на наличие аниме \"Токийский гуль\" пройден");
    }

    public SearchTest(WebDriver driver) {
        this.driver = driver;
    }
}
