package util;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public class DataSourceFactoryProvider  {
    public static DataSourceFactory getFactory (String name){
        DataSourceFactory dsf = null;

        //        switch (name){
//            case "MySQL":
//                return new MySQLDataSourceFactory();
//            default:
//                throw new IllegalArgumentException();
//        }

        if (name.toLowerCase()=="mysql"){
            dsf =  new MySQLDataSourceFactory();
        }
        return dsf;
        }
}
