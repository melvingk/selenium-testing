package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class TheDemoSiteExercise {

    private WebDriver driver;

    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void registerUser() throws InterruptedException{

        driver.get("http://thedemosite.co.uk/addauser.php");



    }

    @After
    public void teardown(){
        driver.close();
    }

}
