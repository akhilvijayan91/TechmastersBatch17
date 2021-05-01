package selbasics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static org.apache.poi.ss.usermodel.Workbook.*;

public class Sampleexcelread {
    public static void main(String[] args) {
        try {
            File f = new File("C:\\Users\\asivan\\Documents\\Personal\\Java Selenium\\Excel\\Sampledata1.xlsx");
            FileInputStream fi = new FileInputStream(f);
            XSSFWorkbook xw =new XSSFWorkbook(fi);
            XSSFSheet xs = xw.getSheet("Sample_sheet1");
            int rwcount = xs.getLastRowNum()-xs.getFirstRowNum();
            for(int i=1;i<=rwcount;i++)
            {
                XSSFRow rw =xs.getRow(i);
                for (int j=0;j<rw.getLastCellNum();j++)
                {
                    System.out.println(rw.getCell(j).getStringCellValue());
                }

            }
            xw.close();
        }
        catch (Exception e)
        {
            System.out.println("exception");
        }



    }
}
