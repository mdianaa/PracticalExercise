package org.example;

import org.apache.poi.ss.usermodel.*;

import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();

        // get the file using the file path
        File file = new File(filePath);
        while (!file.exists()) {
            System.out.println("The file doesn't exist. Please enter a valid file: ");
            filePath = scanner.nextLine();
            file = new File(filePath);
        }

        try {
            FileInputStream fis = new FileInputStream(filePath);
            // using Apache POI create workbook (the whole Excel file)
            Workbook workbook = WorkbookFactory.create(fis);

            // get the first sheet from the file
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                for (Cell cell : row) {
                    // get the data from the cell
                    CellType cellType = cell.getCellType();
                    if (cellType == CellType.STRING) {
                        System.out.print(cell.getStringCellValue() + "\t");
                    } else if (cellType == CellType.NUMERIC) {
                        System.out.print(cell.getNumericCellValue() + "\t");
                    } else if (cellType == CellType.BOOLEAN) {
                        System.out.print(cell.getBooleanCellValue() + "\t");
                    } else if (cellType == CellType.BLANK) {
                        System.out.print("blank\t");
                    } else {
                        System.out.print("unknown\t");
                    }
                }
                System.out.println();
            }

            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
