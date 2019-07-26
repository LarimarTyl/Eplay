package util;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Create by czq
 * time on 2019/7/25  17:00
 */
public class DateUtil {


    public static String convert(LocalDateTime d) {
        String format = d.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return format;
    }
}
