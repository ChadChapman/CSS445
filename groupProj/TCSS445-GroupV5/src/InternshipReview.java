
public class InternshipReview {
    private String studentID, reviewID, reviewText;

    /**
     * @param studentID
     * @param reviewID
     * @param reviewText
     * @throws IllegalArgumentException
     *             if any params are null or empty.
     */
    public InternshipReview(String studentID, String reviewID, String reviewText) {
        this.setStudentID(studentID);
        this.setReviewID(reviewID);
        this.setReviewText(reviewText);
    }

    @Override
    public String toString() {
        return "Review [StudentId=" + studentID
                + ", ReviewID=" + reviewID + ", ReviewText=" + reviewText + "]";
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
     * Returns the ID of Review.
     *
     * @return StudentID
     */
    public String getReviewID() {
        return reviewID;
    }

    /**
     * Modifies the ID of the student.
     *
     * @param reviewID
     * @throws IllegalArgumentException
     *             if studentID is null or empty.
     */
    public void setReviewID(String reviewID) {
        if (reviewID == null || reviewID.length() == 0)
            throw new IllegalArgumentException("Please supply a valid reviewID.");
        this.reviewID = reviewID;
    }

    /**
     * Returns the body of the review.
     *
     * @return reviewText
     */
    public String getReviewText() {
        return reviewText;
    }

    /**
     * Sets the reviewText of student.
     *
     * @param reviewText
     * @throws IllegalArgumentException
     *             if reviewText is null or empty.
     */
    public void setReviewText(String reviewText) {
        if (reviewText == null || reviewText.length() == 0)
            throw new IllegalArgumentException("Please supply a valid review.");

        this.reviewText = reviewText;
    }

}

