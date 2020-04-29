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

public class AutomationProcessExercise {

    private WebDriver driver;

    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

@Test
public void SearchForAnItem(){

    driver.get("http://automationpractice.com/index.php");

    WebElement homeSearchBar = driver.findElement(By.id("search_query_top"));

    homeSearchBar.sendKeys("Evening dresses");
    homeSearchBar.submit();
    WebElement confirmedSearchText = driver.findElement(By.className("lighter"));
    assertTrue(confirmedSearchText.isDisplayed());


}
















    @After
    public void teardown(){
        driver.close();
    }


}
