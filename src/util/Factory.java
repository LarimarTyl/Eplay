package util;

import java.util.ResourceBundle;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 14:51
 */
public class Factory {
    private static ResourceBundle bundle;

    static {
        bundle = ResourceBundle.getBundle("instance");
    }

    public static <T> T getInstance(String key, Class<T> classType) {
        String className = bundle.getString(key);
        try {
            return (T) Class.forName(className).newInstance();
        } catch (ClassNotFoundException e) {

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
