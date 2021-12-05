package com.company;

import org.junit.BeforeClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import com.company.LoginPage;

public class LoginTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://animego.online/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LoginTest(WebDriver driver) {
        this.driver = driver;
    }

    public void testWrongLogin() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.LogIn();
        loginPage.inputLogin("wrongLogin");
        loginPage.inputPassword("B000Baaaa!");
        loginPage.clickButton();
        MainTest.delay();
        WebElement message = driver.findElement(By.xpath("/html/body/div[1]/div/main/div[1]/div/div[2]"));
        if(!message.isDisplayed()) throw new Exception("Не отображается ошибка о неправильном вводе логина");
        else System.out.println("Тест с неправильным логином пройден");
    }

    public void testWrongPassword() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.LogIn();
        loginPage.inputLogin("chelovekskelet");
        loginPage.inputPassword("wrongPassword");
        loginPage.clickButton();
        MainTest.delay();
        WebElement message = driver.findElement(By.xpath("/html/body/div[1]/div/main/div[1]/div/div[2]"));
        if(!message.isDisplayed()) throw new Exception("Не отображается ошибка о неправильном вводе Пароля");
        else System.out.println("Тест с неправильным паролем пройден");
    }

    public void testEntry() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.LogIn();
        loginPage.inputLogin("chelovekskelet");
        loginPage.inputPassword("B000Baaaa!");
        loginPage.clickButton();
        MainTest.delay();
        WebElement message = driver.findElement(By.xpath("/html/body/div[1]/div/main/div[1]/div/div[2]"));
        if(message.getText() == "Внимание! Вход на сайт не был произведён. Возможно, Вы ввели неверное имя пользователя или пароль.")
            throw new Exception("Отображается ошибка о некорректных данных при вводе корректных данных");
        else System.out.println("Тест с корректными данными пройден");
    }
}
