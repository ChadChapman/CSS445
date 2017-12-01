import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
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
 * InternshipReview information.
 *
 * @author Hui Ting, Keegan, Chad
 * @version 30 November 2017
 *
 */

public class ReviewDB {
    private static String userName = "caih6"; // CHANGE TO YOURS
    private static String password = "huiting"; // CHANGE TO YOURS
    private static String serverName = "cssgate.insttech.washington.edu";
    private static Connection conn;
    private List<InternshipReview> list;
    private List<String> reviewIDList;

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
     * Returns a list of review objects from the database.
     *
     * @return list of reviews
     * @throws SQLException
     */
    public List<InternshipReview> getReview() throws SQLException {
        if (conn == null) {
            createConnection();
        }
        Statement stmt = null;
        String query = "select ReviewID, StudentID, ReviewText " + "from caih6.InternshipReview ";
        list = new ArrayList<InternshipReview>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String studentID = rs.getString("StudentID");
                String reviewID = rs.getString("ReviewID");
                String reviewText = rs.getString("ReviewText");
                InternshipReview review = new InternshipReview(studentID, reviewID, reviewText);
                list.add(review);
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
     * Returns a list of reviewID from the database.
     *
     * @return list of reviewID
     * @throws SQLException
     */
    public List<String> getReviewID() throws SQLException {
        if (conn == null) {
            createConnection();
        }
        Statement stmt = null;
        String query = "select  ReviewID " + "from caih6.InternshipReview ";
        reviewIDList = new ArrayList<String>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String reviewID = rs.getString("ReviewID");
                //Student student = new Student(firstName, lastName, studentID, phoneNumber, major);
                reviewIDList.add(reviewID);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return reviewIDList;
    }


    /**
     * Delete a review from the database
     *
     * @param reviewID
     */
    public void removeReview(String reviewID) {
        boolean hasReview =false;

        // Get the student Id list from database.
        List<String> reviewIDList1 = null;
        try {
            reviewIDList1 = getReviewID();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       // Check the reviewID that is entered by user is in the database or not
        for(String s : reviewIDList1){
            if(s.contains(reviewID)){
                hasReview = true;
            }
        }

        if(!hasReview){
            //Display a message  Deleted Unsuccessfully!
            JOptionPane.showMessageDialog(null, "This review is not in the DataBase");

        } else{
            String sql = "delete from caih6.InternshipReview where ReviewID = ?";
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, reviewID);
                System.out.println(reviewID);
                System.out.println(preparedStatement);
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
            //Display a message  Deleted successfully!
            JOptionPane.showMessageDialog(null, "Deleted Successfully!");
        }

    }




    /**
     * Adds a new internship review to the table.
     * @param review
     */
    public void addReview(InternshipReview review) {
        boolean hasReview = false;

        // Get the review Id list from database.
        List<String> reviewIdList2 = null;
        try {
            reviewIdList2 = getReviewID();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Check the studenID that is entered by user is in the database or not
        for(String reviewId : reviewIdList2){
            if(reviewId.contains(review.getReviewID())){
                hasReview = true;
            }
        }

        if(hasReview){
            //Display a message
            JOptionPane.showMessageDialog(null, "This ReviewID already exists");

        } else{
            String sql = "insert into caih6.InternshipReview (StudentID, ReviewID, ReviewText) values "
                    + "(?, ?, ?); ";

            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, review.getStudentID());
                preparedStatement.setString(2, review.getReviewID());
                preparedStatement.setString(3, review.getReviewText());
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
            // Display a message
            JOptionPane.showMessageDialog(null, "Review Added Successfully!");
        }
    }


    /**
     * Modifies the review information corresponding to the index in the list.
     *
     * @param row
     *            index of the element in the list
     * @param columnName
     *            attribute to modify
     * @param data
     *            value to supply
     */
    public void updateReview(int row, String columnName, Object data) {

        InternshipReview review = list.get(row);
        String reviewID = review.getReviewID();
        String sql = "update caih6.InternshipReview set " + columnName + " = ?  where ReviewID= ? ";
        System.out.println(sql);
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(sql);
            if (data instanceof String)
                preparedStatement.setString(1, (String) data);
            else if (data instanceof Integer)
                preparedStatement.setInt(1, (Integer) data);
            preparedStatement.setString(2, reviewID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }

    }
}
