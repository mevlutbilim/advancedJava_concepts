package records_generics_oop;

import java.util.Arrays;
import java.util.List;

//java record
public record Employees<T>(T contents,String city,String state) {}

//enum
enum Role{ SCRUM_MUSTER,DEVELOPER,TESTER;}

interface EmployeeFactory<E extends Employee>{
    E create(String name, int experince, Role role);
}

class Employee{
   String name;
   int exp;
    Role role;
   public Employee(String name, int exp, Role role){
       this.name=name;
       this.exp=exp;
       this.role=role;
   }
public double calculateSalary(Role role){
    double salary=switch (role){
        case TESTER ->60000+this.exp*5000;
        case DEVELOPER ->75000+exp*7000;
        case SCRUM_MUSTER -> 65000+exp*5500;
        default -> throw new NullPointerException();

    };
 return salary;
}
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                "Role : "+role+
                ", experience=" +exp +" years"+" Salary :"+calculateSalary(role)+

                '}';
    }
}


class EmployeeApp {
    public static void main(String[] args) throws NullPointerException{
       EmployeeFactory<Employee> employee= Employee::new;


        List<Employees<Employee>> employeesList=Arrays.asList(
                new Employees<>(employee.create("Mike",6, Role.SCRUM_MUSTER),"Seattle","WA"),
                new  Employees<>(employee.create("John",7, Role.TESTER),"Bellevue","WA"),
                new Employees<>(employee.create("Suad",3, Role.DEVELOPER),"Tacoma","WA"));

        employeesList.stream().forEach(System.out::println);

    }
}