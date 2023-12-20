package by.kovalski.studentinformationsystem.entity;

import by.kovalski.studentinformationsystem.exception.RepositoryException;
import by.kovalski.studentinformationsystem.repository.Repository;
import by.kovalski.studentinformationsystem.repository.impl.LectureRepository;
import by.kovalski.studentinformationsystem.repository.impl.StudentRepository;

public class Administrator extends Person {
  private static final Repository STUDENT_REPOSITORY = StudentRepository.getInstance();
  private static final Repository LECTURER_REPOSITORY = LectureRepository.getInstance();
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

  public Administrator(String name, Faculty faculty, String email, String telephoneNumber, int officeNumber) {
    super(name, faculty, email, telephoneNumber);
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
   * removes the lecturer from repository
   *
   * @param lecturer - any lecturer
   */

  public void removeLecturer(Lecturer lecturer) {
    try {
      LECTURER_REPOSITORY.removePerson(lecturer);
    } catch (RepositoryException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * removes student from repository
   *
   * @param student
   */

  public void removeStudent(Student student) {
    try {
      STUDENT_REPOSITORY.removePerson(student);
    } catch (RepositoryException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * adds lecturer to the repository
   *
   * @param lecturer - any lecturer
   */

  public void addLecturer(Lecturer lecturer) {
    try {
      LECTURER_REPOSITORY.addPerson(lecturer);
    } catch (RepositoryException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * adds student to the repository
   *
   * @param student - any student
   */

  public void addStudent(Student student) {
    try {
      STUDENT_REPOSITORY.addPerson(student);
    } catch (RepositoryException e) {
      System.out.println(e.getMessage());
    }
  }


}
