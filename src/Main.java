import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String data1 = "11.12.2020 14:00";
        String data5 = "28.03.2019 09:00";
        String data2 = "02.04.2019 14:00";
        String data3 = "15.12.1999 14:00";
        String data4 = "05.12.2015 14:00";
        String data6 = "01.03.2019 20:00";
        String data7 = "02.03.2019 23:50";
        String patternOne = "dd.MM.yyyy HH:mm";;
        DateTimeFormatter dtfOne = DateTimeFormatter.ofPattern(patternOne);

        LocalDateTime ldt1 = LocalDateTime.parse(data1,dtfOne);
        LocalDateTime ldt2 = LocalDateTime.parse(data2,dtfOne);
        LocalDateTime ldt3 = LocalDateTime.parse(data3,dtfOne);
        LocalDateTime ldt4 = LocalDateTime.parse(data4,dtfOne);
        LocalDateTime ldt5 = LocalDateTime.parse(data5,dtfOne);
        LocalDateTime ldt6 = LocalDateTime.parse(data6,dtfOne);
        LocalDateTime ldt7 = LocalDateTime.parse(data7,dtfOne);

//        System.out.println(TimeConditions.lessThan24HoursCondition(ldt7));


        List<Excercise> list = new ArrayList<>();

        Excercise ex1 = new Excercise("ple ple ple ",ldt1, false);
        Excercise ex2 = new Excercise("bla bla bla ",ldt2, false);
        Excercise ex3 = new Excercise("meh meh meh ",ldt3, false);
        Excercise ex4 = new Excercise("sia sia sia ",ldt4, false);
        Excercise ex5 = new Excercise("uaa uaa uaa ",ldt5, false);
        Excercise ex6 = new Excercise("uaa uaa uaa ",ldt6, false);
        Excercise ex7 = new Excercise("uaa uaa uaa ",ldt7, false);
        list.add(ex1);
        list.add(ex2);
        list.add(ex3);
        list.add(ex4);
        list.add(ex5);
        list.add(ex6);
        list.add(ex7);

//        long hoursBetween = ChronoUnit.HOURS.between(ldt7,ldt6);
//        System.out.println(hoursBetween);
        Logic logic = new Logic();
        logic.mainMenu(list);

//        System.out.println(logic.showExcercisesToDoIn24Hours(list));
    }
}
