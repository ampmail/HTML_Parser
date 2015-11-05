package excel.openXLS;

import com.extentech.ExtenXLS.*;
import com.extentech.formats.XLS.Sheet;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by ampuser on 05.11.2015.
 */
public class OpenXLS {

    public static void main(String[] args) {
//        doit("forDCNV_RED.xls", "Price R");
        doit("06.11 прайс Рубин.xls", "");
    }

    public static void doit(String finpath, String sheetname) {
        String workingdir = "D:\\Temp\\1\\";
        System.out.println("Begin parsing: " + workingdir + finpath);
        WorkBookHandle tbo = new WorkBookHandle(workingdir + finpath);

        try {
//            WorkSheetHandle sheet = tbo.getWorkSheet(sheetname);
            System.out.println(tbo.getActiveSheet().getSheetName());
            WorkSheetHandle sheet = tbo.getWorkSheet(tbo.getActiveSheet().getSheetName());
            System.out.println(sheet.getFirstCol() + "\t" + sheet.getFirstRow());
            for (int row = 0; row < sheet.getNumRows(); row++){
                for (int col = 0; col <= sheet.getNumCols(); col++){
                    System.out.print(sheet.getCell(row, col).getStringVal());
                    System.out.print("\t");
                }
                System.out.println();
            }
            System.out.println();

            if (false) {
                // read images from sheet -- .gif, .png, .jpg
                ImageHandle[] extracted = sheet.getImages();
                // extract and output images
                for (Integer t = 0; t < extracted.length; t++) {
                    System.out.println("Successfully extracted: "
                            + workingdir + "testImageOut_"
                            + extracted[t].getName() + "."
                            + extracted[t].getType());

                    FileOutputStream outimg = new FileOutputStream
                            (workingdir + "tmp\\" + extracted[t].getName() + t.toString() + "." + extracted[t].getType());
                    extracted[t].write(outimg);
                    outimg.flush();
                    outimg.close();
                }
            }

/*
            tbo = new WorkBookHandle();
            sheet = tbo.getWorkSheet("Sheet1");
            CellHandle a1 = sheet.add
                    ("New workbook with 3 images: a gif, a jpg, and a png", "A1");

            // get gif image input stream
            FileInputStream fin = new FileInputStream
                    (workingdir + "testImages.gif");

            // add to sheet
            ImageHandle giffy = new ImageHandle(fin, sheet);

            // set picture size and location in sheet
            short[] sh = {100, 100, 400, 200};
            giffy.setBounds(sh);
            giffy.setName("giffy");
            sheet.insertImage(giffy);

            // add to sheet
            for (int x = 0; x < 100; x++) {
                fin = new FileInputStream(workingdir + "testImages.png");
                ImageHandle jpgy = new ImageHandle(fin, sheet);
                jpgy.setName("heart" + x);
                // set the random x/y coords of picture
                int ix = Math.round((float) ((x * (Math.random() * 10))));
                jpgy.setX(100 + ix);
                ix = Math.round((float) ((x * (Math.random() * 10))));
                jpgy.setY(100 + ix);
                sheet.insertImage(jpgy);
            }
            // get png image input stream
            fin = new FileInputStream(workingdir + "testImages.jpg");
            // add to sheet
            ImageHandle pngy = new ImageHandle(fin, sheet);
            // set just the x/y coords of picture
            pngy.setX(10);
            pngy.setY(200);
            sheet.insertImage(pngy);
*/

        } catch (Exception e) {
            System.err.println("testImages failed: " + e.toString());
        }
//        testWrite(tbo, workingdir + "testImagesOut.xls");
//        WorkBookHandle newbook = new WorkBookHandle
//                (workingdir + "testImagesOut.xls", 0);
//        System.out.println("Successfully read: " + newbook);

    }

    public static void testWrite(WorkBookHandle b, String fout) {
        try {
            java.io.File f = new java.io.File(fout);
            FileOutputStream fos = new FileOutputStream(f);
            BufferedOutputStream bbout = new BufferedOutputStream(fos);
            bbout.write(b.getBytes());
            bbout.flush();
            fos.close();
        } catch (java.io.IOException e) {
            System.err.println("IOException in Tester.  " + e);
        }
    }
}
