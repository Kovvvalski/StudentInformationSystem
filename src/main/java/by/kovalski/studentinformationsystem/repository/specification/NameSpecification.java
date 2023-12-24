package by.kovalski.studentinformationsystem.repository.specification;

import by.kovalski.studentinformationsystem.entity.Person;

public class NameSpecification implements Specification{
  private final String name;

  public NameSpecification(String name) {
    this.name = name;
  }

  @Override
  public boolean specified(Person person) {
    return person.getName().equals(name);
  }
}
