package com.company;
import com.company.LoginTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTest {
    private static WebDriver driver;
    public static void main(String[] args) {
        new MainTest();
        LoginTest testLogIn = new LoginTest(driver);
        testLogIn.setup();
        try {
            testLogIn.testWrongLogin();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            testLogIn.testWrongPassword();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            testLogIn.testEntry();
        } catch (Exception e) {
            e.printStackTrace();
        }
        SearchTest searchTest = new SearchTest(driver);
        try {
            searchTest.TestSearch();
        } catch (Exception e) {
            e.printStackTrace();
        }
        TestTheme testTheme = new TestTheme(driver);
        try {
            testTheme.testTheme();
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    public MainTest() {
        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\tests\\chromedriver\\chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    public static void delay() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
