import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Logic {

    Scanner scanner = new Scanner(System.in);
    CommunicationWithUser cwu;
    TimeConditions tc;
    final String EXIT = "0";
    LocalDateTime now = LocalDateTime.now();


    void mainMenu(List<Excercise> list) {
        String choice;
//        List<Excercise> list = createListofExcercises();
        do {
            cwu.showMainMenu();
            System.out.println("Wybierz jedna z opcji");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addExcercise(list);
                    break;
                case "2":
                    editExcercise(list);
                    break;
                case "3":
                    excercisesMenu(list);
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Nieprawidlowy wybor");
            }
        }
        while (!choice.equals(EXIT));

    }

    void excercisesMenu(List<Excercise> listaZadanDoWykonanialista) {
        String choice;
        do {
            cwu.showExcercisesMenu();
            System.out.println("Wybierz jedna z opcji");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    showAllExcercises(listaZadanDoWykonanialista);
                    break;
                case "2":
                    showPastExcercises(listaZadanDoWykonanialista);
                    break;
                case "3":
                    futureExcercisesMenu(listaZadanDoWykonanialista);
                    break;
                case "0":
                    mainMenu(listaZadanDoWykonanialista);
                    break;
                default:
                    System.out.println("Nieprawidlowy wybor");
            }
        }
        while (!choice.equals(EXIT));
    }

    void futureExcercisesMenu(List<Excercise> listaZadanDoWykonania) {
        String choice;
        do {
            cwu.showFutureExcercisesMenu();
            System.out.println("Wybierz jedna z opcji");
            choice  = scanner.nextLine();
            switch (choice) {
                case "1":
                    showAllFutureExcercises(listaZadanDoWykonania);
                    break;
                case "2":
                    showExcercisesToDoIn24Hours(listaZadanDoWykonania);
                    break;
                case "3":
                    showExcercisesToDoIn7Days(listaZadanDoWykonania);
                    break;
                case "4":
                    showExcercisesToDoIn30Days(listaZadanDoWykonania);
                    break;
                default:
                    System.out.println("Nieprawidlowy wybor");
            }
        } while (!choice.equals(EXIT));
    }

    void showAllFutureExcercises(List<Excercise> listaZadanDoWykonania) {
        List<Excercise> futureExcercises = allFutureExcercises(listaZadanDoWykonania);
        int i = 1;
        for (Excercise o : futureExcercises) {
            System.out.print(i + " .");
            System.out.print(o);
            i++;
        }
    }

    List<Excercise> allFutureExcercises (List<Excercise> listaZadanDoWykonania) {
        List<Excercise> futureExcercises = new ArrayList<>();
        for (Excercise ex : listaZadanDoWykonania) {
            if (!tc.futureCondition(ex.getDatawykonania())) {
                futureExcercises.add(ex);
            }
        }
        return futureExcercises;
    }

    List<Excercise> excercisesToDoIn30Days(List<Excercise> listaZadanDoWykonania) {
        List<Excercise> futureExcercises = new ArrayList<>();
        for (Excercise ex : listaZadanDoWykonania) {
            if (tc.lessThan30DaysCondition(ex.getDatawykonania())) {
                futureExcercises.add(ex);
            }
        }
        return futureExcercises;

    }
    void showExcercisesToDoIn30Days(List<Excercise>listaZadanDoWykonania){
        int i= 1;
        List<Excercise> futureExcercises = excercisesToDoIn30Days(listaZadanDoWykonania);
        for (Excercise ex : futureExcercises) {
            System.out.println(i + ". " + ex);
            i++;
        }

    }

   void showExcercisesToDoIn24Hours(List<Excercise> listaZadanDoWykonania) {
        int i = 1;
        List<Excercise> futureExcercises = excercisesToDoIn24Hours(listaZadanDoWykonania);
        for (Excercise ex : futureExcercises) {
            System.out.println(i + ". " + ex);
            i++;
        }
    }

    List<Excercise> excercisesToDoIn24Hours(List<Excercise> listaZadanDoWykonania) {
        List<Excercise> futureExcercises = new ArrayList<>();
        for (Excercise ex : listaZadanDoWykonania) {
            if (tc.lessThan24HoursCondition(ex.getDatawykonania())) {
                futureExcercises.add(ex);
            }
        }
        return futureExcercises;
    }

    List<Excercise> excercisesToDoIn7Days(List<Excercise> listaZadanDoWykonania) {
        List<Excercise> futureExcercises = new ArrayList<>();
        for (Excercise ex : listaZadanDoWykonania) {
            if (tc.lessThan7DaysCondition(ex.getDatawykonania())) {
                futureExcercises.add(ex);
            }
        }
        return futureExcercises;
    }

    void showExcercisesToDoIn7Days(List<Excercise>listaZadanDoWykonania){
        int i= 1;
        List<Excercise> futureExcercises = excercisesToDoIn7Days(listaZadanDoWykonania);
        for (Excercise ex : futureExcercises) {
            System.out.println(i + ". " + ex);
            i++;
        }

    }


    List<Excercise> pastExcercises(List<Excercise> listaZadanDoWykonania) {
        List<Excercise> pastExcercises = new ArrayList<>();
        for (Excercise ex : listaZadanDoWykonania) {
            if (tc.pastCondition(ex.getDatawykonania())) {
                pastExcercises.add(ex);
            }
        }
        return pastExcercises;
    }

    void showPastExcercises(List<Excercise> listaZadanDoWykonania) {
        List<Excercise> pastExcercises = pastExcercises(listaZadanDoWykonania);
        int i = 1;
        for (Excercise o : pastExcercises) {
            System.out.print(i + " .");
            System.out.print(o);
            i++;
        }
        System.out.println("-------");
        excercisesMenu(listaZadanDoWykonania);
    }

    void showAllExcercises(List<Excercise> listaZadanDoWykonania) {
        int i = 1;
        if (listaZadanDoWykonania.size() == 0) {
            System.out.println("List jest pusta");
        } else {
            for (Excercise o : listaZadanDoWykonania) {
                System.out.print(i + " .");
                System.out.print(o);
                i++;
            }
            System.out.println("-------");
        }
            excercisesMenu(listaZadanDoWykonania);
    }

    LocalDateTime addDate(String data) {
        LocalDateTime ldt = null;
        String patternOne = "yyyy-dd-MM HH:mm";
        String patternTwo = "dd.MM.yyyy HH:mm";
        DateTimeFormatter dtfOne = DateTimeFormatter.ofPattern(patternOne);
        DateTimeFormatter dtfTwo = DateTimeFormatter.ofPattern(patternTwo);
        try {
            ldt = LocalDateTime.parse(data, dtfOne);
        } catch (DateTimeParseException eOne) {
            try {
                ldt = LocalDateTime.parse(data, dtfTwo);
            } catch (DateTimeParseException eTwo) {
                System.out.println("Nieprawidlowy format daty");
            }
        }
        return ldt;
    }

    List<Excercise> editExcercise(List<Excercise> listaZadanDoWykonania) {
        String choice;
        do {
            cwu.showEditMenu();
            System.out.println("Wybierz jedna z opcji");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    showAllExcercises(listaZadanDoWykonania);
                    break;
                case "0":
                    mainMenu(listaZadanDoWykonania);
                    break;
                default:
                    System.out.println("Nieprawidlowy wybor");
            }
        }
        while (!choice.equals(EXIT));
        System.out.println();
        return listaZadanDoWykonania;
    }

    String chooseOne() {
        String number = scanner.nextLine();
        return number;
    }


    List<Excercise> addExcercise(List<Excercise> listaZadanDoWykonania) {
        Excercise ex = new Excercise();
        System.out.println("Podaj tresc zadania");
        String tresc = scanner.nextLine();
        System.out.println("Podaj date wykonania zadania");
        String data = scanner.nextLine();
        ex.setTrescZadania(tresc);
        ex.setDatawykonania(addDate(data));
        listaZadanDoWykonania.add(ex);
        System.out.println("Dodano zadanie");
        return listaZadanDoWykonania;
    }


}
