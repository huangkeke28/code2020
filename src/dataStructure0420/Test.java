package dataStructure0420;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
public class Test {
    //员工的重要性
    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            if (employee.id == id) {
                if (employee.subordinates.size() == 0) {
                    return employee.importance;
                }
                for (int x : employee.subordinates) {
                    employee.importance += getImportance(employees, x);
                }
                return employee.importance;
            }
        }
        return 0;
    }
}
