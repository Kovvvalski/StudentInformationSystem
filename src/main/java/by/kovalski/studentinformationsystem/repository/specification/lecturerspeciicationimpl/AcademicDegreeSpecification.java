package by.kovalski.studentinformationsystem.repository.specification.lecturerspeciicationimpl;

import by.kovalski.studentinformationsystem.entity.AcademicDegree;
import by.kovalski.studentinformationsystem.entity.Lecturer;
import by.kovalski.studentinformationsystem.entity.Person;
import by.kovalski.studentinformationsystem.exception.RepositoryException;
import by.kovalski.studentinformationsystem.repository.specification.Specification;

public class AcademicDegreeSpecification implements Specification {
  private final AcademicDegree degree;

  public AcademicDegreeSpecification(AcademicDegree degree) {
    this.degree = degree;
  }

  @Override
  public boolean specified(Person person) {
    if(person.getClass() != Lecturer.class)
      return false;
    Lecturer lecturer = (Lecturer) person;
    return lecturer.getAcademicDegree() == degree;
  }

}
