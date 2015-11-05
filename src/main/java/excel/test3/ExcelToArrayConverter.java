package excel.test3;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ampuser on 03.11.2015.
 */
public class ExcelToArrayConverter {
    public String[] excelvalue(String columnWanted,int sheet_no){
        int i=0;
        String[] column_content_array =new String[140];
        try{
            int instindicator=-1;
            InputStream fileIn = this.getClass().getClassLoader().getResourceAsStream("db.xls");
            POIFSFileSystem fs = new POIFSFileSystem(fileIn);
            HSSFWorkbook filename = new HSSFWorkbook(fs);
            HSSFSheet sheet = filename.getSheetAt(sheet_no);                                                // in the row 0 (which is first row of a work sheet)                                                    // search for column index containing string "Inst_Code"
            Integer columnNo = null;
            Integer rowNo = null;
            List<Cell> cells = new ArrayList<Cell>();
            Row firstRow = sheet.getRow(0);
            for (Cell cell : firstRow) {
                if (cell.getStringCellValue().equals(columnWanted)) {
                    columnNo = cell.getColumnIndex();
                    rowNo=cell.getRowIndex();
                }
            }
            if (columnNo != null) {
                for (Row row : sheet) {
                    Cell c = row.getCell(columnNo);
                    String cell_value=""+c;
                    cell_value=cell_value.trim();
                    try{
                        if((!cell_value.equals(""))&&(!cell_value.equals("null"))&&(!cell_value.equals(columnWanted))){
                            column_content_array[i]=cell_value;
                            i++;
                        }}
                    catch(Exception e){
                    }

                }
                return column_content_array;
            }}
        catch(Exception ex){
            return column_content_array;
        }
        return column_content_array;
    }
}