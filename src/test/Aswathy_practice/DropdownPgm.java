package selbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPgm {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\asivan\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("aswathy@gmail.com");
        driver.findElement((By.xpath("//input[@id='passwd']"))).sendKeys("aswathy@123");
        driver.findElement(By.name("SubmitLogin")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("sf-with-ul")).click();
        Select se = new Select(driver.findElement(By.id("selectProductSort")));
        se.selectByValue("name:asc");
        se.selectByVisibleText("Product Name: Z to A");
    }
}
