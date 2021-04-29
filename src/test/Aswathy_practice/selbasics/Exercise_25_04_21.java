package selbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise_25_04_21 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@class='login']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("aswathy@gmail.com");
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("aswathy@123");
        driver.findElement(By.xpath("//button[@id ='SubmitLogin']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@class ='sf-with-ul']")).click();
        driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']")).click();
        Thread.sleep(5000);
        WebElement iframeElement=driver.findElement(By.xpath("//iframe[contains(@id,'fancybox-frame')]"));
        driver.switchTo().frame(iframeElement);
        driver.findElement(By.xpath("//p[@id='add_to_cart']/button/span")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@class='btn btn-default button button-medium']/span/i")).click();
        driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']")).click();
        driver.findElement(By.xpath("//button[@class='button btn btn-default button-medium']")).click();
        driver.findElement(By.xpath("//div[@class='checker']")).click();
        driver.findElement(By.xpath("//button[@class='button btn btn-default standard-checkout button-medium']")).click();
        driver.findElement(By.xpath("//a[@class='bankwire']")).click();
        driver.findElement(By.xpath("//button[@class='button btn btn-default button-medium']")).click();
        String title ="Order confirmation - My Store";
        String ortitle = driver.getTitle();
        if(ortitle.equalsIgnoreCase(title))
        {
            System.out.println("Pass");
        }
        else
        {
            System.out.println("Fail");
        }











    }
}
