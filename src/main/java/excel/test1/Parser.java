package excel.test1;

/**
 * Created by ampuser on 02.11.2015.
 */
        import org.apache.poi.POIXMLDocument;
        import org.apache.poi.hssf.usermodel.HSSFWorkbook;
        import org.apache.poi.openxml4j.opc.OPCPackage;
        import org.apache.poi.poifs.filesystem.POIFSFileSystem;
        import org.apache.poi.ss.usermodel.Cell;
        import org.apache.poi.ss.usermodel.Row;
        import org.apache.poi.ss.usermodel.Sheet;
        import org.apache.poi.ss.usermodel.Workbook;
        import org.apache.poi.xssf.usermodel.XSSFWorkbook;

        import java.io.FileInputStream;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.PushbackInputStream;
        import java.util.Iterator;

public class Parser {

    public static String parse(String name) {

        String result = "";
        InputStream inputStream = null;
        InputStream inp;
        Workbook wb = null;
        try {
            inp = new FileInputStream(name);
            if(!inp.markSupported()) {
                inputStream = inp;
                inp = new PushbackInputStream(inp, 8);
            }

            if(POIFSFileSystem.hasPOIFSHeader(inp)) {
                wb =  new HSSFWorkbook(inp);
            }
            if(POIXMLDocument.hasOOXMLHeader(inp)) {
                wb =  new XSSFWorkbook(OPCPackage.open(inputStream));
                System.out.println(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Sheet sheet = wb.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                int cellType = cell.getCellType();
                switch (cellType) {
                    case Cell.CELL_TYPE_STRING:
                        result += cell.getStringCellValue() + "=";
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        result += "[" + cell.getNumericCellValue() + "]";
                        break;

                    case Cell.CELL_TYPE_FORMULA:
                        result += "[" + cell.getNumericCellValue() + "]";
                        break;
                    default:
                        result += "|";
                        break;
                }
            }
            result += "\n";
        }

        return result;
    }

}