package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateUtils {

    public static String getDate(String dataFormat) {
        Date date = new Date();
        DateFormat dateformat = new SimpleDateFormat(dataFormat);
        return dateformat.format(date);
    }

    public static String getBackDated(int backDays, String dateFormat) {
        LocalDate actualDate = LocalDate.now();
        LocalDate dateDaysBefore = actualDate.minusDays(backDays);

        if (dateDaysBefore.getDayOfWeek() != DayOfWeek.SATURDAY && dateDaysBefore.getDayOfWeek() != DayOfWeek.SUNDAY) {
            return dateDaysBefore.format(DateTimeFormatter.ofPattern(dateFormat));
        }

        LocalDate ultimoDiaUtil = dateDaysBefore.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        return ultimoDiaUtil.format(DateTimeFormatter.ofPattern(dateFormat));
    }

    public static String getTimeStamp() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("_ddMMyy_HHmmss");
        return dateFormat.format(date);
    }

}
