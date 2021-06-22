package PackagewithTestNG;

import org.testng.annotations.*;

public class Test1 {
    @Test
    public void sampletest()
    {
        System.out.println("test2");
    }
    @BeforeSuite
    public  void beforesuite()
    {
        System.out.println("before suite");
    }
    @AfterSuite
    public  void aftersuite()
    {
        System.out.println("After suite");
    }
    @BeforeMethod
    public void  beforemethod()
    {
        System.out.println("before method");
    }
    @AfterMethod
    public void  aftermethod()
    {
        System.out.println("after method");
    }
    @BeforeClass
    public void  beforeclass()
    {
        System.out.println("before class");
    }
    @AfterClass
    public void  afterClass()
    {
        System.out.println("after class");
    }

}
