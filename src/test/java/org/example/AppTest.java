package org.example;


import com.google.common.base.Function;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.security.Key;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

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
    public void seleniumExampleSedndingMultipleKeysTest() throws InterruptedException {

        System.out.println("HA!");
        sleep(2000);
        driver.get("https://www.google.com/");
        sleep(1000);
        WebElement googleSearchBar = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
        // googleSearchBar.sendKeys("funny dog pics");
        googleSearchBar.sendKeys(Keys.chord("funny ", "dog ", "pics", Keys.ENTER));
        //googleSearchBar.submit();
        // googleSearchBar.sendKeys(Keys.ENTER);
        sleep(1000);
        WebElement linkToPictures = driver.findElement(By.partialLinkText("Images for funny dog"));
        linkToPictures.click();
        sleep(1000);
        WebElement imageLink = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/div[2]/c-wiz/div[1]/div/div[1]/div[1]/div/div/span"));
        assertTrue(imageLink.isDisplayed());
        //for
    }
    @Test
    public void implicitWaitExample(){
    //bad way of doing it
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("\"https://www.google.com/\"");
    WebElement searchBar = driver.findElement(By.name("q"));
    assertTrue(searchBar.isDisplayed());
    }
    @Test
    public void explicitWaitExample(){
    driver.get("\"https://www.google.com/\"");
            WebElement searchBar = (new WebDriverWait(driver, 18))
            .until(ExpectedConditions.presenceOfElementLocated(By.name("q")));

            assertTrue(searchBar.isDisplayed());
        List<WebElement> somthing= driver.findElements(By.id("dgsgs"));                 // when using to find a list of elements
    }
    @Test
            public void fluentWaitExample(){
    driver.get("https://www.google.com/");
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(30,TimeUnit.SECONDS)           // looks for 30 secs
            .pollingEvery(5, TimeUnit.SECONDS)          // the frequency of how they check to the success and failure of the check
            .ignoring(NoSuchElementException.class);
    WebElement searchBar = wait.until(new Function<WebDriver, WebElement>() {
        @Override
        public WebElement apply(WebDriver webDriver) {
            return driver.findElement(By.name("q"));
        }
    });
        assertTrue(searchBar.isDisplayed());


    }
    {

    }




@After
    public void teardown(){
    driver.close();
}

}

//                  List<Webelement> listofelements = driver.findElements(By.id("dgsgs");
//        Actions action = new Actions(driver);
//        action.moveByOffset(50,50).clickAndHold().moveByOffset(50,50).perform(); // This moves the mouse by co-oridinates, and drags and drops the element to another set of co-oridinates
//        action.moveToElement("imagelink") // moves it to the desired webelement
//        catch
//
//

//
//        imageLink.getLocation();                     //gets the location of the webelement
//        imageLink.getSize();                        // gets it by length and width
//        imageLink.getText();                        // gets the value associated with it
//        imageLink.isSelected();                     //checks on whether a radio and checkboxes have been selected


//    public boolean isElementPresent(By location) {
//        try {
//            driver.findElement(location);
//            return true;
//        }
//        catch (NoSuchElementException e){
//            return false;
//        }
//    }