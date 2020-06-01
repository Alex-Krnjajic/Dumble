package dumb;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Bean {
	
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	ResultSet rs3 = null;
	String rs1String = null;
	String rs2String = null;
	String rs3String = null;
	public ArrayList<String> outputList = new ArrayList<String>();
	public Connection con;
	public boolean started = false;
	
	
public void dbQuery(String input) {
	
	PrintWriter out = Controller.out;
	try {
		if (!started) {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3308/foundation?useLegacyDatetimeCode=false&serverTimezone=Europe/Stockholm",
					"root", "");
			started = true;
		}
			
		if (con.isClosed()) {
			con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3308/foundation?useLegacyDatetimeCode=false&serverTimezone=Europe/Stockholm",
						"root", "");
		}
		
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		System.out.println(e1);
		e1.printStackTrace();
	}

	try {

		String Query1 = "SELECT * FROM `bearbase` WHERE `Character` LIKE ? OR `Origin` LIKE ? OR `Creator` LIKE ? OR `Notes` LIKE ?;";
		String Query2 = "SELECT * FROM `ikea_names` WHERE `name` LIKE ? OR `description` LIKE ? OR `extra_info` LIKE ?;";
		String Query3 = "SELECT * FROM `scp_list` WHERE `scp` LIKE ? OR `Title` LIKE ? OR `rating` LIKE ? OR `Classification` LIKE ? OR `Type` LIKE ? OR `Related_GOI_s` LIKE ? OR `Location_Notes` LIKE ? OR `Author` LIKE ? OR `Leaked_info` LIKE ? OR `Humanoid_or_Structure` LIKE ? OR `Animal_Computer_or_Extradimensional` LIKE ? OR `Autonomous_or_Cognitohazard` LIKE ? OR `Artifact_Location_or_Sentient` LIKE ? OR `Summary` LIKE ? OR `Gender` LIKE ? OR `Ethnicity_Origins` LIKE ?;";

		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		try {
			pstmt1 = con.prepareStatement(Query1);
			pstmt2 = con.prepareStatement(Query2);
			pstmt3 = con.prepareStatement(Query3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		pstmt1.setString(1, input);
		pstmt1.setString(2, input);
		pstmt1.setString(3, input);
		pstmt1.setString(4, input);

		pstmt2.setString(1, input);
		pstmt2.setString(2, input);
		pstmt2.setString(3, input);

		pstmt3.setString(1, input);
		pstmt3.setString(2, input);
		pstmt3.setString(3, input);
		pstmt3.setString(4, input);
		pstmt3.setString(5, input);
		pstmt3.setString(6, input);
		pstmt3.setString(7, input);
		pstmt3.setString(8, input);
		pstmt3.setString(9, input);
		pstmt3.setString(10, input);
		pstmt3.setString(11, input);
		pstmt3.setString(12, input);
		pstmt3.setString(13, input);
		pstmt3.setString(14, input);
		pstmt3.setString(15, input);
		pstmt3.setString(16, input);

		rs1 = pstmt1.executeQuery();
		rs2 = pstmt2.executeQuery();
		rs3 = pstmt3.executeQuery();
		out.println("<ol>");
		while (rs1.next()) {
			rs1String = "<li>";
			for (int i = 1; i < 5; i++) {
				if(rs1.getString(i) != null) {
		    rs1String = rs1String.concat(rs1.getString(i)+", ");
				}
			}
			rs1String = rs1String.concat("</li><br>");
			if (!outputList.contains(rs1String)) {
				outputList.add(rs1String);
			}
			
			System.out.println(rs1String);
			//out.println(rs1String);

		}
		out.println("</ol>");
		out.println("<ol>");
		while (rs2.next()) {
			rs2String = "<li>";
			for (int i = 1; i < 4; i++) {
				if(rs2.getString(i) != null) {
		    rs2String = rs2String.concat(rs2.getString(i)+", ");
				}
			}
			rs2String = rs2String.concat("</li><br>");
			if (!outputList.contains(rs2String)) {
				outputList.add(rs2String);
			}
			System.out.println(rs2String);
			//out.println(rs2String);

		}
		out.println("</ol>");
		out.println("<ol>");
		while (rs3.next()) {
			rs3String = "<li>";
			for (int i = 1; i < 17; i++) {
				if(rs3.getString(i) != null) {
		    rs3String = rs3String.concat(rs3.getString(i)+", ");
				}
			}
			rs3String = rs3String.concat("</li><br>");
			if (!outputList.contains(rs3String)) {
				outputList.add(rs3String);
			}
			System.out.println(rs3String);
			//out.println(rs3String);

		}
		out.println("</ol>");

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}

