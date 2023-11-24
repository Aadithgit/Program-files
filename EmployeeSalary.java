
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;


class Employee {
    private String name;
    private int age;
    private String department;
    private double salary;


    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
}


public class EmployeeSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the source file path - ");
        String sourcePath = sc.nextLine();
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(sourcePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {

                String data[] = line.split(",");
                String name = data[0].trim();
                int age = Integer.parseInt(data[1].trim());
                String dept = data[2].trim();
                int sal = Integer.parseInt(data[3].trim());
                employees.add(new Employee(name, age, dept, sal));
            }

            Map<String, Double> avgSalaryByDept = employees.stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment,
                            Collectors.averagingDouble(Employee::getSalary)));
            Set<String> keys = avgSalaryByDept.keySet();
            System.out.println("\nDepartment\tAverage Salary\n");
            for (String key : keys) {
                System.out.println(key + "  -  " + avgSalaryByDept.get(key));
                System.out.println();
            }
            Employee youngest = employees.stream()
                    .min(Comparator.comparingInt(Employee::getAge))
                    .orElse(null);
            Employee oldest = employees.stream()
                    .max(Comparator.comparingInt(Employee::getAge))
                    .orElse(null);

            System.out.println("Youngest Employee: " + (youngest != null ? youngest.getName() : "N/A"));
            System.out.println("Oldest Employee: " + (oldest != null ? oldest.getName() : "N/A"));

            int topNEarners = 2;
            List<String> topEarners = employees.stream()
                    .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                    .limit(topNEarners)
                    .map(Employee::getName)
                    .collect(Collectors.toList());
            System.out.println("\nTop " + topNEarners + " Earning Employees:");
            topEarners.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("!!! Error occured while reading file !!!");
        } catch (Exception e) {
            System.out.println("Unknown error occured");
        } finally {
            sc.close();
        }
    }
}