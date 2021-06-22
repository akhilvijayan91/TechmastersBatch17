package PackagewithTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class loginwithdataprovider {
    public WebDriver driver;
    @DataProvider(name = "logindetails")
    public Object[][] cred()
    {
        return new Object[][] {{"aswathy@gmail.com","aswathy@123"},{"arathysivan@gmail.com","arathy@123"}};
    }
    @BeforeMethod
    public void initial()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\asivan\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "logindetails")
    public void login(String username, String password) throws InterruptedException {

        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement((By.xpath("//input[@id='passwd']"))).sendKeys(password);
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
    @AfterMethod
    public void end()
    {
        driver.close();
    }



}
