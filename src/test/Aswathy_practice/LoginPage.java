package selbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\asivan\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("aswathy@gmail.com");
        driver.findElement((By.xpath("//input[@id='passwd']"))).sendKeys("aswathy@123");
        driver.findElement(By.name("SubmitLogin")).click();
        Thread.sleep(5000);
        String actualtitle = "My account - My Store";
        String expectedtitle = driver.getTitle();
        if (actualtitle.contentEquals(expectedtitle))
        {
            System.out.println("Pass");

        }
        else {
            System.out.println("Fail");
        }
      /*  driver.findElement(By.className("sfHoverForce")).Click();
        driver.findElements(By.xpath("//div[@class ='block_content list-block']/ul/li"));*/
             //   driver.close();


    }
}
