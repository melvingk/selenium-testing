package org.example;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SeleniumWithExtentReportTest {

    WebDriver driver;
    ExtentReports report;
    ExtentTest test;

    @BeforeTest
    public void startReport(){
        report = new ExtentReports(
                System.getProperty("user.dir") + "/test-output/Report.html",          //creates a location as to where the report will be stored
                true                                                            //if true, creates a new one/overwrites existing file
                                                                                            // if false, creates another section on the report indicating a new test

        );
        report
                .addSystemInfo("Host Name", "QA")                               //sets up the environmental values in the report, i.e what value the host name will be
                .addSystemInfo("Tester", "Melvin")                              //sets up the environmental values in the report, i.e what value the Tester will be
                .addSystemInfo("Browser","Chrome");
        report.loadConfig(new File(System.getProperty("user.dir") + "\\extent-report.xml"));  //loads the xml file stated
    }

    @BeforeMethod                                                               //annotation used before a test is started
    public void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    public void testQATitle(){
        test = report.startTest("Verifying the title of QA website");                   //report starts with title at the beginning of the test method
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Started chrome browser and made it fullscreen");         //logs that give information on progress of test
        driver.get("https://www.qa.com");
        test.log(LogStatus.INFO, "Navigating to the QA website");
        assertEquals(driver.getTitle(), "Virtual and online classes in technology, project management and leadership | QA");
        test.log(LogStatus.PASS, "The title was exactly the same");                         //logs the status of a pass/fail
    }

    @Test
    public void takeScreenShow() throws IOException {
        test = report.startTest("Checking QA website logo is displayed");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Started chrome browser and made it fullscreen");
        driver.get("https://www.qa.com");
        test.log(LogStatus.INFO, "Navigating to the QA website");
        WebElement logo = driver.findElement(By.id("Path_582"));
        assertTrue(logo.isDisplayed());
        File picture = ((TakesScreenshot) driver). getScreenshotAs(OutputType.FILE);                //takes a screenshot and saves it for a period of time
        FileUtils.copyFile(picture, new File(System.getProperty("user.dir") + "/test-output/logoPage.jpg"));    //saves the screenshot on the file explorer system(on the file directory of the computer)-uses the maven's fileutilis maven library

        test.log(LogStatus.PASS,"The logo was present", "<img src=logoPage.jpg>");          //places image into the Extent Reports

    }
    @Test
    public void useJavaScriptExecutor() throws InterruptedException {
        test = report.startTest("Checking QA website logo is displayed");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Started chrome browser and made it fullscreen");
        driver.get("https://www.qa.com");
        test.log(LogStatus.INFO, "Navigating to the QA website");
        if(driver instanceof JavascriptExecutor)
        {
            ((JavascriptExecutor) driver).executeScript("alert('Helloooo')");
            sleep(1000);
            driver.switchTo().alert().accept();
            sleep(1000);
        }
        else{
            System.out.println("Can't execute JS");
        }
    }
    @AfterMethod                                                                            // annotations used when test is done
    public void getResult(ITestResult result){                                              // A method that accumulates all failures within the method that fails and logs it in the report
        driver.close();
        if(result.getStatus() == ITestResult.FAILURE){
            test.log(LogStatus.FAIL, "Test has failed " + result.getName());
            test.log(LogStatus.FAIL, "Test has failed " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(LogStatus.PASS, "Test has passed " + result.getName());
        }
        report.endTest(test);                                                           //report ends after the excution of test
    }

    @AfterTest
    public void endReport(){                                                    // method ends the whole report
        report.flush();
        report.close();
    }

}
