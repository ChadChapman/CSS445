/*
 * TCSS 445A - Autumn 2017 - Group A
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Creates panel for student registration.
 *
 * @author Hui Ting Cai, Keegan J Kell, Chad Chapman, Hanan Abdo; [adapted from mmuppa's Movie Project]
 * @version 02 November 2017
 */
public class RegisterGUI extends JPanel implements ActionListener{
	
	/** A generated serial version UID for object Serialization.*/
	private static final long serialVersionUID = -2827451653287095287L;

	/** Button to register the student. */
	private JButton btnRegister;

	/** Panel for storing buttons. */
	private JPanel pnlButtons;

	/** Panel for main registration content. */
	private JPanel pnlContent;

	/** Database used to update student information. */
	private StudentDB db;

	/** Panel for adding new student information. */
	private JPanel pnlAdd;

	/** Labels for the new student's information. */
	private JLabel[] txfLabel = new JLabel[5];

	/** Fields to enter the new student's information */
	private JTextField[] txfField = new JTextField[5];
	
	
	/**
	 * Creates JPanel and sets basic registration GUI structure.
	 */
	public RegisterGUI(){
        btnRegister = new JButton("Register");
        pnlButtons = new JPanel();
        pnlContent = new JPanel();
		db = new StudentDB();
        pnlAdd = new JPanel();
		layoutComponents();
		setVisible(true);
		setSize(500, 500);
	}
	
	/**
	 * Positions the various registration GUI components.
	 */
	private void layoutComponents() {
		btnRegister.addActionListener(this);
		pnlButtons.add(btnRegister);
		pnlAdd.setLayout(new GridLayout(6, 0));
		String labelNames[] = { "FirstName: ", "LastName: ", "StudentID: ", "Phone#: ", "Major: "};
		for (int i = 0; i < labelNames.length; i++) {
			JPanel attribute = new JPanel();
			txfLabel[i] = new JLabel(labelNames[i]);
			txfLabel[i].setPreferredSize(new Dimension(100, 20));
			txfField[i] = new JTextField(25);
            attribute.add(txfLabel[i]);
            attribute.add(txfField[i]);
			pnlAdd.add(attribute);
		}
		pnlContent.add(pnlAdd);
		add(pnlContent, BorderLayout.CENTER);
        add(pnlButtons, BorderLayout.SOUTH);
	}

    /**
     * Initiates appropriate actions corresponding with various button presses.
     * @param e button press event
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegister) {
			String studentID = txfField[2].getText(); 

			if (studentID.length() == 7) {
				Student student = new Student(txfField[0].getText(), txfField[1].getText(),studentID,
						                      txfField[3].getText(), txfField[4].getText());
				// Add a student into database
				boolean isSuccess = db.addStudent(student, true); 

				if (isSuccess) { // update student GUI after database update
					StudentGUI studentGUI = new StudentGUI(studentID);                                    /* NOT USED */
				}
				
			} else { // studentID is not 7-digits
				JOptionPane.showMessageDialog(null, "StudentID must be 7-digits.");
			}
		}
	}
}
