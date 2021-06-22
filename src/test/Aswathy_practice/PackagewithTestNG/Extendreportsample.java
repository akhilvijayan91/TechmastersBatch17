package PackagewithTestNG;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Extendreportsample {
    WebDriver driver;
    ExtentReports report;
    ExtentTest logger;
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
        logger=report.createTest("TitleMatching");
        Assert.assertTrue(driver.getTitle().contains("Store"));


    }
    @Test
    public void loginfail()
    {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        logger=report.createTest("TitleMissMatching");
        Assert.assertTrue(driver.getTitle().contains("Shopping"));

    }
    @AfterMethod
    public  void  reportresultcheck(ITestResult res) {
        if (res.getStatus() == ITestResult.FAILURE) {
            logger.log(Status.FAIL, MarkupHelper.createLabel(res.getMethod().getMethodName() + " Test case FAILED due to below issues:", ExtentColor.RED));
        }
        else if (res.getStatus()==ITestResult.SUCCESS)
        {
            logger.log(Status.PASS, MarkupHelper.createLabel(res.getMethod().getMethodName() + " Test case SUCCESS", ExtentColor.GREEN));
        }
        driver.close();

    }
    @AfterClass
    public void reportprint()
    {
        report.flush();

    }


}
