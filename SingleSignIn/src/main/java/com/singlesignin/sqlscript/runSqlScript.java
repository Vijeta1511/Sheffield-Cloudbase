package com.singlesignin.sqlscript;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.ibatis.common.jdbc.ScriptRunner;

/*
 * Run database scripts using a tool called ScriptRunner
 */

public class runSqlScript {
		
	public void run(String scriptPath) throws IOException, SQLException {
		
		Reader reader = null;
		Connection connection = null;
		
		try {
			
			// load driver class for mysql
			Class.forName("com.mysql.jdbc.Driver");
			// create connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", 
	                            "root", "sqlpass1");
			
			// create ScripRunner object
			ScriptRunner scriptExe = new ScriptRunner(connection, false, false); //public ScriptRunner(java.sql.Connection connection,boolean autoCommit,boolean stopOnError)
			
			// initialize file reader
			reader = new BufferedReader(new FileReader(scriptPath)); // reads the file provided from the path - scriptPath	
			
			scriptExe.runScript(reader); // Runs an SQL script (read in using the Reader parameter)
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close file reader
			if (reader != null) {
				reader.close();
			}
			// close database connection
			if (connection != null) {
				connection.close();
			}
		}
	}
}
