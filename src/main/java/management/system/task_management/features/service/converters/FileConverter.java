package management.system.task_management.features.service.converters;

import java.io.File;
import java.io.IOException;

public class FileConverter {

    public static void main(String[] args) {
        String docxFilePath =
                "/Users/bexruz/Desktop/eReportFilesTest/official_files_docx/53-форма.docx";
        String outputDirPath =
                "/Users/bexruz/Desktop/eReportFilesTest";
        convertToPdf(
                docxFilePath,
                outputDirPath
        );
    }

    public static void convertToPdf(
            String docxFilePath,
            String outputDirPath
    ) {
        File file = new File(
                docxFilePath
        );
        if (!file.exists()) {
            System.out.println("File not found: " + docxFilePath);
            return;
        }
        // Ensure the output directory exists
        File outputDir = new File(outputDirPath);
        if (!outputDir.exists()) {
            outputDir.mkdirs(); // Create the directory if it does not exist
        }
        ProcessBuilder processBuilder = new ProcessBuilder(
                "/Applications/LibreOffice.app/Contents/MacOS/soffice",
                "--headless",
                "--convert-to", "pdf",
                "--outdir",
                outputDirPath,
                docxFilePath
        );
        try {
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println(
                        "Conversion successful. Check output in: " + outputDirPath
                );
            } else {
                System.out.println(
                        "Conversion failed with exit code: " + exitCode
                );
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}