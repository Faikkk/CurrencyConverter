package util;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLDataSource implements DataSourceFactory {
    @Override
    public DataSource getDataSource() {
        Properties props = new Properties();
        MysqlDataSource dataSource = new MysqlDataSource();

        // enclose the reading from file into the try-catch block
        // so that the stream is automatically closed

        try (FileInputStream fis = new FileInputStream("db.properties");){
            // load the properties from the specified file
            props.load(fis);

            // create a new instance of MySQLDataSource class

            dataSource.setURL(props.getProperty("mysql.url"));
            dataSource.setUser(props.getProperty("mysql.username"));
            dataSource.setPassword(props.getProperty("mysql.password"));
        }

        // handle later
        catch (Exception e){
            System.out.println("Failed to get MySQL connection or access the file" + e);
        }
    return dataSource;
    }
}
