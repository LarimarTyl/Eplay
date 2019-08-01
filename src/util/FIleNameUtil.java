package util;

/**
 * @author Larimar
 * @time 2019/8/2 周五 2:10
 */
public class FIleNameUtil {
    public static String getFileName(String heard) {
        String[] split = heard.split(";");
        String[] split1 = split[2].split("=");
        String s = split1[1].replaceAll("\"", "");
        return s;
    }
}
