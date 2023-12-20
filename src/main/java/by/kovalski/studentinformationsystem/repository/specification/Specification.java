package by.kovalski.studentinformationsystem.repository.specification;

import by.kovalski.studentinformationsystem.entity.Person;

public interface Specification {
  /**
   * @param person - testing object
   * @return - true if object matches to specification
   */
  boolean specified(Person person);
}
