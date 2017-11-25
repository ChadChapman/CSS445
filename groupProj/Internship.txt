/**
 * Represents an Internship opening listed by an Employer.
 * @author mmuppa
 * @author chadtc
 *
 */
public class Internship {
    private String title, employer, term, phone, email, website;
    private int length;

    /**
     * Initialize the Internship parameters.
     * @param title - name of the opening, eg UX Intern, SE Intern
     * @param employer - name of employer associated with the opening
     * @param length - number of days of internship, eg 90, 120 (may need to be changed later)
     * @param term - academic term of the opening, eg Winter 2018, Summer 2020
     * @param phone - contact phone number for employer
     * @throws IllegalArgumentException if title or employer or term or phone or email or website are null or empty,
     * length <= 1.
     */
    public Internship(String title, String employer, int length, String term,
                      String phone, String email, String website) {
        setTitle(title);
        setEmployer(employer);
        setLength(length);
        setTerm(term);
        setPhone(phone);
        setEmail(email);
        setWebsite(website);
    }

    @Override
    public String toString()
    {
        return "Internship [title=" + title + ", employer=" + employer + ", length="
                + length + ", term=" + term + ", phone=" + phone + ", email=" + email
                + "website=" + website
                + "]";
    }

    /**
     * Returns the title of the movie.
     * @return movie title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Modifies the title of the movie.
     * @param title
     * @throws IllegalArgumentException if title is null or empty.
     */
    public void setTitle(String title)
    {
        if (title == null || title.length() == 0 )
            throw new IllegalArgumentException("Please supply a valid title.");
        this.title = title;
    }

    /**
     * Returns the employer the movie was made.
     * @return employer
     */
    public int getEmployer()
    {
        return employer;
    }

    /**
     * Sets the movie employer.
     * @param employer
     * @throws IllegalArgumentException if employer is before 1920.
     */
    public void setEmployer(int employer)
    {
        if (employer.length < 1)
            throw new IllegalArgumentException("Internship employer name must contain > 1 char.");
        this.employer = employer;
    }

    /**
     * Returns the length of the movie.
     * @return length
     */
    public int getLength()
    {
        return length;
    }

    /**
     * Modifies the length of the movie.
     * @param length
     * @throws IllegalArgumentException if length is negative or 0.
     */
    public void setLength(int length)
    {
        if (length <= 0)
            throw new IllegalArgumentException("Internship length cannot be negative or 0.");

        this.length = length;
    }

    /**
     * Returns the term of the movie.
     * @return term
     */
    public String getTerm()
    {
        return term;
    }

    /**
     * Sets the term of the movie.
     * @param term
     * @throws IllegalArgumentException if term is null or empty.
     */
    public void setTerm(String term)
    {
        if (term == null || term.length() == 0)
            throw new IllegalArgumentException("Please supply a valid term eg Summer, Winter.");

        this.term = term;
    }

    /**
     * Returns the name of the studio.
     * @return phone
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * Sets the name of the studio.
     * @param phone
     * @throws IllegalArgumentException if studio name is null or empty.
     */
    public void setPhone(String phone)
    {
        if (phone == null || phone.length() < 10)
            throw new IllegalArgumentException("Please supply a valid phone number.");

        this.phone = phone;
    }

    /**
     * Returns the employer's email address.
     * @return email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Sets the employer email address.
     * @param email
     * @throws IllegalArgumentException if email is null or too short to be valid.
     */
    public void setEmail(String email)
    {
        if (email == null || email.length() < 7) //e@a.com
            throw new IllegalArgumentException("Please supply a valid email address.");

        this.phone = phone;
    }

    /**
     * Returns the employer's website url as a string, not a URL.
     * @return website
     */
    public String getWebsite()
    {
        return website;
    }

    /**
     * Sets the employer website.
     * @param website
     * @throws IllegalArgumentException if website is null.
     */
    public void setWebsite(String website)
    {
        if (website == null) //can be either a valid URL or a fragment
            throw new IllegalArgumentException("Please supply a valid website address.");

        this.website = website;
    }


}
