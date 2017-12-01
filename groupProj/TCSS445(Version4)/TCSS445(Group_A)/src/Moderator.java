import static java.lang.Character.isLetter;
import static java.lang.Character.toUpperCase;

/**
 * Represents a moderator whom is capable of deleting anything except another
 * Moderator.
 */

public class Moderator {
	private int employeeID;
	private String firstName;
	private String lastName;
	private char gender;
	private String emailAddress;

	public Moderator(int employeeID, String firstName, String lastName, char gender, String emailAddress) {
		setEmployeeID(employeeID);
		setFirstName(firstName);
		setLastName(lastName);
		setGender(gender);
		setEmailAddress(emailAddress);
		System.out.println("Welcome: " + this.toString());
	}

	public void setEmployeeID(int employeeID) {
		if (employeeID <= 0) {
			throw new IllegalArgumentException("Illegal parameter: employeeID must be positive");
		}
		this.employeeID = employeeID;
	}

	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() == 0) {
			throw new IllegalArgumentException("Missing parameter: firstName is mandatory");
		}
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() == 0) {
			throw new IllegalArgumentException("Missing parameter: lastName is mandatory");
		}
		this.lastName = lastName;
	}

	public void setGender(char gender) {
		if (!isLetter(gender) && gender != '0') {
			throw new IllegalArgumentException("Illegal parameter: either do not specify or provide a valid gender");
		}
		gender = toUpperCase(gender);
		if (gender != 'M' && gender != 'F' && gender != 'T') {
			throw new IllegalArgumentException("Illegal parameter: invalid gender input");
		}
		this.gender = gender;
	}

	public void setEmailAddress(String emailAddress) {
		if (emailAddress == null || emailAddress.length() == 0) {
			throw new IllegalArgumentException("Illegal parameter: invalid email address");
		}
		this.emailAddress = emailAddress;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public char getGender() {
		return gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	/*
	 * @Override public String toString() { StringBuilder sb = new
	 * StringBuilder(); sb.append(employeeID); sb.append(' ');
	 * sb.append(firstName); sb.append(' '); sb.append(lastName); sb.append('
	 * '); sb.append(emailAddress); sb.append(' '); sb.append(gender); return
	 * sb.toString(); }
	 */
}
