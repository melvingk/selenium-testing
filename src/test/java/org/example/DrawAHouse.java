package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Thread.sleep;

public class DrawAHouse {

    private WebDriver driver;

    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void drawingAHouse() throws InterruptedException {

        driver.get("https://www.youidraw.com/apps/painter/");
        sleep(1000);
        WebElement drawingArea = driver.findElement(By.id("catch"));
        System.out.println("Its there at " + drawingArea.getLocation());

        Actions action = new Actions(driver);
        action.moveToElement(drawingArea).clickAndHold()
                .moveByOffset(0,100)

                .perform();
        sleep(3000);
    }



    @After
    public void teardown(){
        driver.close();
    }

}
