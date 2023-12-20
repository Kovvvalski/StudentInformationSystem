package by.kovalski.studentinformationsystem.repository;

import by.kovalski.studentinformationsystem.entity.Person;
import by.kovalski.studentinformationsystem.exception.RepositoryException;
import by.kovalski.studentinformationsystem.repository.specification.Specification;

import java.util.List;

public interface Repository {
  /**
   * adds person to repository
   *
   * @param person - any person
   * @throws RepositoryException if person is not correct
   */
  void addPerson(Person person) throws RepositoryException;

  /**
   * removes person from repository
   *
   * @param person - any person
   * @throws RepositoryException if person is not correct
   */

  void removePerson(Person person) throws RepositoryException;

  /**
   * updates person in repository
   *
   * @param person - any person
   * @throws RepositoryException if person does not exist
   */

  void updatePerson(Person person) throws RepositoryException;

  /**
   * @param specification - any specification
   * @return - list of an objects that matches to specification
   * @throws RepositoryException if something wrong with repository
   */

  List<? extends Person> query(Specification specification) throws RepositoryException;
}
