import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class CurrentDate 
{
    // Get the current date
        static LocalDate currentDate = LocalDate.now();

        // Define formatters for day, month, and year
        static DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("d");
        static DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("M");
        static DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yyyy");

        // Format the current date to get day, month, and year
        static String day = currentDate.format(dayFormatter);
        static String month = currentDate.format(monthFormatter);
        static String year = currentDate.format(yearFormatter);

        // Convert from String to integers 
        public static int dayNumber = Integer.parseInt(day);
        public static int monthNumber = Integer.parseInt(month);
        public static int yearNumber = Integer.parseInt(year);
}
