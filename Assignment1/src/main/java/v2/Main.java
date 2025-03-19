package v2;

import v2.EmployeeManagementSystem.EmployeeManagementSystem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem esm = new EmployeeManagementSystem();
        esm = populateEsm(esm);
        esm.instructions();
    }

    public static EmployeeManagementSystem populateEsm(EmployeeManagementSystem esm){
        //populate using json
        List<Object> dummyData = readEmployeesFromJson("employees2.json");
        for (Object obj : dummyData) {
            // Cast the Object to Map<String, Object>
            Map<String, Object> employeeMap = (Map<String, Object>) obj;

            // Create a new Employee instance and populate it
            Employee employee = new Employee();
            employee.setName((String) employeeMap.get("name"));
            employee.setAge(((Number) employeeMap.get("age")).intValue());
            employee.setEmployeeId(((Number) employeeMap.get("employeeId")).longValue());
            employee.setDepartment((String) employeeMap.get("department"));
            employee.setSalary(((Number) employeeMap.get("salary")).doubleValue());
            employee.setReadyForRetire((Boolean) employeeMap.get("isReadyForRetire"));

            // Add the Employee object to the list
            esm.addEmployee(employee);
        }
        return esm;
    }

    private static List<Object> readEmployeesFromJson(String fileName) {
        Gson gson = new Gson();
        List<Object> employees = null;

        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(fileName);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            if (inputStream == null) {
                throw new FileNotFoundException("File not found: " + fileName);
            }

            Type employeeListType = new TypeToken<List<Object>>() {}.getType();
            employees = gson.fromJson(br, employeeListType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }
}