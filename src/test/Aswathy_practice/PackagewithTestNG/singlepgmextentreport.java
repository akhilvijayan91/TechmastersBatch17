package PackagewithTestNG;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;

import java.io.IOException;

public class singlepgmextentreport
{

    public WebDriver driver;
    public ExtentReports report;
    public ExtentTest logger;
    public ExtentSparkReporter spark;
    ITestResult res;

    public ITestResult exreport() throws InterruptedException, IOException
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        spark = new ExtentSparkReporter("./extentreports/extentreportsample.html");
        report = new ExtentReports();
        report.attachReporter(spark);
        spark.config().setReportName("Sample1");
        spark.config().setDocumentTitle("Report");
        spark.config().setTheme(Theme.STANDARD);
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("arathy@gmail.com");
        driver.findElement((By.xpath("//input[@id='passwd']"))).sendKeys("aswathy@123");
        driver.findElement(By.name("SubmitLogin")).click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.getTitle().contains("Women"));
        logger = report.createTest("TitleMissMatching");
        logger.info("Entering username :arathy@gmail.com");
        logger.info("Entering password :aswathy@123");
        Assert.assertTrue(driver.getTitle().contains("Shopping"));
        return res;
    }

    public  void PrintResult(ITestResult res) throws IOException {
        String temp = Screenshots.screenshot(driver, res.getName());
        if (res.getStatus() == ITestResult.FAILURE) {
            logger.log(Status.FAIL, MarkupHelper.createLabel(res.getMethod().getMethodName() + " Test case FAILED due to below issues:", ExtentColor.RED));
            logger.fail(res.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        } else if (res.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS, MarkupHelper.createLabel(res.getMethod().getMethodName() + " Test case SUCCESS", ExtentColor.GREEN));
        } else if (res.getStatus() == ITestResult.SKIP) {
            logger.log(Status.SKIP, MarkupHelper.createLabel(res.getMethod().getMethodName(), ExtentColor.ORANGE));
        }
        report.flush();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        singlepgmextentreport sr = new singlepgmextentreport();
        sr.exreport();
        sr.PrintResult(sr.res);

    }
 }



