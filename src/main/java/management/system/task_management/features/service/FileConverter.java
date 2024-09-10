package management.system.task_management.features.service;

import org.jodconverter.core.document.DocumentFormat;
import org.jodconverter.core.document.DocumentFormatRegistry;
import org.jodconverter.core.office.OfficeException;
import org.jodconverter.core.office.OfficeManager;
import org.jodconverter.core.office.OfficeUtils;
import org.jodconverter.local.JodConverter;
import org.jodconverter.local.LocalConverter;
import org.jodconverter.local.office.LocalOfficeManager;

import java.io.File;

public class FileConverter {

    private final OfficeManager officeManager;

    public FileConverter() {
        String officeHome = System.getenv("OFFICE_HOME");
        if (officeHome == null || officeHome.isEmpty()) {
            throw new RuntimeException("The OFFICE_HOME environment variable is not set.");
        }

        // Create and start an OfficeManager
        officeManager = LocalOfficeManager.builder()
                .officeHome(new File(officeHome))
                .build();
        try {
            officeManager.start();
        } catch (OfficeException e) {
            throw new RuntimeException("Failed to start office manager", e);
        }
    }

    public void convertFile(File inputFile, File outputFile, String outputFormat) {
        try {
            LocalConverter converter = LocalConverter.builder().build();
            DocumentFormat documentFormat = getDocumentFormat(outputFormat);
            converter.convert(inputFile).to(outputFile).as(documentFormat).execute();
            System.out.println("File converted successfully to " + outputFormat);
        } catch (OfficeException e) {
            System.err.println("Error during file conversion: " + e.getMessage());
        } finally {
            try {
                OfficeUtils.stopQuietly(officeManager);
                officeManager.stop();
            } catch (OfficeException e) {
                System.err.println("Failed to stop office manager: " + e.getMessage());
            }
        }
    }

    private DocumentFormat getDocumentFormat(String outputFormat) {
        DocumentFormatRegistry formatRegistry = LocalConverter.builder().build().getFormatRegistry();
        return formatRegistry.getFormatByExtension(outputFormat);
    }

    public static void main(String[] args) {
//        if (args.length < 3) {
//            System.out.println("Usage: java FileConverter <inputFile> <outputFile> <outputFormat>");
//            System.exit(1);
//        }

//        LocalOfficeManager officeManager = LocalOfficeManager.install();
//
        File inputFile = new File("/Users/bexruz/Downloads/2-форма (3).docx");
        File outputFile = new File("/Users/bexruz/Downloads/test_result.pdf");
//
//        try {
//            officeManager.start();
//            JodConverter.convert(inputFile).to(outputFile).execute();
//        } catch (OfficeException e) {
//            throw new RuntimeException(e);
//        }  finally {
//            OfficeUtils.stopQuietly(officeManager);
//        }

        String outputFormat = "pdf";

        FileConverter converter = new FileConverter();
        converter.convertFile(inputFile, outputFile, outputFormat);
    }

}