package selbasics;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Excelcreate {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\Users\\asivan\\Documents\\Personal\\Java Selenium\\Excel\\EXCELCREATE.xlsx");
        FileOutputStream fo = new FileOutputStream(f);
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sh = wb.createSheet("Test1");
       // XSSFSheet sh = wb.getSheet("Test");
        //XSSFRow R = sh.createRow(0);
      //  XSSFCell C = R.createCell(0);
      sh.createRow(0).createCell(0).setCellValue("test");
      wb.write(fo);
      wb.close();
    }
}
