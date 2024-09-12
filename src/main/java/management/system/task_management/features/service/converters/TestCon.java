//package management.system.task_management.features.service.converters;
//
//import com.itextpdf.text.pdf.codec.Base64;
//import org.apache.poi.xwpf.converter.pdf.PdfConverter;
//import org.apache.poi.xwpf.converter.pdf.PdfOptions;
//import org.apache.poi.xwpf.usermodel.XWPFDocument;
//
//import java.io.*;
//
//public class TestCon {
//
//    public static void main(String[] args) {
//        TestCon cwoWord = new TestCon();
//        System.out.println("Start");
//        cwoWord.ConvertToPDF("/Users/bexruz/Desktop/eReportFilesTest/official_files_docx/53-форма.docx",
//                "/Users/bexruz/Desktop/eReportFilesTest/53-форма-CONVERTED.pdf");
//    }
//
//    public void ConvertToPDF(String docPath, String pdfPath) {
//        try {
//            InputStream doc = new FileInputStream(new File(docPath));
//            XWPFDocument document = new XWPFDocument(doc);
//            PdfOptions options = PdfOptions.create();
//            OutputStream out = new FileOutputStream(new File(pdfPath));
//            PdfConverter.getInstance().convert(document, out, options);
//            System.out.println("Done");
//        } catch (FileNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        } catch (IOException ex) {
//
//            System.out.println(ex.getMessage());
//        }
//    }
//
//}
