package selbasics;

public class Handleexceptionwithtrycatchfinally {
    public static void main(String[] args) {
        int a=0,b=10,c=0;
        try
        {
            c=b/a;

        }
        catch (ArithmeticException e)
        {
            System.out.println("Arthimetic exception");
            }
        finally {
            System.out.println("End of the Pgm");
        }

    }
}
