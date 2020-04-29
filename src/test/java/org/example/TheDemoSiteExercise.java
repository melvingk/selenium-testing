package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TheDemoSiteExercise {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void registerUser() throws InterruptedException {

        driver.get("http://thedemosite.co.uk/addauser.php");
        sleep(1000);
        WebElement usernameRegister = driver.findElement(By.name("username"));
        WebElement passwordRegister = driver.findElement(By.name("password"));
        WebElement submitButtonRegister = driver.findElement(By.name("FormsButton2"));


        usernameRegister.sendKeys("Tanjiro");
        passwordRegister.sendKeys("Nezuko");
        submitButtonRegister.click();
        sleep(1000);

        driver.get("http://thedemosite.co.uk/login.php");
        sleep(1000);
        WebElement usernameLogin = driver.findElement(By.name("username"));
        WebElement passwordLogin = driver.findElement(By.name("password"));
        WebElement submitButtonLogin = driver.findElement(By.name("FormsButton2"));
        usernameLogin.sendKeys("Tanjiro");
        passwordLogin.sendKeys("Nezuko");
        sleep(1000);
        submitButtonLogin.click();
        assertTrue("**Successful Login**", true);
        sleep(1000);
//        if (confirmRegister.getText().equals(name)){
//            System.out.println("They match");
//            assertTrue(true);
//        }
//        else
//            {
//            System.out.println("It failed");
//            assertFalse(false);
//        }


    }

    @After
    public void teardown() {

        driver.close();
    }

}
