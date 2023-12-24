package by.kovalski.studentinformationsystem.repository.specification.studentspecificationimpl;

import by.kovalski.studentinformationsystem.entity.Person;
import by.kovalski.studentinformationsystem.entity.Student;
import by.kovalski.studentinformationsystem.exception.RepositoryException;
import by.kovalski.studentinformationsystem.repository.specification.Specification;
import by.kovalski.studentinformationsystem.service.impl.StudentServiceImpl;

public class AverageMarkSpecificationMore implements Specification {
  private final double mark;

  public AverageMarkSpecificationMore(double mark) {
    this.mark = mark;
  }

  @Override
  public boolean specified(Person person) {
    if(person.getClass()!= Student.class)
     return false;
    Student student = (Student) person;
    return new StudentServiceImpl().countAverageMark(student) > mark;
  }
}
