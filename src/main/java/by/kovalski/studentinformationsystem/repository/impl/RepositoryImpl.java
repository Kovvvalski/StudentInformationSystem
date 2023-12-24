package by.kovalski.studentinformationsystem.repository.impl;

import by.kovalski.studentinformationsystem.entity.Lecturer;
import by.kovalski.studentinformationsystem.entity.Person;
import by.kovalski.studentinformationsystem.exception.RepositoryException;
import by.kovalski.studentinformationsystem.repository.Repository;
import by.kovalski.studentinformationsystem.repository.specification.Specification;

import java.util.HashSet;
import java.util.List;

public class RepositoryImpl implements Repository {
  private static RepositoryImpl instance;
  private HashSet<Person> data;

  public RepositoryImpl() {
    data = new HashSet<>();
  }

  public static RepositoryImpl getInstance() {
    if (instance == null) {
      instance = new RepositoryImpl();
    }
    return instance;
  }

  /**
   * @param person - any person
   * @throws RepositoryException if person is not correct
   */

  @Override
  public void addPerson(Person person) throws RepositoryException {
    if (person == null)
      throw new RepositoryException("Null reference");
    if (!data.add(person))
      throw new RepositoryException("Can not add lecturer " + person.getName());
  }

  /**
   * @param person - any person
   * @throws RepositoryException if person is not correct
   */

  @Override
  public void removePerson(Person person) throws RepositoryException {
    if (!data.remove(person))
      throw new RepositoryException("Can not remove lecturer " + person.getName());
  }

  /**
   * @param person - any person
   * @throws RepositoryException if person does not exist
   */

  @Override
  public void updatePerson(Person person) throws RepositoryException {
    List<Person> found = data.stream().filter(o -> o.getId() == person.getId()).toList();
    if (found.size() != 1)
      throw new RepositoryException("Error in repository data or person with id " + person.getId() + " does not exists");
    data.remove(found.get(0));
    data.add(person);
  }

  /**
   * @param specification - any specification
   * @return list of Lecturers from data that specified to specification
   */

  @Override
  public List<Person> query(Specification specification) {
    return data.stream().filter(o -> specification.specified(o)).toList();
  }

  public HashSet<Person> getData() {
    return new HashSet<>(data);
  }

}
