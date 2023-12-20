package by.kovalski.studentinformationsystem.repository.specification.lecturerspeciicationimpl;

import by.kovalski.studentinformationsystem.entity.Disciplines;
import by.kovalski.studentinformationsystem.entity.Lecturer;
import by.kovalski.studentinformationsystem.entity.Person;
import by.kovalski.studentinformationsystem.repository.specification.Specification;

public class DisciplineSpecification implements Specification {
  private Disciplines discipline;

  public DisciplineSpecification(Disciplines discipline) {
    this.discipline = discipline;
  }

  public Disciplines getDiscipline() {
    return discipline;
  }

  public void setDiscipline(Disciplines discipline) {
    this.discipline = discipline;
  }

  @Override
  public boolean specified(Person person) {
    if(person.getClass() != Lecturer.class)
      throw new RuntimeException("Not instance of Lecturer");
    Lecturer lecturer = (Lecturer) person;
    return lecturer.getDiscipline() == discipline;
  }
}
