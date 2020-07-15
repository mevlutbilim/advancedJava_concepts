package records_generics_oop;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;

interface  ScrumFactory<B extends ScrumTeam>{
        B create(String name, String jobTitle, double salary);
        }

abstract class  ScrumTeam{
    String Name;
    String JobTitle;
    double Salary;
    public ScrumTeam(String name, String jobTitle, double salary) {
        super();
        Name = name;
        JobTitle = jobTitle;
        Salary = salary;
    }

    public abstract void DailyStandUp();
    public abstract void Demo();

    public void getInfo() {
        System.out.println("Name :"+Name+"\nJopTitle :"+JobTitle+"\nSalary :"+Salary);
        System.out.println("=============================");
    }

}

class Testers extends ScrumTeam {

    public Testers(String name, String jobTitle, double salary) {
        super(name, jobTitle, salary);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void DailyStandUp() {
        System.out.println("Tester "+Name+" is talking");

    }

    @Override
    public void Demo() {
        System.out.println("Tester "+Name+" is demostration ");

    }

    public void FindBug() {
        System.out.println("Tester "+Name+" found Bug");
    }

}

class Developers extends ScrumTeam {

    public Developers(String name, String jobTitle, double salary) {
        super(name, jobTitle, salary);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void DailyStandUp() {
        System.out.println("Developer "+Name+" is talking...");

    }

    @Override
    public void Demo() {
        System.out.println("Developer "+Name+" demostration");

    }

    public void FixBug() {
        System.out.println("Developer "+ Name+" fixed bug");
    }

}

class Scrum{
    public static void main(String[] args)  {
        ScrumFactory<ScrumTeam> tester= Testers::new,
                developer= Developers::new;
        List<ScrumTeam> scrumTeamList=Arrays.asList(
                tester.create("John", "Automation Tester",90000),
                tester.create("Mike", "Manual Tester ", 50000),
                tester.create("Stephone", "SDET Tester", 100000),
                developer.create("Jim", "Full stack Developer", 200000),
                developer.create("Elen", "Developer", 140000)
        );
        System.out.println(maxSalary(scrumTeamList));
        System.out.println(teamStats(scrumTeamList));
    }
   //Maximum salary
    public static OptionalDouble maxSalary(List<ScrumTeam> list){
        return list.parallelStream()
                .mapToDouble(m->  m.Salary)
                .max();
    }
    //team count, max salary, min salary , average salary(Statistics)
    public static DoubleSummaryStatistics teamStats(List<ScrumTeam> list){
        return list.stream()
                .mapToDouble(ts->ts.Salary)
                .collect(DoubleSummaryStatistics::new,
                        DoubleSummaryStatistics::accept,
                        DoubleSummaryStatistics::combine);
    }



}
