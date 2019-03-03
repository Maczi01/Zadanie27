import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

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
        if(yearsBetween<=0 && Math.abs(daysBetween)<7 && futureCondition(dOne)){
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

    static boolean currentWeekCondition(LocalDate dOne) {


        LocalDate today = LocalDate.now();
        LocalDate sunday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
            if ((dOne.isAfter(today) || dOne.isEqual(today))
                &&
        (dOne.isBefore(sunday) || dOne.isEqual(sunday))) {
            return true;
        }
        else
            return true;

        }


//
//        LocalDateTime sunday = dTwo;
//        while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY) {
//            sunday = sunday.plusDays(1);
//        }
//        long toSunday = ChronoUnit.DAYS.between(sunday,dTwo);
//        if(toSunday <7 ){
//            return true;
//        }
//        else

    }
