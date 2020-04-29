package org.example;

import com.google.common.base.Function;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AutomationProcessExercise {

    private WebDriver driver;

    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

@Test
public void SearchForAnItem() throws InterruptedException {

    driver.get("http://automationpractice.com/index.php");
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(30, TimeUnit.SECONDS)           // looks for 30 secs
            .pollingEvery(5, TimeUnit.SECONDS)          // the frequency of how they check to the success and failure of the check
            .ignoring(NoSuchElementException.class);

    String item = "EVENING DRESSES";
    String email = "me@me.com";
    WebElement homeSearchBar = driver.findElement(By.id("search_query_top"));

    homeSearchBar.sendKeys(item);
    homeSearchBar.submit();
    sleep(2000);
    WebElement confirmedSearchText = driver.findElement(By.className("lighter"));
    assertTrue(confirmedSearchText.isDisplayed());
    sleep(2000);
    System.out.println(confirmedSearchText.getText());
  //  assertEquals(item,confirmedSearchText.getText());

  WebElement clickOnItem = driver.findElement(By.cssSelector("#center_column > ul > li > div > div.left-block > div > a.product_img_link > img"));
  clickOnItem.click();
  WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
  addToCart.click();

  WebElement confirmedAddedToCart = driver.findElement(By.className("product-name"));
  assertEquals("Printed Dress",confirmedAddedToCart.getText());
//    WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));
//    proceedToCheckoutButton.click();
//
//    WebElement emailAddressField = driver.findElement(By.id("email_create"));
//    emailAddressField.sendKeys(email);

}
















    @After
    public void teardown(){
        driver.close();
    }


}
