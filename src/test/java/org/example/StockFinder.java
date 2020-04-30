package org.example;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;

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
    public void stockMarketHighestRiser(){
        test = report.startTest("Identifying the highest riser");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Started chrome browser and made it fullscreen");
        driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100");
        test.log(LogStatus.INFO, "Navigating to Hargreaves Lansdown, FTSE 100 webpage");
        assertEquals(driver.getTitle(), "FTSE 100 Market overview | Hargreaves Lansdown");
        test.log(LogStatus.PASS, "The titles match");
        WebElement riserTab = driver.findElement(By.xpath("//*[@id=\"view-constituents\"]/ul/li[2]/a"));
        riserTab.click();



    }

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
