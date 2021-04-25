package selbasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPgm {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\asivan\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/selenium/delete_customer.php");
        driver.manage().window().maximize();
        WebElement txt = driver.findElement(By.name("cusid"));
        txt.sendKeys("xt124");
        WebElement sb = driver.findElement(By.xpath("//input[@name ='submit']"));
        sb.click();
        Alert al = driver.switchTo().alert();
        String s = al.getText();
        System.out.println(s);
        al.accept();

    }
}
