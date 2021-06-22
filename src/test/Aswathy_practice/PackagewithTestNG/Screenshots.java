package PackagewithTestNG;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshots {
    public static  String screenshot(WebDriver driver,String scrname) throws IOException {
        TakesScreenshot tk = (TakesScreenshot) driver;
        File s = tk.getScreenshotAs(OutputType.FILE);
        String path =System.getProperty("user.dir")+"/Screenshot/"+scrname+System.currentTimeMillis()+".jpg";
        File d = new File(path);
        //File d = new File("./Screenshot/sampleshot.png");
        FileUtils.copyFile(s,d);
        return path;
    }
}
