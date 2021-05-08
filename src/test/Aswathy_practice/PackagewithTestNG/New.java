package PackagewithTestNG;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class New {
    @Test
    public  void  sample()
    {
        System.out.println("sample");

    }
    @Test
    public  void  sample2()
    {
        System.out.println("sample2");

    }
    @BeforeTest
    public void beforetest()
    {
        System.out.println("before test");
    }
    @AfterTest
    public void aftertest()
    {
        System.out.println("After test");
    }

}
