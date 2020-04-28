package org.example;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {

    private WebDriver driver;

@Before
    public void setup(){
    driver = new ChromeDriver();
}



@After
    public void teardown(){
    driver.close();
}

}