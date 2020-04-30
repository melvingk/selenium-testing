package org.example;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertEquals;

public class StockFinder {
    WebDriver driver;
    ExtentReports report;
    ExtentTest test;

    @BeforeTest
    public void startReport(){
        report = new ExtentReports(
                System.getProperty("user.dir") + "/test-output/Stock_Report.html",
                true


        );
        report
                .addSystemInfo("Host Name", "QA")
                .addSystemInfo("Tester", "Melvin")
                .addSystemInfo("Browser","Chrome");
        report.loadConfig(new File(System.getProperty("user.dir") + "\\extent-report-stocks.xml"));
    }

    @BeforeMethod

    public void setUp(){
        driver = new ChromeDriver();
    }
    @Test
    public void stockMarketHighestRiser() throws InterruptedException {
        test = report.startTest("Identifying the highest riser");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Started chrome browser and made it fullscreen");
        driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100");
        test.log(LogStatus.INFO, "Navigating to Hargreaves Lansdown, FTSE 100 webpage");
        assertEquals(driver.getTitle(), "FTSE 100 Market overview | Hargreaves Lansdown");
        test.log(LogStatus.PASS, "The titles match");
        sleep(2000);
        if(driver instanceof JavascriptExecutor)
        {
            ((JavascriptExecutor) driver).executeScript( "window.scrollBy(0,1000)");
            sleep(1000);
        }
        else{
            System.out.println("Can't execute JS");
        }
        WebElement riserTab = driver.findElement(By.xpath("//*[@id=\"view-constituents\"]/ul/li[2]/a"));
        sleep(5000);
        riserTab.click();
        sleep(5000);
        WebElement confirmOnRiserPage = driver.findElement(By.className("main"));
        test.log(LogStatus.INFO, "Navigating to FTSE 100 riser page");
        assertEquals(confirmOnRiserPage.getText(),"FTSE 100: TOP 20 RISERS");
        WebElement theHighestRiser = driver.findElement(By.xpath("//*[@id=\"ls-row-RB.-L\"]/td[2]"));
        test.log(LogStatus.INFO, "The highest risers in the FTSE 100 is " + theHighestRiser.getText());


    }




//        sleep(2000);







    @AfterMethod

    public void getResult(ITestResult result){
        driver.close();
        if(result.getStatus() == ITestResult.FAILURE){
            test.log(LogStatus.FAIL, "Test has failed " + result.getName());
            test.log(LogStatus.FAIL, "Test has failed " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(LogStatus.PASS, "Test has passed " + result.getName());
        }
        report.endTest(test);
    }

    @AfterTest
    public void endReport(){
        report.flush();
        report.close();
    }



}
