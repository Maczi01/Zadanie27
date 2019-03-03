public class CommunicationWithUser {

    static void showMainMenu() {
        System.out.println("Menu glowne");
        System.out.println("1. Dodanie zadania");
        System.out.println("2. Edycja zadania");
        System.out.println("3. Wyświetl zadania");
        System.out.println("0. Wyjscie z programu");
    }

    static void showExcercisesMenu() {
        System.out.println("1. Wyswietl wszystkie zadania");
        System.out.println("2. Wyswietl przeszle zadania");
        System.out.println("3. Wyswietl przyszle zadania");
        System.out.println("0. Powrot do menu glownego");
    }

    static void showFutureExcercisesMenu() {
        System.out.println("1. Wyswietl wszystkie przyszle zadania");
        System.out.println("2. Wyswietl zadania do wykonania w ciagu 24 godzin");
        System.out.println("3. Wyswietl zadania do wykonania w ciagu 7 dni");
        System.out.println("4. Wyswietl zadania do konca bierzacego tygodnia");
        System.out.println("5. Wyswietl zadania do wykonania w ciagu 30 dni");
        System.out.println("0. Powrot do menu glownego");
    }

    static void confirm() {
        System.out.println("Czy na pewno ?");
        System.out.println("1. Tak");
        System.out.println("2. Nie");
    }

    static void showEditMenu(){
        System.out.println("Co chcesz edytować?");
        System.out.println("1. Tresc");
        System.out.println("2. Data");
        System.out.println("3. Status wykonania");
    }


}
