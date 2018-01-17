package Data_base;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import Data_Setup.*;
import Data_Setup.Time;
import Memory.Data_Structures;


public class ConnectionMySQL {

	 private static String  ip = "";
	 private static String  user = "";
	 private static String  password = "";
	 private static String  port = "";
	 private static String m_Url = "";
	 

	 public static boolean login(String u, String p, String i, String t ) {
		Connection m_Connection = null;
		
		
		user = u;
		password = p;
		ip = i;
		port = t;
		
		
		
		 m_Url="jdbc:mysql://" + ip + ":"+port+"/oop_course_ariel?useSSL=false";
		
		 try {
			//Create connection object
			 m_Connection = DriverManager.getConnection(m_Url, user, password);
			 System.out.println("TRUE LOGIN");
			 return true;

		 }
		 catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println("FALSE LOGIN");
				return false;

			}finally {
				try {
					
					if (m_Connection != null) {
						m_Connection.close();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		 
	 }

	public static void start() throws IOException, ParseException  {
		
		Connection m_Connection = null;
		Statement m_Statement = null;
		ResultSet m_ResultSet = null;

		String query = "";
		try {
			
			
			m_Connection = DriverManager.getConnection(m_Url, user, password);
			//Create Statement object
			m_Statement = m_Connection.createStatement();
			query = "SELECT * FROM oop_course_ariel.ex4_db";
		
		//Execute the query
		m_ResultSet = m_Statement.executeQuery(query);
		
		
		//Loop through the results
		
		while (m_ResultSet.next()) {
		
			Date date  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(m_ResultSet.getString(2));
			Time time = new Time(date);
			Position position = new Position(m_ResultSet.getString(6),m_ResultSet.getString(5),m_ResultSet.getString(4));
			Record record = new Record(time, position);
			record.setid(new ID(m_ResultSet.getString(3)));
			
			for(int i=8;i<27;i+=2)
			{
				if(m_ResultSet.getString(i)==null)break;

				
				Mac mac=new Mac(m_ResultSet.getString(i)); 
				Signal signal = new Signal(m_ResultSet.getString(i+1));
				SSID sd=new SSID();
				Frequency fr=new Frequency(-1);
				Wifi wifi = new Wifi(sd, mac,fr, signal);
				record.addWifi(wifi);

			}
			record.setWifinetworks(Integer.parseInt(m_ResultSet.getString(7)));
			Memory.Data_Structures.Sql_Data.add(record);
			
		}
		if(Data_Structures.Sql_Data != null) {
		Data_Structures.merged_Data();
		}
	
	}
		catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(query);
		} finally {
			try {
				if (m_ResultSet != null) {
					m_ResultSet.close();
				}
				if (m_Statement != null) {
					m_Statement.close();
				}
				if (m_Connection != null) {
					m_Connection.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

}
