package org.example;

import com.google.common.base.Function;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Random;
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
    String getAlphabeticString(int n)
    {
        // chose a Character random from this String
        String AlphabeticString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index
                    = (int) (AlphabeticString .length()
                    * Math.random());// add Character one by one in end of sb
            sb.append(AlphabeticString
                    .charAt(index));
        }
        return sb.toString();
    }
@Test

public void addItemToCart() throws InterruptedException {

    driver.get("http://automationpractice.com/index.php");
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(30, TimeUnit.SECONDS)           // looks for 30 secs
            .pollingEvery(5, TimeUnit.SECONDS)          // the frequency of how they check to the success and failure of the check
            .ignoring(NoSuchElementException.class);



    String item = "EVENING DRESSES";
    String email = "migplppei@mweotpet.com";
    String firstName = "Tanjiro";
    String lastName = "Kamado";
    String password = "mannna";
    String address = "Tikiki Street";
    String city = "London";
    String postal = "12332";
    String number = "1254683256";
    WebElement homeSearchBar = driver.findElement(By.id("search_query_top"));

    homeSearchBar.sendKeys(item);
    homeSearchBar.submit();
    WebElement confirmedSearchText = driver.findElement(By.className("lighter"));
    assertTrue(confirmedSearchText.isDisplayed());
    System.out.println(confirmedSearchText.getText());
    //  assertEquals(item,confirmedSearchText.getText());

    WebElement clickOnItem = driver.findElement(By.cssSelector("#center_column > ul > li > div > div.left-block > div > a.product_img_link > img"));
    clickOnItem.click();
    WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
    addToCart.click();
    WebElement clickTheCross = driver.findElement(By.className("cross"));
    sleep(3000);  //needs a fluent wait here
    clickTheCross.click();
    WebElement openCart = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a"));
    openCart.click();
    WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));
    proceedToCheckoutButton.click();

    WebElement emailAddressField = driver.findElement(By.id("email_create"));
    emailAddressField.sendKeys(email);
    emailAddressField.submit();
    WebElement issue = driver.findElement(By.className("page-heading"));
    assertTrue(issue.isDisplayed());
    System.out.println(issue.getText());
sleep(3000);

    WebElement maleRadioButton = driver.findElement(By.id("id_gender1"));
    WebElement customer_firstname = driver.findElement(By.id("customer_firstname"));
    WebElement customer_lastname = driver.findElement(By.id("customer_lastname"));
    WebElement passwordField = driver.findElement(By.id("passwd"));
    WebElement address_Field = driver.findElement(By.id("address1"));
    WebElement city_Field = driver.findElement(By.id("city"));
    Select state_Field = new Select(driver.findElement(By.id("id_state")));
    WebElement postcode_Field = driver.findElement(By.id("postcode"));
    WebElement phone_mobile_Field = driver.findElement(By.id("phone_mobile"));
    WebElement register = driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span"));

    sleep(3000);
    int a = (int) (Math.random()+ 10);
    maleRadioButton.click();
    customer_firstname.sendKeys(getAlphabeticString(a));
    customer_lastname.sendKeys(getAlphabeticString(a));
    passwordField.sendKeys(getAlphabeticString(a));
    address_Field.sendKeys(address);
    city_Field.sendKeys(city);
    state_Field.selectByIndex(4);
    postcode_Field.sendKeys(postal);
    phone_mobile_Field.sendKeys(number);
    register.click();

    WebElement addressConfirmation = driver.findElement(By.className("page-subheading"));
    sleep(3000);
    assertEquals("your delivery address", addressConfirmation.getText().toLowerCase());


    WebElement proceedToCheckoutTwo = driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span"));
    proceedToCheckoutTwo.click();
    WebElement checkbox = driver.findElement(By.id("cgv"));
    checkbox.click();
    assertTrue(checkbox.isSelected());
    WebElement proceedToCheckoutThree = driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span"));
    proceedToCheckoutThree.click();
    WebElement payByBank = driver.findElement(By.className("bankwire"));
    payByBank.click();
    WebElement confirmOrder = driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span"));
    confirmOrder.click();
    WebElement orderCompleteConfirm = driver.findElement(By.className("cheque-indent"));
    assertTrue(orderCompleteConfirm.isDisplayed());


}


    @After
    public void teardown() throws IOException {
        driver.close();
        Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
    }


}
//  assertEquals("Printed Dress",confirmedAddedToCart.getText());
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