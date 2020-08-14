package fr.ibformation.parkingvinci.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Logger;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DataSourceFactory {

 
	private static final Logger LOGGER = Logger.getLogger(DataSourceFactory.class.getName());

	public DataSourceFactory() {
 		MysqlDataSource mysqlDataSrouce = new MysqlDataSource();
		String rootPath = Objects
				.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("database.properties"))
				.getPath();
		InputStream inputStream = null;

		try {
			inputStream = new FileInputStream(rootPath);
			Properties prop = new Properties();
			try {
				prop.load(inputStream);
				mysqlDataSrouce.setDatabaseName(prop.getProperty("database"));
				mysqlDataSrouce.setUser(prop.getProperty("user"));
				mysqlDataSrouce.setPassword(prop.getProperty("password"));
				mysqlDataSrouce.setServerName(prop.getProperty("serverName"));
				mysqlDataSrouce.setPort(Integer.parseInt(prop.getProperty("port")));
				//mysqlDataSrouce.setURL(prop.getProperty("URL"));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return SingletonHelper.INSTENCE.daso.getConnection();
	}
	
	
	private static class SingletonHelper{
		private static final DataSourceFactory INSTENCE = new DataSourceFactory();
	}

}
