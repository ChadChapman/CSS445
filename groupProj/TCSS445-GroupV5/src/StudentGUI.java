/*
 * TCSS 445 - Autumn 2017 Group Project.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
 * Panel for loggedIn student view.
 * 
 * @author Hui Ting Cai, Keegan J Kell, Chad Chapman, Hanan Abdo; [adapted from mmuppa's Movie Project]
 * @version 02 November 2017
 */
public class StudentGUI extends JPanel implements ActionListener, TableModelListener {
	/** A generated serial version UID for object Serialization.*/
	private static final long serialVersionUID = -8280743480072002091L;

	/** Attribute names for the student. */
    private static final String[] columnNames = {"FirstName", "LastName", "StudentID", "Phone#", "Major"};

    /** Buttons to switch between student view modes. */
	private JButton btnInformation, btnUpdate;

	/** Panels for organization of outer panel. */
	private JPanel pnlButtons, pnlContent;

	/** Database to retrieve and update student information. */
	private StudentDB db;

	/** The student. */
	private Student stdt;

	/** Storage for student attribute data. */
	private Object[][] data;

	/** Container for student information view data. */
	private JTable table;

	/** Pane surrounding the student data entry. */
	private JScrollPane scrollPane;

	/** Container for student update view organization. */
	private JPanel pnlAdd;

	/** Labels for student information data. */
	private JLabel[] txfLabel = new JLabel[5];

	/** Editable fields for student information data. */
	private JTextField[] txfField = new JTextField[5];

	/** Alternate method to update student information data. */
	private JButton btnUpdateStudent;

	/** PK ID of this student. */
	private String studentID;

    /**
     * Creates panel for loggedIn student view.
     * @param stdtID ID of this student
     */
	public StudentGUI (String stdtID) {
		studentID = stdtID;
		db = new StudentDB();
		stdt = db.getStudent(this.getStudentID());
		data = new Object[1][columnNames.length];
		data[0][0] = stdt.getFirstName();
		data[0][1] = stdt.getLastName();
		data[0][2] = stdt.getStudentID();
		data[0][3] = stdt.getPhoneNumber();
		data[0][4] = stdt.getMajor();

        layoutComponents();
		setVisible(true);
		setSize(500, 500);
	}

    /**
     * Position the various student view GUI components.
     */
	private void layoutComponents() {
		pnlButtons = new JPanel();

		// Menu button area
		btnInformation = new JButton("Information");
		btnInformation.addActionListener(this);

		btnUpdate = new JButton("Update Student  ");
		btnUpdate.addActionListener(this);

		pnlButtons.add(btnInformation);
		pnlButtons.add(btnUpdate);
		add(pnlButtons, BorderLayout.NORTH);

		// Student information
		pnlContent = new JPanel();
		table = new JTable(data, columnNames);
		scrollPane = new JScrollPane(table);
		pnlContent.add(scrollPane);
		table.getModel().addTableModelListener(this);

		// Student update
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
		btnUpdateStudent = new JButton("Update");
		btnUpdateStudent.addActionListener(this);
		panel.add(btnUpdateStudent);
		pnlAdd.add(panel);

		add(pnlContent, BorderLayout.CENTER);
	}

	/**
	 * Returns the student ID.
	 * @return the student ID
	 */
	public String getStudentID(){
		return studentID;
	}

    /**
     * Initiates appropriate event corresponding with various button presses.
     * @param e button press event
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnUpdate) {
			changePanel(pnlAdd);
		} else if (e.getSource() == btnInformation) {
			table = new JTable(data, columnNames);
			table.getModel().addTableModelListener(this);
			JPanel pnlSP = new JPanel();
            pnlSP.add(new JScrollPane(table));
			changePanel(pnlSP);
		}	else if (e.getSource() == btnUpdateStudent) {
			db.removeStudent(this.getStudentID(), false); // Delete student information
			studentID = txfField[2].getText();
			if(studentID.length() == 7){
				Student student = new Student(txfField[0].getText(), txfField[1].getText(),studentID,
						txfField[3].getText(), txfField[4].getText());
				boolean isSuccess =db.addStudent(student, false);
				student = db.getStudent(this.getStudentID());
				data = new Object[1][columnNames.length];
				data[0][0] = student.getFirstName();
				data[0][1] = student.getLastName();
				data[0][2] = student.getStudentID();
				data[0][3] = student.getPhoneNumber();
				data[0][4] = student.getMajor();
				if(isSuccess){
					for (int i=0; i<txfField.length; i++) {
						txfField[i].setText("");
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "7-digit studentID is required.");
			}
		}
	}

    /**
     * Replaces and redraws current JPanels with {@code jp}.
     * @param jp panel to change to
     */
    private void changePanel(JPanel jp) {
        pnlContent.removeAll();
        pnlContent.removeAll();
        pnlContent.add(jp);
        pnlContent.revalidate();
        this.repaint();
    }

    /**
     * Monitors the table for any change in data, updates database as required.
     * @param e table change event
     */
	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel)e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);
        
        db.updateStudent(row, columnName, data);
	}

}
