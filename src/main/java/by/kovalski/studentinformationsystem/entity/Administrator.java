package by.kovalski.studentinformationsystem.entity;

import by.kovalski.studentinformationsystem.exception.RepositoryException;
import by.kovalski.studentinformationsystem.repository.Repository;
import by.kovalski.studentinformationsystem.repository.impl.RepositoryImpl;

import java.util.StringJoiner;

public class Administrator extends Person {
  private static final Repository REPOSITORY = RepositoryImpl.getInstance();
  /**
   * number of office
   */
  private int officeNumber;

  /**
   * @param name            - any name
   * @param faculty         - any faculty
   * @param email           - any valid email
   * @param telephoneNumber - any valid telephone number
   * @param officeNumber    - any office number
   */

  public Administrator(long id,String name, Faculty faculty, String email, String telephoneNumber, int officeNumber) {
    super(id,name, faculty, email, telephoneNumber);
    this.officeNumber = officeNumber;
  }

  /**
   * @return office number
   */

  public int getOfficeNumber() {
    return officeNumber;
  }

  /**
   * sets office number
   *
   * @param officeNumber - any value
   */

  public void setOfficeNumber(int officeNumber) {
    this.officeNumber = officeNumber;
  }

  /**
   *
   * @param o - any object
   * @return true if objects are equals
   */

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Administrator that = (Administrator) o;
    return officeNumber == that.officeNumber;
  }

  /**
   *
   * @return hash code of an object
   */

  @Override
  public int hashCode() {
    int result = super.hashCode();
    return 31 * result + officeNumber;
  }

  /**
   *
   * @return string of an object
   */

  @Override
  public String toString() {
    return new StringJoiner(", ", Administrator.class.getSimpleName() + "[", "]")
            .add("officeNumber=" + officeNumber)
            .toString();
  }

  @Override
  public String getPersonInformation() {
    return new StringJoiner(", ")
            .add("I'm administrator with name " + getName())
            .add("from faculty " + getFaculty())
            .add("from office " + officeNumber)
            .toString();
  }

  /**
   * removes student from repository
   *
   * @param person - any person
   */

  public void removePerson(Person person) {
    try {
      REPOSITORY.removePerson(person);
    } catch (RepositoryException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * adds lecturer to the repository
   *
   * @param person - any lecturer
   */

  public void addPerson(Person person) {
    try {
      REPOSITORY.addPerson(person);
    } catch (RepositoryException e) {
      System.out.println(e.getMessage());
    }
  }

}
