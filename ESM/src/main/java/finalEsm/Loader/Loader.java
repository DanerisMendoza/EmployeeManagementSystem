package finalEsm.Loader;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import finalEsm.Entity.Developer;
import finalEsm.Entity.Manager;
import finalEsm.Exception.DuplicateEmployeeException;
import finalEsm.Service.EmployeeManagementSystem;
import finalEsm.Entity.Employee;
public class Loader {

    public static void loadFromExcel(String fileName, EmployeeManagementSystem esm) throws IOException {
        // Load file from resources
        InputStream inputStream = Loader.class.getClassLoader().getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IOException("File not found in resources: " + fileName);
        }

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        
        Iterator<Row> rows = sheet.iterator();
        if (rows.hasNext()) rows.next(); // skip header

        while (rows.hasNext()) {
            Row row = rows.next();

            int id = (int) row.getCell(0).getNumericCellValue();
            String firstName = row.getCell(1).getStringCellValue();
            String lastName = row.getCell(2).getStringCellValue();
            String department = row.getCell(3).getStringCellValue();
            int years = (int) row.getCell(4).getNumericCellValue();
            double salary = row.getCell(5).getNumericCellValue();
            double bonus = row.getCell(6).getNumericCellValue();
            String benefitsStr = row.getCell(7).getStringCellValue();

            Set<String> benefits = new HashSet<>(Arrays.asList(benefitsStr.split(",")));

            Employee employee;
            
            
            if (department.equalsIgnoreCase("IT") || department.equalsIgnoreCase("Finance")) {
                employee = new Developer(id, firstName, lastName, department, years, salary, benefits, bonus);
            } else {
                employee = new Manager(id, firstName, lastName, department, years, salary, benefits, bonus);
            }
            
            // System.out.println("Test: "+employee.toString());
            try {
                esm.addEmployee(employee);
            } catch (DuplicateEmployeeException e) {
                System.out.println("Skipping duplicate employee: " + id);
            }
        }

        workbook.close();
        inputStream.close();
    }
}
