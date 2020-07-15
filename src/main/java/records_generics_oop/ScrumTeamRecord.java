package records_generics_oop;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record ScrumTeamRecord(String name, String role, double salary) {
}

interface ScrumTeamFactory<T extends ScrumTeamRecord>{
    T create(String name, String role, double salary);
}

class App{
    public static void main(String[] args) {
        ScrumTeamFactory<ScrumTeamRecord>
                developer=ScrumTeamRecord::new,
                tester=ScrumTeamRecord::new;

        List<ScrumTeamRecord> developers= Arrays.asList(
                developer.create("Mevlut Bilim","Backend Developer",300000),
                developer.create("Alee","Frontend Developer",200000),
                developer.create("Mike","Database Developer",230000)
        );
        List<ScrumTeamRecord> testers=Arrays.asList(
                tester.create("Jerin","QA Tester",120000),
                tester.create("Alex","Automation Tester",145000),
                tester.create("Julian","Manual Tester",90000)
        );

        List<ScrumTeamRecord> scrumList= Stream.concat(developers.stream(),testers.stream())
                .collect(Collectors.toList());

        scrumList.stream().forEach(x-> System.out.println(x));



    }
}