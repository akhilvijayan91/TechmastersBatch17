package selbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class DragDropPgm {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\asivan\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("http://jqueryui.com/droppable/#default");
        driver.manage().window().maximize();
        Actions at = new Actions(driver);
        WebElement ifr = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(ifr);

        WebElement from = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement to = driver.findElement(By.xpath("//div[@id='droppable']"));
        at.dragAndDrop(from,to).build().perform();

    }
}
