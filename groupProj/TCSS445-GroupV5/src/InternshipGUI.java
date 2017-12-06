/*
 * TCSS 445A - Autumn 2017 - Group A
 */

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Creates GUI for Internship Review Program.
 * 
 * @author Hui Ting Cai, Keegan J Kell, Chad Chapman, Hanan Abdo; [adapted from mmuppa's Movie Project]
 * @version 02 November 2017
 */
public class InternshipGUI extends JFrame {
	/** Generated serial version UID for object Serialization. */
	private static final long serialVersionUID = -7034923500862909977L;

	/** Panels to assist in GUI organization. */
	private JPanel pnlButtons, pnlTitle, pnlCenter, pnlEnter;

	/** Title, command, and response labels. */
	private JLabel lbTitle, lbEnter, lbMessage;

	/** User type and desired action buttons. */
	private JButton btnModerator, btnStudent, btnLogin, btnRegister;

	/** Text Field for enter Id. */
	private JTextField tfEnterId;

	/** User type. */
	private boolean isStudent;

	/** Primary key for identifying students. */
	private String studentID;

	/**
	 * Starts Intern Review GUI.
	 * @param args unused command line parameters
	 */
	public static void main(String[] args) {
		InternshipGUI movieGUI = new InternshipGUI();
		movieGUI.start();
	}

	/**
	 * Creates JFrame and initializes basic GUI structure.
	 */
	public InternshipGUI() {
		super("Internship");

		pnlCenter = new JPanel(new BorderLayout());
		pnlButtons = new JPanel();
		pnlTitle = new JPanel();
		pnlEnter = new JPanel();

		btnModerator = new JButton("Moderator");
		btnStudent = new JButton("Student");
		btnLogin = new JButton("Login");
		btnRegister = new JButton("Register");

        pnlTitle.add(createLabel("Internship", 50));
        pnlEnter.add(createLabel("Enter ID:", 15));

		tfEnterId = new JPasswordField(15);
        lbMessage = new JLabel("(as a Moderator)");
        lbMessage.setPreferredSize(new Dimension(117,20));

        btnUserListener(btnModerator, "(as a Moderator)", false);
        btnUserListener(btnStudent, "(as a Student)", true);
		btnLoginListener();
		btnRegisterListener();
	}

	/**
	 * Initializes JFrame values.
	 */
	public void start() {
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		LayOutComponents();
		setVisible(true);
		setSize(500, 500);
	}

	/**
	 * Positions the various GUI components.
	 */
	private void LayOutComponents() {
		pnlButtons.add(btnModerator);
		pnlButtons.add(btnStudent);
		pnlButtons.add(btnRegister);

		pnlEnter.add(tfEnterId);
		pnlEnter.add(btnLogin);
		pnlEnter.add(lbMessage);

		pnlCenter.add(pnlButtons, BorderLayout.NORTH);
		pnlCenter.add(pnlEnter, BorderLayout.CENTER);

		this.add(pnlTitle, BorderLayout.NORTH);
		this.add(pnlCenter, BorderLayout.CENTER);
	}

    /**
     * Returns custom label of specified length.
     * @param s text for label
     * @param length width for label
     * @return formatted label
     */
    public JLabel createLabel(String s, int length) {
        JLabel jl = new JLabel(s);
        jl.setFont(new Font("SansSerif", Font.BOLD, length));
        return jl;
    }

    /**
     * Add ActionListener to button {@code jb}; modifies GUI according to specified user type.
     * @param jb button to add listener to
     * @param s description of user type
     * @param stdt True is Student, False is Moderator
     */
	private void btnUserListener(JButton jb, String s, boolean stdt) {
		jb.addActionListener((theEvent) -> {
			lbMessage.setText(s);
			lbMessage.setPreferredSize(new Dimension(117,20));
			isStudent = stdt;
		});
	}

	/**
	 * Adds ActionListener to Login buttons.
     * Moderators are not yet verified; students are verified against the database.
	 */
	private void btnLoginListener() {
		btnLogin.addActionListener((theEvent) -> {

			// Moderator User
			if (tfEnterId.getText().length() > 0 && !isStudent) {
				changePanel(new ModeratorGUI(), "Moderator View");
			}

			// Student User
			if (tfEnterId.getText().length() > 0 && isStudent) {
				studentID = tfEnterId.getText();
				if (studentID.length() == 7) { // force 7 digit ID
					StudentDB db = new StudentDB();
					if (db.checkStudent(studentID)) {
                        changePanel(new StudentGUI(studentID), "Student View");
                    }
					tfEnterId.setText("");
				} else { // studentID.length() != 7
					JOptionPane.showMessageDialog(null, "7-digit StudentID's are required.");
				}
			}
		});
	}
	
	/**
	 * Add ActionListener to Register button.  Only allows new students to register, not moderators.
	 */
	private void btnRegisterListener() {
		btnRegister.addActionListener((theEvent) -> {
			if (isStudent) {
				changePanel(new RegisterGUI(), "Register New Student");
			} else { // user is not a student
                JOptionPane.showMessageDialog(null, "Only student registration is allowed here.");
            }
		});
	}

    /**
     * Replaces and redraws current JPanels with {@code jp}.
     * @param jp panel to change to
     */
	private void changePanel(JPanel jp, String title) {
        pnlCenter.removeAll();
        pnlTitle.removeAll();
        pnlCenter.add(jp);
        setTitle(title);
        pnlCenter.revalidate();
        this.repaint();
    }
}