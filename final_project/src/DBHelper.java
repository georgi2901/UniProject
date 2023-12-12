import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JComboBox;


public class DBHelper {

	public static Connection conn = null;
	public static MyModel modelA = null;
	public static PreparedStatement stateA = null;
	public static ResultSet resultA = null;
	public static MyModel modelB = null;
	public static PreparedStatement stateB = null;
	public static ResultSet resultB = null;
	public static MyModel modelC = null;
	public static PreparedStatement stateC = null;
	public static ResultSet resultC = null;
	
	static void fillRegionCombo(JComboBox<String> combo) {
		
		conn = getConnection();
		String sql = "select name from region";
		try {
			stateA = conn.prepareStatement(sql);
			resultA = stateA.executeQuery();
			combo.removeAllItems();
			while(resultA.next()) {
				String item = resultA.getObject(1).toString();
				combo.addItem(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	static void fillRegionComboId(JComboBox<String> combo) {
		
			conn = getConnection();
			String sql = "select id from region";
			try {
			stateA = conn.prepareStatement(sql);
			resultA = stateA.executeQuery();
			combo.removeAllItems();
			while(resultA.next()) {
				String item = resultA.getObject(1).toString();
				combo.addItem(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	static void fillSprRegionCombo(JComboBox<String> combo) {
		
		conn = getConnection();
		String sql = "select name from region";
		try {
			stateA = conn.prepareStatement(sql);
			resultA = stateA.executeQuery();
			combo.removeAllItems();
			while(resultA.next()) {
				String item = resultA.getObject(1).toString();
				combo.addItem(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	static void fillSprRegionComboId(JComboBox<String> combo) {
		
		conn = getConnection();
		String sql = "select id from region";
		try {
		stateA = conn.prepareStatement(sql);
		resultA = stateA.executeQuery();
		combo.removeAllItems();
		while(resultA.next()) {
			String item = resultA.getObject(1).toString();
			combo.addItem(item);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
}
	
	static void fillPoolCombo(JComboBox<String> combo) {
		
		conn = getConnection();
		String sql = "select name from pool where pool_responsible is null";
		try {
		stateB = conn.prepareStatement(sql);
		resultB = stateB.executeQuery();
		combo.removeAllItems();
		while(resultB.next()) {
			String item = resultB.getObject(1).toString();
			combo.addItem(item);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
}
	
	static void fillPoolACombo(JComboBox<String> combo) {
		
		conn = getConnection();
		String sql = "select name from pool";
		try {
		stateB = conn.prepareStatement(sql);
		resultB = stateB.executeQuery();
		combo.removeAllItems();
		while(resultB.next()) {
			String item = resultB.getObject(1).toString();
			combo.addItem(item);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
}
	
	static void fillPoolComboId(JComboBox<String> combo) {
		
		conn = getConnection();
		String sql = "select id from pool where pool_responsible is null";
		try {
		stateB = conn.prepareStatement(sql);
		resultB = stateB.executeQuery();
		combo.removeAllItems();
		while(resultB.next()) {
			String item = resultB.getObject(1).toString();
			combo.addItem(item);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
}
	
	static void fillPoolAComboId(JComboBox<String> combo) {
		
		conn = getConnection();
		String sql = "select id from pool";
		try {
		stateB = conn.prepareStatement(sql);
		resultB = stateB.executeQuery();
		combo.removeAllItems();
		while(resultB.next()) {
			String item = resultB.getObject(1).toString();
			combo.addItem(item);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
}
	
	static void fillSprPoolCombo(JComboBox<String> combo) {
		
			conn = getConnection();
			String sql = "select name from pool";
			try {
				stateB = conn.prepareStatement(sql);
				resultB = stateB.executeQuery();
				combo.removeAllItems();
				while(resultB.next()) {
					String item = resultB.getObject(1).toString();
					combo.addItem(item);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
}
	
	static void fillSprPoolComboId(JComboBox<String> combo) {
		
		conn = getConnection();
		String sql = "select id from pool";
		try {
		stateB = conn.prepareStatement(sql);
		resultB = stateB.executeQuery();
		combo.removeAllItems();
		while(resultB.next()) {
			String item = resultB.getObject(1).toString();
			combo.addItem(item);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
}
	
	static void fillResponsibleCombo(JComboBox<String> combo) {
		
		conn = getConnection();
		String sql = "select name from pool";
		try {
			stateC = conn.prepareStatement(sql);
			resultC = stateC.executeQuery();
			combo.removeAllItems();
			while(resultC.next()) {
				String item = resultC.getObject(1).toString();
				combo.addItem(item);
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} 
	
	}

	static void fillResponsibleComboId(JComboBox<String> combo) {
	
		conn = getConnection();
		String sql = "select id from pool";
		try {
			stateC = conn.prepareStatement(sql);
			resultC = stateC.executeQuery();
			combo.removeAllItems();
			while(resultC.next()) {
				String item = resultC.getObject(1).toString();
				combo.addItem(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		} 

	}
	
	static void fillSearchResponsible(JComboBox<String> combo) {
		
		conn = getConnection();
		String sql = "select fname from responsible";
		try {
			stateC = conn.prepareStatement(sql);
			resultC = stateC.executeQuery();
			combo.removeAllItems();
			while(resultC.next()) {
				String item = resultC.getObject(1).toString();
				combo.addItem(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		} 

	}
	
	static void fillSearchIdResponsible(JComboBox<String> combo) {
		
		conn = getConnection();
		String sql = "select id from responsible";
		try {
			stateC = conn.prepareStatement(sql);
			resultC = stateC.executeQuery();
			combo.removeAllItems();
			while(resultC.next()) {
				String item = resultC.getObject(1).toString();
				combo.addItem(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		} 

	}
	
	public static Connection getConnection() {
		
		String dbName = "";
		String username = "";
		String password = "";
		
		try {
		      File myObj = new File("src\\project.txt");
		      Scanner myReader = new Scanner(myObj);
		        String data = myReader.nextLine();
		        String[] content = data.split(" ");
		        dbName = content[0];
		        username = content[1];
		        password = content[2];
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:D:\\\\Java-workspace\\\\"+dbName+";AUTO_SERVER=TRUE", username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}//end method
	
    public static MyModel getAllDataRegion() {
		
		conn = getConnection();
		try {
			stateA = conn.prepareStatement("SELECT * FROM REGION");
			resultA = stateA.executeQuery();
			modelA = new MyModel(resultA);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelA;
	}
    
    
    public static MyModel getAllDataPool() {
		
		conn = getConnection();
		try {
			stateB = conn.prepareStatement("SELECT pool.ID, POOL.NAME, pool.AREA, DEPTH, REGION.NAME, responsible.fname FROM POOL join region on pool.region_name_id = region.id left join responsible on pool_responsible = responsible.id");
			resultB = stateB.executeQuery();
			modelB = new MyModel(resultB);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelB;
	}
    
    
    public static MyModel getAllDataResponsible() {
		
		conn = getConnection();
		try {
			stateC = conn.prepareStatement("SELECT responsible.id, fname, lname, age, text, name from RESPONSIBLE left join pool on responsible_pool = pool.id ");
			resultC = stateC.executeQuery();
			modelC= new MyModel(resultC);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelC;
	}
	
}//end class
