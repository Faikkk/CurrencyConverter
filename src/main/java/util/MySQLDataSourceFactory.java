package util;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class MySQLDataSourceFactory implements DataSourceFactory {
    @Override
    public DataSource getDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();

        // enclose the reading from file into the try-catch block
        // so that the stream is automatically closed

        try{
            // load the properties from the specified file
            // create a new instance of MySQLDataSource class
            dataSource.setURL("jdbc:mysql://localhost:3306/my_db");
            dataSource.setUser("root");
            dataSource.setPassword("ghy672v1");
        }

        // handle later
        catch (Exception e){
            System.out.println("Failed to get MySQL connection or access the file" + e);
        }
    return dataSource;
    }
}
