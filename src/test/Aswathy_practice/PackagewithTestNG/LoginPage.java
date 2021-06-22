package PackagewithTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPage {
    public WebDriver driver;
    @BeforeClass
    public void initial()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\asivan\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }
    @Test
   public void login() throws InterruptedException {

        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("aswathy@gmail.com");
        driver.findElement((By.xpath("//input[@id='passwd']"))).sendKeys("aswathy@123");
        driver.findElement(By.name("SubmitLogin")).click();
        Thread.sleep(5000);
        String actualtitle = "My account - My Store";
        String expectedtitle = driver.getTitle();
        if (actualtitle.contentEquals(expectedtitle)) {
            System.out.println("Pass");

        } else {
            System.out.println("Fail");
        }
    }
        @AfterClass
                public void end()
       {
           driver.close();
       }




}
