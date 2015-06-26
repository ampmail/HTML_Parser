package msExcelParser;

import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.lex.ExcelReader;

public class test {
    public static void main(String[] args) {

        try {
            ExcelReader reader = new ExcelReader();
            Workbook xlWorkbook = reader.getWorkbook("d:\\Git\\ScriptServer\\tmp\\test_ok.xml");
            System.out.println(xlWorkbook.getSheetNames());
            System.out.println(xlWorkbook.getTagName());
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
    }
}