package com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(xpath = "//*[@id=\"login_name\"]")
    //@FindBy(xpath = "//*contains[(@placeholder, 'Логин, эл. почта или номер телефона')]")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"login_password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "/html/body/div[2]/form/div/div[3]/button")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div[3]")
    private WebElement logIn;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickButton() {
        loginButton.click();
    }

    public void LogIn() {
        logIn.click();
    }

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
}
