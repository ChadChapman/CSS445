
public class Student {
	private String firstName, lastName, studentID, phoneNumber, major;

	/**
	 * Initialize the movie parameters.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param studentID
	 * @param phoneNumber
	 * @param major
	 * @throws IllegalArgumentException
	 *             if fistName or lastName or studentID or phoneNumber or major
	 *             are null or empty.
	 */
	public Student(String firstName, String lastName, String studentID, String phoneNumber, String major) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setStudentID(studentID);
		this.setPhoneNumber(phoneNumber);
		this.setMajor(major);
	}

	@Override
	public String toString() {
		return "Movie [FirstName=" + firstName + ", LastName=" + lastName + ", StudentId=" + studentID
				+ ", PhoneNumber=" + phoneNumber + ", Major=" + major + "]";
	}

	/**
	 * Returns the fistName of the student.
	 * 
	 * @return studentFistName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Modifies the fistName of the student.
	 * 
	 * @param fristName
	 * @throws IllegalArgumentException
	 *             if fistName is null or empty.
	 */
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() == 0)
			throw new IllegalArgumentException("Please supply a valid first name.");
		this.firstName = firstName;
	}

	/**
	 * Returns the lastName of the student.
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Modifies the lastName of the student.
	 * 
	 * @param lastName
	 * @throws IllegalArgumentException
	 *             if lastName is null or empty.
	 */
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() == 0)
			throw new IllegalArgumentException("Please supply a valid last name.");
		this.lastName = lastName;
	}

	/**
	 * Returns the ID of Student.
	 * 
	 * @return StudentID
	 */
	public String getStudentID() {
		return studentID;
	}

	/**
	 * Modifies the ID of the student.
	 * 
	 * @param studentID
	 * @throws IllegalArgumentException
	 *             if studentID is null or empty.
	 */
	public void setStudentID(String studentID) {
		if (studentID == null || studentID.length() == 0)
			throw new IllegalArgumentException("Please supply a valid studentID.");
		this.studentID = studentID;
	}

	/**
	 * Returns the phoneNumber of the student.
	 * 
	 * @return phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phoneNumber of student.
	 * 
	 * @param phoneNumber
	 * @throws IllegalArgumentException
	 *             if phoneNumber is null or empty.
	 */
	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber == null || phoneNumber.length() == 0)
			throw new IllegalArgumentException("Please supply a valid phoenNumber.");

		this.phoneNumber = phoneNumber;
	}

	/**
	 * Returns the major of student.
	 * 
	 * @return major
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * Sets the major of student.
	 * 
	 * @param major
	 * @throws IllegalArgumentException
	 *             if major is null or empty.
	 */
	public void setMajor(String major) {
		if (major == null || major.length() == 0)
			throw new IllegalArgumentException("Please supply a valid major.");

		this.major = major;
	}

}
