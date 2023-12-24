package by.kovalski.studentinformationsystem.entity;

import java.util.Objects;
import java.util.StringJoiner;

public class Lecturer extends Person {
  /**
   * discipline of lecturer
   */
  private Disciplines discipline;
  /**
   * academic degree of lecturer
   */
  private AcademicDegree academicDegree;

  /**
   * @param id              - any ad
   * @param name            - any name
   * @param faculty         - faculty
   * @param email           - valid email
   * @param telephoneNumber - any valid telephone number
   * @param discipline      - any
   * @param academicDegree  - academic degree
   */

  public Lecturer(long id, String name, Faculty faculty, String email, String telephoneNumber, Disciplines discipline, AcademicDegree academicDegree) {
    super(id, name, faculty, email, telephoneNumber);
    this.discipline = discipline;
    this.academicDegree = academicDegree;
  }

  /**
   * @return discipline
   */

  public Disciplines getDiscipline() {
    return discipline;
  }

  /**
   * @param discipline - any discipline
   */

  public void setDiscipline(Disciplines discipline) {
    this.discipline = discipline;
  }

  /**
   * @return academic degree
   */

  public AcademicDegree getAcademicDegree() {
    return academicDegree;
  }

  /**
   * @param academicDegree - any academic degree
   */

  public void setAcademicDegree(AcademicDegree academicDegree) {
    this.academicDegree = academicDegree;
  }

  /**
   * @param o - any object
   * @return true if object are equals of an object
   */

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Lecturer lecturer = (Lecturer) o;
    if (discipline != null ? discipline != lecturer.discipline : lecturer.discipline != null) return false;
    if (academicDegree != null ? academicDegree != lecturer.academicDegree : lecturer.academicDegree != null)
      return false;
    return true;
  }

  /**
   * @return hash code of an object
   */

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (discipline != null ? discipline.hashCode() : 0);
    result = 31 * result + (academicDegree != null ? academicDegree.hashCode() : 0);
    return result;
  }

  /**
   * @return string of an object
   */

  @Override
  public String toString() {
    return new StringJoiner(", ", Lecturer.class.getSimpleName() + "[", "]")
            .add(getName())
            .add("discipline=" + discipline)
            .add("academicDegree=" + academicDegree)
            .toString();
  }

  @Override
  public String getPersonInformation() {
    return new StringJoiner(", ")
            .add("I'm lecturer with name " + getName())
            .add("My discipline is " + discipline)
            .add("My academic degree is " + academicDegree)
            .toString();
  }
}
