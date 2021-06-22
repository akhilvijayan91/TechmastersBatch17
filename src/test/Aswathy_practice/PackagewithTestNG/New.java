package PackagewithTestNG;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class New {
    @Test(groups = "First")
    public  void  sample0()
    {
        System.out.println("sample0");

    }
    @Test(groups = "First")
    public  void  sample1()
    {
        System.out.println("sample1");

    }@Test(groups = "Second")
    public  void  sample2()
    {
        System.out.println("sample2");

    }
    @Test(groups = "First")
    public  void  sample3()
    {
        System.out.println("sample3");

    }
    @Test(groups = "None")
    public  void  sample4()
    {
        System.out.println("sample4");

    }
    @BeforeGroups("First")
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
