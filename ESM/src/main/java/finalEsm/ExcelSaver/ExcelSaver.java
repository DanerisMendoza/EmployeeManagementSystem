package finalEsm.ExcelSaver;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import finalEsm.Entity.Employee;
import finalEsm.Service.EmployeeManagementSystem;
import finalEsm.Service.EmployeeManagementSystem.EmployeeCollection;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;

public class ExcelSaver {

    public static void saveToExcel(String filePath, EmployeeManagementSystem esm) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Employees");

        int rowNum = 0;

        // Header row
        Row headerRow = sheet.createRow(rowNum++);
        String[] headers = {"ID", "First Name", "Last Name", "Department", "Years", "Salary", "Bonus", "Benefits"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);

            // Optional: make header bold
            CellStyle style = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            style.setFont(font);
            cell.setCellStyle(style);
        }

        // Get employees from the list collection
        Collection<Employee> employees = esm.getAllEmployee(EmployeeCollection.list);

        // Write employee rows
        for (Employee emp : employees) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(emp.getId());
            row.createCell(1).setCellValue(emp.getFirstName());
            row.createCell(2).setCellValue(emp.getLastName());
            row.createCell(3).setCellValue(emp.getDepartment());
            row.createCell(4).setCellValue(emp.getYearOfServices());
            row.createCell(5).setCellValue(emp.getSalary());
            row.createCell(6).setCellValue(emp.getBonus());

            String benefitsStr = String.join(",", emp.getBenefits());
            row.createCell(7).setCellValue(benefitsStr);
        }

        // Auto size columns
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Save to file
       try {
            // ✅ Ensure the directory exists
            File file = new File(filePath);
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs(); // create folders if needed
            }

            FileOutputStream fos = new FileOutputStream(file);
            workbook.write(fos);
            workbook.close();
            fos.close();

            System.out.println("Excel file saved to: " + filePath);
        } catch (IOException e) {
            System.err.println("Failed to save Excel file: " + filePath);
            e.printStackTrace();
        }
    }
}
