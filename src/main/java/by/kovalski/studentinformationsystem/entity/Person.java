package by.kovalski.studentinformationsystem.entity;

import by.kovalski.studentinformationsystem.util.IdGenerator;

public abstract class Person {
  private static final String EMAIL_REGEX = ".+\\@.+\\..+";
  private static final String TELEPHONE_NUMBER_REGEX = "[0-9]-[0-9]{3}-[0-9]{3}[0-9]{2}[0-9]{2}";
  private static final String DEFAULT_EMAIL_VALUE = "someemail@gmail.com";
  private static final String DEFAULT_TELEPHONE_VALUE = "0-000-000-00-00";
  /**
   * person's id
   */
  private final long id;
  /**
   * person's name
   */
  private String name;
  /**
   * person's faculty
   */
  private Faculty faculty;
  /**
   * valid telephone number
   */
  private String telephoneNumber;
  /**
   * valid telephone number
   */
  private String email;

  /**
   * constructor checks validity of email and telephone number
   *
   * @param name            - name
   * @param faculty         - faculty
   * @param email           - valid email
   * @param telephoneNumber - valid telephone number
   */

  public Person(String name, Faculty faculty, String email, String telephoneNumber) {
    this.id = IdGenerator.detId();
    this.name = name;
    this.faculty = faculty;
    setEmail(email);
    setTelephoneNumber(telephoneNumber);
  }

  /**
   * @return id
   */
  public long getId() {
    return id;
  }

  /**
   * @return name
   */

  public String getName() {
    return name;
  }

  /**
   * @param name - any name
   */

  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return faculty
   */

  public Faculty getFaculty() {
    return faculty;
  }

  /**
   * @param faculty - any faculty
   */

  public void setFaculty(Faculty faculty) {
    this.faculty = faculty;
  }

  /**
   * @return telephone number
   */

  public String getTelephoneNumber() {
    return telephoneNumber;
  }

  /**
   * checks validity of input string by telephone number regex
   *
   * @param telephoneNumber - any string
   */

  public void setTelephoneNumber(String telephoneNumber) {
    if (telephoneNumber.matches(TELEPHONE_NUMBER_REGEX)) {
      this.telephoneNumber = telephoneNumber;
    } else {
      this.telephoneNumber = DEFAULT_TELEPHONE_VALUE;
    }
  }

  /**
   * @return email
   */

  public String getEmail() {
    return email;
  }

  /**
   * checks validity of input string by email regex
   *
   * @param email - any string
   */

  public void setEmail(String email) {
    if (email.matches(EMAIL_REGEX)) {
      this.email = email;
    } else {
      this.email = DEFAULT_EMAIL_VALUE;
    }
  }

  /**
   * @param o - any object
   * @return - true if objects are equals
   */

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return id == person.id && name.equals(person.name) && faculty == person.faculty && telephoneNumber.equals(person.telephoneNumber) && email.equals(person.email);
  }

  /**
   * @return hash code of an object
   */

  @Override
  public int hashCode() {
    return 31 * (int) id + name.hashCode() + faculty.hashCode() + telephoneNumber.hashCode() + email.hashCode();
  }



}
