package by.kovalski.studentinformationsystem.repository.specification.studentspecificationimpl;

import by.kovalski.studentinformationsystem.entity.Person;
import by.kovalski.studentinformationsystem.entity.Student;
import by.kovalski.studentinformationsystem.repository.specification.Specification;

public class GroupSpecification implements Specification {
  private final String group;

  public GroupSpecification(String group) {
    this.group = group;
  }


  @Override
  public boolean specified(Person person) {
    if (person.getClass() != Student.class)
      return false;
    Student student = (Student) person;
    return student.getGroup().equals(group);
  }
}
