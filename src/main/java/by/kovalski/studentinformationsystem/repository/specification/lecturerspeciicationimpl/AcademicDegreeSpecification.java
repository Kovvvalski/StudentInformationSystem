package by.kovalski.studentinformationsystem.repository.specification.lecturerspeciicationimpl;

import by.kovalski.studentinformationsystem.entity.AcademicDegree;
import by.kovalski.studentinformationsystem.entity.Lecturer;
import by.kovalski.studentinformationsystem.entity.Person;
import by.kovalski.studentinformationsystem.exception.RepositoryException;
import by.kovalski.studentinformationsystem.repository.specification.Specification;

public class AcademicDegreeSpecification implements Specification {
  private AcademicDegree degree;

  public AcademicDegreeSpecification(AcademicDegree degree) {
    this.degree = degree;
  }

  public AcademicDegree getDegree() {
    return degree;
  }

  public void setDegree(AcademicDegree degree) {
    this.degree = degree;
  }

  @Override
  public boolean specified(Person person) {
    if(person.getClass() != Lecturer.class)
      throw new RuntimeException("Not instance of Lecture");
    Lecturer lecturer = (Lecturer) person;
    return lecturer.getAcademicDegree() == degree;
  }

}
