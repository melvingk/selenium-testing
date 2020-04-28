package org.example;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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


@After
    public void teardown(){
    driver.close();
}

}