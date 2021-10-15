package co.jeonguk.prj.hash;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSources {
	private static DataSources dataSources;
	private Connection conn;
	private String driver;
	private String url;
	private String user;
	private String password;

	private DataSources() {
		GetProPerty();
	}

	public static DataSources getInstance() {
		dataSources = new DataSources();
		return dataSources;
	}

	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	private void GetProPerty() {
		String resource = "db.properties";
		Properties properties = new Properties();
		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resource);
			properties.load(inputStream);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
