/*
 * TCSS 445 - Autumn 2017 Group Project.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;

/**
 * A class that consists of the database operations to insert and update the
 * Movie information.
 * 
 * @author Hui Ting Cai, Keegan J Kell, Chad Chapman, Hanan Abdo; [adapted from mmuppa's Movie Project]
 * @version 02 November 2017
 */

public class StudentDB  {
	private static String userName = "keeganjk"; // CHANGE TO YOURS
	private static String password = "hatFevOu"; // CHANGE TO YOURS
	private static String serverName = "cssgate.insttech.washington.edu";
	private static Connection conn;
	private List<Student> list;
	private List<String> studentIDList;

	/**
	 * Creates a sql connection to MySQL using the properties for userid,
	 * password and server information.
	 * 
	 * @throws SQLException
	 */
	public static void createConnection() throws SQLException {
		Properties connectionProps = new Properties();
		connectionProps.put("user", userName);
		connectionProps.put("password", password);
		conn = DriverManager.getConnection("jdbc:" + "mysql" + "://" + serverName + "/", connectionProps);
		System.out.println("Connected to database");
	}

	/**
	 * Returns a list of student objects from the database.
	 * 
	 * @return list of student
	 * @throws SQLException
	 */
	public List<Student> getStudent() throws SQLException {
		if (conn == null) {
			createConnection();
		}
		Statement stmt = null;
		String query = "SELECT FirstName, LastName, StudentID, PhoneNumber, Major " + "FROM keeganjk.Student ";
		list = new ArrayList<Student>();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String studentID = rs.getString("StudentID");
				String phoneNumber = rs.getString("PhoneNumber");
				String major = rs.getString("Major");
				Student student = new Student(firstName, lastName, studentID, phoneNumber, major);
				list.add(student);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return list;
	}
	
	/**
	 * Returns a list of studentID from the database.
	 * 
	 * @return list of studentID
	 * @throws SQLException
	 */
	public List<String> getStudentID() throws SQLException {
		if (conn == null) {
			createConnection();
		}
		Statement stmt = null;
		String query = "SELECT StudentID " + "FROM keeganjk.Student ";
		studentIDList = new ArrayList<String>();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String studentID = rs.getString("StudentID");
				studentIDList.add(studentID);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return studentIDList;
	}


	/**
	 * Delete a student from the database
	 * 
	 * @param studentID
	 */
	public void removeStudent(String studenID, boolean showMessage) {
		boolean hasStudent =false;
		
		// Get the student Id list from database.
		List<String> studentIdList1 = null;
		try {
			studentIdList1 = getStudentID();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Check the studenID that is entered by user is in the database or not
		for(String s : studentIdList1){
			if(s.contains(studenID)){
				hasStudent = true;
			}
		}
		
		if(!hasStudent){
			//Display a message  Deleted Unsuccessfully!
			JOptionPane.showMessageDialog(null, "This student is not in the DataBase");
			
		} else{
			String sql = "DELETE FROM keeganjk.Student WHERE StudentID = ?";
			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setString(1, studenID);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e);

			} finally {
				if (preparedStatement != null) {
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			if(showMessage){
				//Display a message  Deleted successfully!
				JOptionPane.showMessageDialog(null, "Deleted Successfully!");
			}
		}
	}
	
	/**
	 * Check a student exists in database or not.
	 * 
	 * @param stdtID
	 * @return hasStudent
	 */
	public boolean checkStudent(String stdtID) {
		boolean hasStudent =false;
		
		// Get the student Id list from database.
		List<String> studentIdList1 = null;
		try {
			studentIdList1 = getStudentID();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Check the studenID that is entered by user is in the database or not
		for(String s : studentIdList1){
			if(s.contains(stdtID)){
				hasStudent = true;
			}
		}
		
		if(!hasStudent){
			//Display a message  Unsuccessfully!
			JOptionPane.showMessageDialog(null, "your are not in the DataBase");
			
		} 
		return hasStudent;
	}
	/**
	 *  Returns a student  that match the title provided.
	 * @param studentID
	 * @return a student .
	 */
	public Student getStudent(String studentID) {
		Student student =null;
		// Get the student Id list from database.
		//List<String> studentIdList3 = null;
		
		try {
			list = getStudent();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Student student1 : list) {
			if (student1.getStudentID().contains(studentID)) {
				student = student1;
			}
		}
		return student;
	}
	
	/**
	 * Adds a new student to the table.
	 * @param student
	 */
	public boolean addStudent(Student student, boolean showMessage) {
		boolean hasStudent = false;
		boolean isSuccess = false;
		
		// Get the student Id list from database.
		List<String> studentIdList2 = null;
		try {
			studentIdList2 = getStudentID();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Check the studenID that is entered by user is in the database or not
		for(String studentId : studentIdList2){
			if(studentId.contains(student.getStudentID())){
				hasStudent = true;
			}
		}
		
		if(hasStudent){
			//Display a message
			JOptionPane.showMessageDialog(null, "This StudentID already exist");
			
		} else{
			String sql = "INSDERT INTO keeganjk.Student (FirstName, LastName, StudentID, PhoneNumber, Major) VALUES "
					+ "(?, ?, ?, ?, ?); ";

			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setString(1, student.getFirstName());
				preparedStatement.setString(2, student.getLastName());
				preparedStatement.setString(3, student.getStudentID());
				preparedStatement.setString(4, student.getPhoneNumber());
				preparedStatement.setString(5, student.getMajor());
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e);
				
			} finally{
				if(preparedStatement != null){
					try{
						preparedStatement.close();
					} catch(SQLException e){
						e.printStackTrace();
					}
				}
			}
			isSuccess = true;
			if(showMessage){
				// Display a message
				JOptionPane.showMessageDialog(null, "Added Successfully!");
			}
		}	
		return isSuccess;
	}


	/**
	 * Modifies the student information corresponding to the index in the list.
	 * 
	 * @param row
	 *            index of the element in the list
	 * @param columnName
	 *            attribute to modify
	 * @param data
	 *            value to supply
	 */
	public void updateStudent(int row, String columnName, Object data) {
		Student student = list.get(row);
		String studentID = student.getStudentID();
		String sql = "UPDATE keeganjk.Student SET " + columnName + " = ? WHERE StudentID= ? ";
		System.out.println(sql);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(sql);
			if (data instanceof String)
				preparedStatement.setString(1, (String) data);
			else if (data instanceof Integer)
				preparedStatement.setInt(1, (Integer) data);
			preparedStatement.setString(2, studentID);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}
}
