package org.example;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;
import java.util.List;

import static java.lang.Thread.*;
import static org.junit.Assert.assertTrue;

public class AppTest {

    private WebDriver driver;

@Before
    public void setup(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
}

@Test
public void seleniumExampleTest() throws InterruptedException{

    System.out.println("HA!");
    sleep(2000);
    driver.get("https://www.google.com/");
    sleep(1000);
    WebElement googleSearchBar = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
    googleSearchBar.sendKeys("funny dog pics");
    googleSearchBar.submit();
    sleep(1000);
    WebElement linkToPictures = driver.findElement(By.partialLinkText("Images for funny dog"));
    linkToPictures.click();
    sleep(1000);
    WebElement imageLink = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/div[2]/c-wiz/div[1]/div/div[1]/div[1]/div/div/span"));
    assertTrue(imageLink.isDisplayed());

}

    @Test
    public void seleniumExampleSedndingMultipleKeysTest() throws InterruptedException{

        System.out.println("HA!");
        sleep(2000);
        driver.get("https://www.google.com/");
        sleep(1000);
        WebElement googleSearchBar = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
       // googleSearchBar.sendKeys("funny dog pics");
        googleSearchBar.sendKeys(Keys.chord("funny ","dog ", "pics", Keys.ENTER));
        //googleSearchBar.submit();
       // googleSearchBar.sendKeys(Keys.ENTER);
        sleep(1000);
        WebElement linkToPictures = driver.findElement(By.partialLinkText("Images for funny dog"));
        linkToPictures.click();
        sleep(1000);
        WebElement imageLink = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/div[2]/c-wiz/div[1]/div/div[1]/div[1]/div/div/span"));
        assertTrue(imageLink.isDisplayed());

//
//        Actions action = new Actions(driver);
//        action.moveByOffset(50,50).clickAndHold().moveByOffset(50,50).perform(); // This moves the mouse by co-oridinates, and drags and drops the element to another set of co-oridinates
//        action.moveToElement("imagelink") // moves it to the desired webelement
//        catch
//
//
//        List<Webelement> listofelements = driver.findElements(By.id("dgsgs"))
//
//        imageLink.getLocation();                     //gets the location of the webelement
//        imageLink.getSize();                        // gets it by length and width
//        imageLink.getText();                        // gets the value associated with it
//        imageLink.isSelected();                     //checks on whether a radio and checkboxes have been selected
    }

@After
    public void teardown(){
    driver.close();
}

}