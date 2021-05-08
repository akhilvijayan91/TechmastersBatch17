package selbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Logginwithexcelread {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.className("login")).click();
        try {
            File fl = new File("C:\\Users\\asivan\\Documents\\Personal\\Java Selenium\\Excel\\Firstlogin.xlsx");
            FileInputStream fs = new FileInputStream(fl);
            XSSFWorkbook xl = new XSSFWorkbook(fs);
            XSSFSheet xsl =  xl.getSheet("Login");
            XSSFRow xr1 = xsl.getRow(0);
            XSSFCell XC1 =xr1.getCell(0);
            XSSFCell XC2 =xr1.getCell(1);
            String u = XC1.getStringCellValue();
            String P = XC2.getStringCellValue();
            driver.findElement(By.id("email")).sendKeys(u);
            driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(P);
            driver.findElement(By.name("SubmitLogin")).click();
            xl.close();

        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch (IOException ie)
        {
            System.out.println("IO Exception");
        }
    }
}
