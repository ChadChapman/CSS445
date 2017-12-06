/*
 * TCSS 445A - Autumn 2017 - Group A
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * Creates panel for moderator.
 *
 * @author Hui Ting Cai, Keegan J Kell, Chad Chapman, Hanan Abdo; [adapted from mmuppa's Movie Project]
 * @version 02 November 2017
 */
public class ModeratorGUI extends JPanel implements ActionListener, TableModelListener {
	
	/** A generated serial version UID for object Serialization.*/
	private static final long serialVersionUID = -2827451653287095287L;

    /** Attribute names for the student. */
    private static final String[] columnNames = {"FirstName", "LastName", "StudentID", "Phone#", "Major"};

	/** Buttons to list, delete, and add students. */
	private JButton btnList, btnDelete, btnAdd;

	/** Panels for organization of outer panel. */
	private JPanel pnlButtons, pnlContent;

	/** Database to retrieve and update student information. */
	private StudentDB db;

	/** Storage for database student query. */
	private List<Student> list;

	/** Storage for student attribute data. */
	private Object[][] data;

	/** Container for student attribute data. */
	private JTable table;

	/** Pane surrounding the student data table. */
	private JScrollPane scrollPane;

	/** Main content panel for delete tab. */
	private JPanel pnlDelete;

	/** Label stating what to enter in order to delete. */
	private JLabel lblTitle;

	/** Field for identifying the student to delete. */
	private JTextField txfTitle;

	/** Button to delete a student. */
	private JButton btnTitleDelete;

	/** Container for adding data for a student. */
	private JPanel pnlAdd;

    /** Labels for student information data. */
	private JLabel[] txfLabel = new JLabel[5];

    /** Editable fields for student information data. */
	private JTextField[] txfField = new JTextField[5];

	/** Button to add a student to the database. */
	private JButton btnAddStudent;
	
	/**
	 * Creates JPanel and sets basic moderator GUI structure with retrieved student data.
	 */
	public ModeratorGUI(){
		db = new StudentDB();
		try {
			list = db.getStudent();
			data = new Object[list.size()][columnNames.length];
			for (int i=0; i<list.size(); i++) {
				data[i][0] = list.get(i).getFirstName();
				data[i][1] = list.get(i).getLastName();
				data[i][2] = list.get(i).getStudentID();
				data[i][3] = list.get(i).getPhoneNumber();
				data[i][4] = list.get(i).getMajor();	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        layoutComponents();
		setVisible(true);
		setSize(500, 500);
	}

	/**
	 * Positions the various moderator GUI components.
	 */
	private void layoutComponents() {
		pnlButtons = new JPanel();
		
		btnList = new JButton("Student List");
		btnList.addActionListener(this);

		btnDelete = new JButton("    Delete    ");
		btnDelete.addActionListener(this);

		btnAdd = new JButton("Add Student");
		btnAdd.addActionListener(this);

		pnlButtons.add(btnList);
		pnlButtons.add(btnDelete);
		pnlButtons.add(btnAdd);
		add(pnlButtons, BorderLayout.NORTH);

		// List tab
		pnlContent = new JPanel();
		table = new JTable(data, columnNames);
		scrollPane = new JScrollPane(table);
		pnlContent.add(scrollPane);
		table.getModel().addTableModelListener(this);

		// Delete tab
		pnlDelete = new JPanel();
		lblTitle = new JLabel("Enter StudentID: ");
		txfTitle = new JTextField(15);
		btnTitleDelete = new JButton("Delete");
		btnTitleDelete.addActionListener(this);
		pnlDelete.add(lblTitle);
		pnlDelete.add(txfTitle);
		pnlDelete.add(btnTitleDelete);

		// Add tab
		pnlAdd = new JPanel();
		pnlAdd.setLayout(new GridLayout(6, 0));
		for (int i = 0; i < columnNames.length; i++) {
			JPanel panel = new JPanel();
			txfLabel[i] = new JLabel(columnNames[i] + ": ");
			txfLabel[i].setPreferredSize(new Dimension(100, 20));
			txfField[i] = new JTextField(25);
			panel.add(txfLabel[i]);
			panel.add(txfField[i]);
			pnlAdd.add(panel);
		}
		JPanel panel = new JPanel();
		btnAddStudent = new JButton("Add");
		btnAddStudent.addActionListener(this);
		panel.add(btnAddStudent);
		pnlAdd.add(panel);

		add(pnlContent, BorderLayout.CENTER);
	}

    /**
     * Initiates appropriate actions corresponding with various button presses.
     * @param e button press event
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnList) {
			try {
				list = db.getStudent();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			data = new Object[list.size()][columnNames.length];
			for (int i = 0; i < list.size(); i++) {
				data[i][0] = list.get(i).getFirstName();
				data[i][1] = list.get(i).getLastName();
				data[i][2] = list.get(i).getStudentID();
				data[i][3] = list.get(i).getPhoneNumber();
				data[i][4] = list.get(i).getMajor();
			}
			pnlContent.removeAll();
			table = new JTable(data, columnNames);
			table.getModel().addTableModelListener(this);
			scrollPane = new JScrollPane(table);
			pnlContent.add(scrollPane);
			pnlContent.revalidate();
			this.repaint();

		} else if (e.getSource() == btnDelete) {
			pnlContent.removeAll();
			pnlContent.add(pnlDelete);
			pnlContent.revalidate();
			this.repaint();

		} else if (e.getSource() == btnAdd) {
			pnlContent.removeAll();
			pnlContent.add(pnlAdd);
			pnlContent.revalidate();
			this.repaint();

		} else if (e.getSource() == btnTitleDelete) {
			
			// Get the text from the text file.
			String studentId = txfTitle.getText();
			
			// If the text file is 7 digital.
			if (studentId.length() == 7) {
				 // remover this student form DB
				db.removeStudent(studentId, true);
				txfTitle.setText("");
			}else {
				// If the text file is not 7 digital, then show a message.
				JOptionPane.showMessageDialog(null, "StudentID is 7 digital");
			}
			
		} else if (e.getSource() == btnAddStudent) {
			String studentID = txfField[2].getText();
			if(studentID.length() == 7){
				Student student = new Student(txfField[0].getText(), txfField[1].getText(),studentID,
						txfField[3].getText(), txfField[4].getText());
				db.addStudent(student, true);
				
				for (int i=0; i<txfField.length; i++) {
					txfField[i].setText("");
				}
			}else {
				JOptionPane.showMessageDialog(null, "StudentID is 7 digital");
			}

		}
	}

    /**
     * Monitors the table for any change in data, updates database as required.
     * @param e table change event
     */
	@Override
	public void tableChanged(TableModelEvent e) {
		int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel)e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);
        
        db.updateStudent(row, columnName, data);
		
	}

}
