package selbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Webtable {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\asivan\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("datepicker")).click();
        driver.findElement(By.xpath("//span[@Class='ui-icon ui-icon-circle-triangle-e']")).click();
        List <WebElement> dp = driver.findElements(By.xpath("//a[contains(@class,'ui-state-default')]"));

        for (WebElement ch:dp)
        {
            String s = ch.getText();
             if(s.contentEquals("24"))
             {
                 ch.click();
                 break;
             }


        }

    }
}
