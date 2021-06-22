package PackagewithTestNG;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Extentreportwithscreenshot {
    WebDriver driver;
    static ExtentReports report;
    static ExtentTest logger;
    ExtentSparkReporter spark;
    @BeforeClass
    public  void reportinit()
    {
        spark = new ExtentSparkReporter("./extentreports/extentreportsample.html");
        report = new ExtentReports();
        report.attachReporter(spark);
        spark.config().setReportName("Sample1");
        spark.config().setDocumentTitle("Report");
        spark.config().setTheme(Theme.STANDARD);
    }
    @Test
    public void login()
    {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("aswathy@gmail.com");
        driver.findElement((By.xpath("//input[@id='passwd']"))).sendKeys("aswathy@123");
        driver.findElement(By.name("SubmitLogin")).click();
       // Thread.sleep(5000);
        Assert.assertTrue(driver.getTitle().contains("My account - My Store"));
        logger=report.createTest("TitleMatching");
        logger.info("Entering username :aswathy@gmail.com");
        logger.info("Entering password :aswathy@123");


    }
    @Test
    public void loginfail()
    {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("arathy@gmail.com");
        driver.findElement((By.xpath("//input[@id='passwd']"))).sendKeys("aswathy@123");
        driver.findElement(By.name("SubmitLogin")).click();
        //Thread.sleep(5000);
        Assert.assertTrue(driver.getTitle().contains("Women"));
        logger=report.createTest("TitleMissMatching");
        logger.info("Entering username :arathy@gmail.com");
        logger.info("Entering password :aswathy@123");
        //Assert.assertTrue(driver.getTitle().contains("Shopping"));

    }
    @AfterMethod
    public  void  reportresultcheck(ITestResult res) throws IOException {
       String temp = Screenshots.screenshot(driver,res.getName());
        if (res.getStatus() == ITestResult.FAILURE) {
            logger.log(Status.FAIL, MarkupHelper.createLabel(res.getMethod().getMethodName() + " Test case FAILED due to below issues:", ExtentColor.RED));
            //logger.fail(res.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            logger.log(Status.FAIL, (Markup) MediaEntityBuilder.createScreenCaptureFromBase64String(temp));
        }
        else if (res.getStatus()==ITestResult.SUCCESS)
        {
            logger.log(Status.PASS, MarkupHelper.createLabel(res.getMethod().getMethodName() + " Test case SUCCESS", ExtentColor.GREEN));
        }
        else if (res.getStatus()== ITestResult.SKIP)
        {
            logger.log(Status.SKIP, MarkupHelper.createLabel(res.getMethod().getMethodName(), ExtentColor.ORANGE));
        }
        driver.close();

    }
    @AfterClass
    public void reportprint()
    {
        report.flush();

    }

}
