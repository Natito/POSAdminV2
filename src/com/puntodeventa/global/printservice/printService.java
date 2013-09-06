/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.printservice;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.PrintQuality;
import org.icepdf.core.exceptions.PDFSecurityException;
import org.icepdf.core.pobjects.Document;
import org.icepdf.core.views.DocumentViewController;
import org.icepdf.ri.common.PrintHelper;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.views.DocumentViewControllerImpl;

/**
 *
 * @author Nato
 */
public class printService {    
    /*     
     * public static boolean silentJPdfPrint(String filePath) {
        try {
            PDFPrint pdfPrint = new PDFPrint(filePath, null);
            pdfPrint.printToDefaultPrinter(null);
            return true;
        } catch (PDFException | PrinterException t) {
            t.printStackTrace();
            return false;
        }
    }*/

    public static void impresion() {
        // tu archivo a imprimir        
        String file = "D:\\vPuntoVenta/ventas/2719745.pdf";


        // establecemos algunos atributos de la impresora        
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        aset.add(MediaSizeName.ISO_A4);
        //aset.add(new Copies(1));

        // definimos el tipo a imprimir
        DocFlavor docFlavor = DocFlavor.INPUT_STREAM.TEXT_HTML_UTF_8;

        // mi impresora por default        
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();
        System.out.println("Impresora: " + service.getName());
        try {
            PrintService printservices[] = PrintServiceLookup.lookupPrintServices(docFlavor, aset);
            System.out.println("PrintService: " + printservices[0].getName());
        } catch (Exception ex) {
            System.out.println("Formato de impresion: " + ex.getMessage());
            System.out.println("PrintService: " + ex.getLocalizedMessage());
        }


        Doc docPrint;
        try {
            docPrint = new SimpleDoc(new FileInputStream(file), docFlavor, null);
        } catch (FileNotFoundException e1) {
            System.err.println("Archivo no encontrado: " + e1.getMessage());
            return;
        }
        // inicio el proceso de impresion...
        DocPrintJob printJob = service.createPrintJob();
        try {
            printJob.print(docPrint, aset);
            System.out.println("Impresion realizada...");
        } catch (PrintException e) {
            System.err.println("Error de impresion: " + e.getMessage());
        }
    }

    public static void printByteArray(byte[] fileByte) {
        // Definimos el tipo a imprimir
        DocFlavor docFlavor = DocFlavor.BYTE_ARRAY.PDF;
        // establecemos algunos atributos de la impresora
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        //aset.add(MediaSizeName.ISO_A4);
        //aset.add(new Copies(1));
        // mi impresora por default
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();
        System.out.println("Impresora: " + service.getName());
        Doc docPrint;
        try {
            docPrint = new SimpleDoc(fileByte, docFlavor, null);
        } catch (Exception e) {
            System.out.println("Error en archivo: " + e.getMessage());
            return;
        }
        // inicio el proceso de impresion...
        DocPrintJob printJob = service.createPrintJob();
        try {
            printJob.print(docPrint, aset);
            System.out.println("Impresion realizada...");
        } catch (PrintException e) {
            System.out.println("Error de impresion: " + e.getMessage());
        }
    }

    public static void printPdfUrl() {
        String url = "http://pendientedemigracion.ucm.es/info/tecnomovil/documentos/fjava.pdf";

        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        DocFlavor flavor = DocFlavor.URL.AUTOSENSE;
        //DocFlavor flavor1 = DocFlavor.URL.AUTOSENSE;
        //PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        //PrintService service = ServiceUI.printDialog(null, 200, 200, printService, defaultService, flavor, pras);
        try {
            if (defaultService != null) {
                DocPrintJob job = defaultService.createPrintJob();
                //FileInputStream fis = new FileInputStream(filename1);
                System.out.println("Impresora: " + defaultService.getName());
                URL sUrl = new URL(url);
                DocAttributeSet das = new HashDocAttributeSet();
                //Doc doc = new SimpleDoc(fis, flavor, das);
                Doc doc = new SimpleDoc(sUrl, flavor, das);
                job.print(doc, pras);
                Thread.sleep(10000);
                System.out.println("Impresion realizada...");
            } else {
                System.out.println("Impresion cancelada...");
            }
        } catch (MalformedURLException e) {
            System.out.println("URL no valida: " + e.getMessage());
        } catch (PrintException e) {
            System.out.println("Imposible imprimir el archivo: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("La impresion ha sido interrumpida: " + e.getMessage());
        }
    }

    public static void printICEPdf(String id_folio) {
        try {
            String file = "D:\\vPuntoVenta/ventas/" + id_folio + ".pdf";
            Document pdf = new Document() {
            };
            pdf.setFile(file);
            SwingController sc = new SwingController();
            DocumentViewController vc = new DocumentViewControllerImpl(sc);
            vc.setDocument(pdf);
            // create a new print helper with a specified paper size and print
            // quality
            PrintHelper printHelper = new PrintHelper(vc, pdf.getPageTree(),
                    MediaSizeName.NA_LEGAL, PrintQuality.DRAFT);
            // try and print pages 1 - 10, 1 copy, scale to fit paper.
            PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();

            //printHelper.setupPrintService(defaultService, 0, 9, 1, true);
            printHelper.setupPrintService(defaultService, 0, 0, 1, true);
            // print the document
            printHelper.print();
        } catch (PrintException ex) {
            System.out.println("1: " + ex.getMessage());
        } catch (org.icepdf.core.exceptions.PDFException ex) {
            System.out.println("2: " + ex.getMessage());
        } catch (PDFSecurityException ex) {
            System.out.println("3: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("4: " + ex.getMessage());
        }
    }

    public static void printICEPdf(String pathPDF, String namePDF) throws PDFSecurityException {
        try {
            String file = pathPDF + namePDF;
            System.out.println("File: " + file);
            Document pdf = new Document() {
            };
            pdf.setFile(file);
            SwingController sc = new SwingController();
            DocumentViewController vc = new DocumentViewControllerImpl(sc);
            vc.setDocument(pdf);
            // create a new print helper with a specified paper size and print
            // quality
            PrintHelper printHelper = new PrintHelper(vc, pdf.getPageTree(),
                    MediaSizeName.NA_LEGAL, PrintQuality.DRAFT);
            // try and print pages 1 - 10, 1 copy, scale to fit paper.
            PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();

            //printHelper.setupPrintService(defaultService, 0, 9, 1, true);
            printHelper.setupPrintService(defaultService, 0, 0, 1, true);
            // print the document
            printHelper.print();
        } catch (PrintException ex) {
            System.out.println("1: " + ex.getMessage());            
        } catch (org.icepdf.core.exceptions.PDFException ex) {
            System.out.println("2: " + ex.getMessage());
        } catch (PDFSecurityException ex) {
            System.out.println("3: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("4: " + ex.getMessage());
        }
    }

    

    
}
