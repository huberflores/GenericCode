package fi.ubicomp.sqlite.explorer;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author Huber Flores
 *
 */

public class Finder {
	
	
	private static String directory = "/home/huber/Desktop/source_code/db/final/sqlite-files/day10/";
	
		
	public List<File> readFolder(File folder){
		List<File> files = new ArrayList<File>();
		
		for(File fileEntry : folder.listFiles()){
			files.add(fileEntry);
		}
		
		return files;
	}
	
	
	public String loadDatabase(String dataBasePath){
		String sDriver = "org.sqlite.JDBC";
        String Database = "NyDatabase.sqlite";
        String sJdbc = "jdbc:sqlite";
        String sDbUrl = sJdbc + ":" + dataBasePath;
         
        Connection conn = null;
        Statement stmt = null;
        String id = null;
        
        try{        Class.forName(sDriver);

        conn = DriverManager.getConnection(sDbUrl);
        Statement st = conn.createStatement();

        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT distinct myaddress FROM surrogate where bluetooth = 1" );
        
        while (rs.next()) {
           id = rs.getString("myaddress");
            
        }
        conn.close();

        }
        catch (SQLException e) {
        	e.printStackTrace();
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        
        return id;
	}
	
	
	public void exploreDatabaseFiles(){
		List<File> files = readFolder(new File(directory));
		String [] cases = {"48:59:29:06:D0:32","94:D8:59:5C:B6:2A", "9C:02:98:11:87:A9", "40:40:A7:10:C8:1D",
							"9C:D9:17:6A:2C:3D", "38:0A:94:A3:EA:7B", "1C:66:AA:29:77:D0", "14:30:C6:AE:4A:1E"};
		
		
		
		for (File db: files){
			int flag = cases.length;
			String id = loadDatabase(db.getAbsolutePath());
			
			for (int i = 0; i<cases.length; i++){
				if (id.trim().equals(cases[i].trim())){
					flag--;
				}
			}
			
			
			if (flag == cases.length){
				System.out.println("found a new device: " + id + ", " + db.getAbsolutePath());
			}/*else{
				System.out.println("No device found");
			}*/
			
		}
		
		
		System.out.println("Done!");
	}
	

	
	public static void main(String args[]){
		
		Finder f = new Finder();
		f.exploreDatabaseFiles();
		
	}

}
