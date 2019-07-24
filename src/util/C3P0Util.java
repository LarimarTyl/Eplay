package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 14:44
 */
public class C3P0Util {
    public static DataSource ds = new ComboPooledDataSource();

    public static void main(String[] args) {
        System.out.println(getCoon());
    }

    public static Connection getCoon() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DataSource getDs() {
        return ds;
        
        
    }

    public static void clossAll(ResultSet rs, PreparedStatement ps, Connection coon) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ps = null;
        }
        if (coon != null) {
            try {
                coon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            coon = null;
        }
    }
}
