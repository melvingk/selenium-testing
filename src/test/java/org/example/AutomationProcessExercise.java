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
    String email = "mee@me.com";
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
    sleep(3000);
    WebElement clickTheCross = driver.findElement(By.className("cross"));
    clickTheCross.click();
    WebElement openCart = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a"));
    openCart.click();
    sleep(3000);
    WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));
    proceedToCheckoutButton.click();

    WebElement emailAddressField = driver.findElement(By.id("email_create"));
    emailAddressField.sendKeys(email);
    sleep(3000);





//    WebElement proceedToCheckout = wait.until(new Function<WebDriver, WebElement>() {
//        @Override
//        public WebElement apply(WebDriver webDriver) {
//            return driver.findElement(By.className("icon-chevron-right right"));
//        }
//    });
//    sleep(1000);
//    proceedToCheckout.click();


//  WebElement proceedToCheckoutTwo = wait.until(new Function<WebDriver, WebElement>() {
//        @Override
//        public WebElement apply(WebDriver webDriver) {
//            return driver.findElement(By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span"));
//        }
//    });
////    WebElement proceedToCheckoutTwo = driver.findElement(By.className("button btn btn-default standard-checkout button-medium"));
//    proceedToCheckoutTwo.click();


}


    @After
    public void teardown(){
        driver.close();
    }


}
//  assertEquals("Printed Dress",confirmedAddedToCart.getText());
