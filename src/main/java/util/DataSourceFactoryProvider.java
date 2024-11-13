package util;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public class DataSourceFactoryProvider {
    public static DataSource getDBConnection (String name){
        switch (name){
            case "MySQL":
                return new MysqlDataSource();
            default:
                throw new IllegalArgumentException();

        }
        }
}
