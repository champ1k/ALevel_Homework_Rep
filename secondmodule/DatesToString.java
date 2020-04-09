import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DatesToString {
    private static List<String> processDates(List<String> dates) {
        List<String> matchers = dates.stream()
                .filter(DatesToString::isValidDate)
                .collect(Collectors.toList());
        return matchers.stream()
                .map(date -> {
                            String result = date.replaceAll("/", "");
                            return result.replaceAll("-", "");
                        }
                ).collect(Collectors.toList());
    }
    private static boolean isValidDate(String date) {
        return Stream.of("dd/MM/yyyy", "yyyy/MM/dd", "MM-dd-yyyy").anyMatch(s -> checkDateFormat(date, s));
    }

    private static boolean checkDateFormat(String date, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}

