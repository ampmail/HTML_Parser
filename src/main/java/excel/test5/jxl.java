package excel.test5;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by ampuser on 05.11.2015.
 */
public class jxl {
    public static void main(String[] args) throws Exception {
        jxl.parse("C:\\Users\\ampuser\\Downloads\\forDCNV_RED.xls");
//        JXL.doit("C:\\Users\\ampuser\\Downloads\\price-26-10-15.xlsx");
        jxl.parse("C:\\Users\\ampuser\\Downloads\\price-26-10-15.xlsx");
    }

    public static void parse(String file) throws IOException, BiffException {

        File myFile = new File(file);

        Workbook w = Workbook.getWorkbook(myFile);
        System.out.println(Arrays.toString(w.getSheetNames()));

        for (int sheetNumber = 0; sheetNumber < w.getNumberOfSheets(); sheetNumber++){
            Sheet currSheet = w.getSheet(sheetNumber);
            for (int row = 0; row < currSheet.getRows(); row++){
                for (int col = 0; col < currSheet.getColumns(); col++){
                    System.out.print(currSheet.getCell(col, row).getContents());
                    System.out.print("\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void doit(String file) throws Exception {
        Workbook workbook = Workbook.getWorkbook(new File(file));
        Sheet sheet = workbook.getSheet(0);
        Cell policies[] = sheet.getColumn(0);
        for (Cell policy : policies) {
            String nopolicy = policy.getContents();
            //  do something : process(nopolicy);
        }
    }
}
