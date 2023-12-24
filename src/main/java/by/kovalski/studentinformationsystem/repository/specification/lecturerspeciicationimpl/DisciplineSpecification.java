package by.kovalski.studentinformationsystem.repository.specification.lecturerspeciicationimpl;

import by.kovalski.studentinformationsystem.entity.Disciplines;
import by.kovalski.studentinformationsystem.entity.Lecturer;
import by.kovalski.studentinformationsystem.entity.Person;
import by.kovalski.studentinformationsystem.repository.specification.Specification;

public class DisciplineSpecification implements Specification {
  private final Disciplines discipline;

  public DisciplineSpecification(Disciplines discipline) {
    this.discipline = discipline;
  }

  @Override
  public boolean specified(Person person) {
    if (person.getClass() != Lecturer.class)
      return false;
    Lecturer lecturer = (Lecturer) person;
    return lecturer.getDiscipline() == discipline;
  }
}
