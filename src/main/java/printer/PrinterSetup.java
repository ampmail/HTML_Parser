package printer;

import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class PrinterSetup {

    public static void main(String[] args) throws Exception {
        PrinterJob pjob = PrinterJob.getPrinterJob();
        PageFormat pf = pjob.defaultPage();
        pjob.setPrintable(null, pf);

        if (pjob.printDialog()) {
            pjob.print();
        }
    }
/*
    private static void func (){
        PrinterJob pj = PrinterJob.getPrinterJob();
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        System.out.println("Number of printers configured: " + printServices.length);
        for (PrintService printer : printServices) {
            System.out.println("Printer: " + printer.getName());
            if (printer.getName().equals("***MYPRINTER***")) {
                try {
                    pj.setPrintService(printer);
                } catch (PrinterException ex) {
                }
            }
        }
    }
*/
}