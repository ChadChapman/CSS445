
/*
 * TCSS 445 - Autumn 2017 Group Project.
 */
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * describe???????????
 * 
 * @author Hui Ting Cai and Keegan J Kell
 * @version 25 November 2017
 *
 */
public class InternshipGUI extends JFrame {
	/** A generated serial version UID for object Serialization. */
	private static final long serialVersionUID = -7034923500862909977L;

	/**
	 * pnlButtons, panel contains student button and moderator button; pnlTitle,
	 * panel contains the title "Internship"; pnlEnter, panel contain label
	 * enter and text filed pnlCenter, panel, contains pnlButtons and pnlEnter
	 */
	private JPanel pnlButtons, pnlTitle, pnlCenter, pnlEnter;

	/**
	 * lbTitle = "Internship "; lbEnter ="Enter ID: "; messageLable =" I am a
	 * Student/Moderator".
	 */
	private JLabel lbTitle, lbEnter, messageLabel;

	/**
	 * btnModerator is Moderator button; btnStudent is Student button; btnLogin
	 * is Login button.
	 */
	private JButton btnModerator, btnStudent, btnLogin;

	/** Text Field for enter Id. */
	private JTextField tfEnterId;

	private boolean isStudent;

	/**
	 * Creates the frame and components and launches the GUI. Initializes all of
	 * fields.
	 */
	public InternshipGUI() {
		// The JFrame's overloaded constructor can set the JFram title.
		super("Internship");

		// JPanel
		pnlCenter = new JPanel(new BorderLayout());
		pnlButtons = new JPanel();
		pnlTitle = new JPanel();
		pnlEnter = new JPanel();

		// Create buttons
		btnModerator = new JButton("Moderator");
		// btnModerator.addActionListener(this);
		btnStudent = new JButton("Student");
		/// btnModerator.addActionListener(this);
		btnLogin = new JButton("Login");

		// Create label
		lbTitle = new JLabel("Internship");
		lbTitle.setFont(new Font("SansSErif", Font.BOLD, 50));
		lbEnter = new JLabel("Enter ID:");
		lbEnter.setFont(new Font("SansSErif", Font.BOLD, 15));
		messageLabel = new JLabel("I am a Moderator");

		// Create a Text Field
		tfEnterId = new JPasswordField(15);

		// Add a moderator button to be a listener object
		btnModeratorListener();

		// Add a student button to be a listener object
		btnStudentListener();

		// Add a Login button to be a listener object
		btnLoginListener();
	}

	/**
	 * Displays a JFram.
	 */
	public void start() {
		// Set the close operation!
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LayOutComponents();
		setVisible(true);
		setSize(500, 500);
	}

	/**
	 * Lay out the components.
	 */
	private void LayOutComponents() {

		// Add Moderator button and Student button into pnlButtons
		pnlButtons.add(btnModerator);
		pnlButtons.add(btnStudent);

		// Add lbTitle into pnlTitle
		pnlTitle.add(lbTitle);

		// Add Text field and label into pnlEnter
		pnlEnter.add(lbEnter);
		pnlEnter.add(tfEnterId);
		pnlEnter.add(btnLogin);
		pnlEnter.add(messageLabel);

		// Add pnlButtons into pnlCenter and layout.North
		pnlCenter.add(pnlButtons, BorderLayout.NORTH);
		pnlCenter.add(pnlEnter, BorderLayout.CENTER);

		// ADD the pnlTitle and pnlCenter into JFrame.
		this.add(pnlTitle, BorderLayout.NORTH);
		this.add(pnlCenter, BorderLayout.CENTER);
	}

	/**
	 * Add ActionListener to the student buttons
	 */
	private void btnStudentListener() {
		btnStudent.addActionListener((theEvent) -> {
			messageLabel.setText("I am a student");
			isStudent = true;
		});
	}

	/**
	 * Add ActionListener to the Moderator buttons
	 */
	private void btnModeratorListener() {
		btnModerator.addActionListener((theEvent) -> {
			messageLabel.setText("I am a Moderator");
			isStudent = false;
		});
	}

	/**
	 * Add ActionListener to the Login buttons.
	 */
	private void btnLoginListener() {
		btnLogin.addActionListener((theEvent) -> {
			if (tfEnterId.getText().length() > 0 && !isStudent) {
				// *** CAll the Moderator GUI Here*****
				ModeratorGUI moderatorGUI = new ModeratorGUI();
				moderatorGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				btnLogin.setEnabled(false);
			}

			if (tfEnterId.getText().length() > 0 && isStudent) {
				// *** CAll the Student GUI Here*****
				btnLogin.setEnabled(false);
			}
		});
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InternshipGUI movieGUI = new InternshipGUI();
		movieGUI.start();
	}
}