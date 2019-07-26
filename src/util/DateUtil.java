package util;



import java.time.LocalDateTime;
import java.time.ZoneOffset;
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

    /**
     *
     * @param
     * @param time 单位为小时
     * @return
     */
    public static String convert(LocalDateTime start,long time) {
         long timeTotal=start.toInstant(ZoneOffset.of("+8")).toEpochMilli()+time*3600000;
        LocalDateTime end =LocalDateTime.ofEpochSecond(timeTotal/1000,0,ZoneOffset.ofHours(8));
        String format = end.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return format;
    }

    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.now();
        String convert = convert(start, 2);
        System.out.println(convert);
    }
}
