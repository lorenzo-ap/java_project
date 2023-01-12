package jTable_lorenzo_ap;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String path = "data.xlsx";
        XSSFWorkbook workbook = FileUtils.readFile(path);
        ExcelService excelService = new ExcelService(workbook);
        String[] headers = excelService.getHeaders();
        String[][] content = excelService.getContent();
        TableBuilder tableBuilder = new TableBuilder(content, headers);
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Row Filter");
            frame.add(tableBuilder);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}