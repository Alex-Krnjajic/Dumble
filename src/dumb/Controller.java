package dumb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	ResultSet rs3 = null;
	String rs1String = null;
	String rs2String = null;
	String rs3String = null;
	public PrintWriter out;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		out = response.getWriter();

		String input = request.getParameter("input");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3308/foundation?useLegacyDatetimeCode=false&serverTimezone=Europe/Stockholm",
					"root", "");

			dbQuery(input);
			dbQuery("%" + input + "%");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void dbQuery(String input) {

		try {

			String Query1 = "SELECT * FROM `bearbase` WHERE `Character` LIKE ? OR `Origin` LIKE ? OR `Creator` LIKE ? OR `Notes` LIKE ?;";
			String Query2 = "SELECT * FROM `ikea_names` WHERE `name` LIKE ? OR `description` LIKE ? OR `extra_info` LIKE ?;";
			String Query3 = "SELECT * FROM `scp_list` WHERE `scp` LIKE ? OR `Title` LIKE ? OR `rating` LIKE ? OR `Classification` LIKE ? OR `Type` LIKE ? OR `Related_GOI_s` LIKE ? OR `Location_Notes` LIKE ? OR `Author` LIKE ? OR `Leaked_info` LIKE ? OR `Humanoid_or_Structure` LIKE ? OR `Animal_Computer_or_Extradimensional` LIKE ? OR `Autonomous_or_Cognitohazard` LIKE ? OR `Artifact_Location_or_Sentient` LIKE ? OR `Summary` LIKE ? OR `Gender` LIKE ? OR `Ethnicity_Origins` LIKE ?;";

			PreparedStatement pstmt1 = con.prepareStatement(Query1);
			PreparedStatement pstmt2 = con.prepareStatement(Query2);
			PreparedStatement pstmt3 = con.prepareStatement(Query3);

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
				System.out.println(rs1String);
				out.println(rs1String);

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
				System.out.println(rs2String);
				out.println(rs2String);

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
				System.out.println(rs3String);
				out.println(rs3String);

			}
			out.println("</ol>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
