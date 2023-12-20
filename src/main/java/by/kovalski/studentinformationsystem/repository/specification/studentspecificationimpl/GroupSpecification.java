package by.kovalski.studentinformationsystem.repository.specification.studentspecificationimpl;

import by.kovalski.studentinformationsystem.entity.Person;
import by.kovalski.studentinformationsystem.entity.Student;
import by.kovalski.studentinformationsystem.repository.specification.Specification;

public class GroupSpecification implements Specification {
  private String group;

  public GroupSpecification(String group) {
    this.group = group;
  }

  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  @Override
  public boolean specified(Person person) {
    if(person.getClass()!= Student.class)
      throw new RuntimeException("Not instance of Student");
    Student student = (Student) person;
    return student.getGroup().equals(group);
  }
}
