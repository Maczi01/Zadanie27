import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class TimeConditions {
    static LocalDateTime dTwo = LocalDateTime.now();

    static boolean lessThan24HoursCondition(LocalDateTime dOne) {
        long daysBetween = ChronoUnit.DAYS.between(dOne, dTwo);
        long hoursBetween = ChronoUnit.HOURS.between(dTwo,dOne);
        if (daysBetween<1 && hoursBetween < 24) {
            return true;
        } else
            return false;
    }

    static boolean lessThan7DaysCondition(LocalDateTime dOne) {
        long yearsBetween = ChronoUnit.YEARS.between(dOne,dTwo);
        long daysBetween = ChronoUnit.DAYS.between(dTwo,dOne);
        if(yearsBetween<=0 && daysBetween<7){
            return true;
        }
            return false;

    }

    static boolean lessThan30DaysCondition(LocalDateTime dOne) {
        long daysBetween = ChronoUnit.DAYS.between(dTwo,dOne);
        if(daysBetween<30 && daysBetween >=7){
            return true;
        }
        return false;
    }

    static boolean pastCondition(LocalDateTime dOne) {
        if (dOne.isBefore(dTwo))
            return true;
        else
            return false;
    }

    static boolean futureCondition(LocalDateTime dOne) {
        if (dOne.isAfter(dTwo))
            return true;
        else
            return false;
    }

}
