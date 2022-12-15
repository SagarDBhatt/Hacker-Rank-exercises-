package Java8Features.AnonymousClass_LambdaExpressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingOfCollectionUsingLambda {
    public static void main(String[] args) {

        List<EmployeeCollection> employeeCollectionList = Arrays.asList(
                new EmployeeCollection("Sam",1000),
                new EmployeeCollection("Anj", 2000),
                new EmployeeCollection("Brij", 3000),
                new EmployeeCollection("Carry", 500)
        );

        //METHOD 1: USING COLLECTIONS API && COMPARATOR INTERFACE
        Comparator<EmployeeCollection> comparatorEmp = new Comparator<EmployeeCollection>() {
            @Override
            public int compare(EmployeeCollection e1, EmployeeCollection e2) {
                return e1.getEmpName().compareTo(e2.getEmpName());
            }
        };

        Collections.sort(employeeCollectionList, comparatorEmp);

        System.out.println("Sorted Collection by Method 1!!!!");
        System.out.println(employeeCollectionList);

        //METHOD 2: USING LAMBDA FUNCTION
        Comparator<EmployeeCollection> comparator = (EmployeeCollection e1, EmployeeCollection e2) -> {
            return e1.getEmpSalary() - e2.getEmpSalary();
        };

        Collections.sort(employeeCollectionList, comparator);


        System.out.println("Sorted Collection by method 2!!!!");
        System.out.println(employeeCollectionList);
    }
}

class EmployeeCollection{
    private String empName;
    private int empSalary;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(int empSalary) {
        this.empSalary = empSalary;
    }

    public EmployeeCollection(String empName, int empSalary) {
        this.empName = empName;
        this.empSalary = empSalary;
    }

    @Override
    public String toString() {
        return "EmployeeCollection{" +
                "empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                '}';
    }

}//EOF CLASS