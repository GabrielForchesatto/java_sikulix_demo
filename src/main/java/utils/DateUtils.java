package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String getTimeStamp() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("_ddMMyy_HHmmss");
        return dateFormat.format(date);
    }

}
