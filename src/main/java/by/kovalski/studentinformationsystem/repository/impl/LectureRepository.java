package by.kovalski.studentinformationsystem.repository.impl;

import by.kovalski.studentinformationsystem.entity.Lecturer;
import by.kovalski.studentinformationsystem.entity.Person;
import by.kovalski.studentinformationsystem.exception.RepositoryException;
import by.kovalski.studentinformationsystem.repository.Repository;
import by.kovalski.studentinformationsystem.repository.specification.Specification;

import java.util.HashSet;
import java.util.List;

public class LectureRepository implements Repository {
  private static LectureRepository instance;
  private HashSet<Lecturer> data;

  private LectureRepository() {

  }

  public static LectureRepository getInstance() {
    if (instance == null) {
      instance = new LectureRepository();
      instance.data = new HashSet<>();
    }
    return instance;
  }

  /**
   *
   * @param person - any person
   * @throws RepositoryException if person is not correct
   */

  @Override
  public void addPerson(Person person) throws RepositoryException {
    if (person == null)
      throw new RepositoryException();
    if (person.getClass() != Lecturer.class)
      throw new RepositoryException("Not correct type of an object");
    Lecturer lecturer = (Lecturer) person;
    if (!data.add(lecturer))
      throw new RepositoryException("Can not add lecturer " + lecturer.getName());
  }

  /**
   *
   * @param person - any person
   * @throws RepositoryException if person is not correct
   */

  @Override
  public void removePerson(Person person) throws RepositoryException {
    if (person.getClass() != Lecturer.class)
      throw new RepositoryException("Not correct type of an object");
    Lecturer lecturer = (Lecturer) person;
    if (!data.remove(person))
      throw new RepositoryException("Can not remove lecturer " + lecturer.getName());
  }

  /**
   *
   * @param person - any person
   * @throws RepositoryException if person does not exist
   */

  @Override
  public void updatePerson(Person person) throws RepositoryException {
    if (person.getClass() != Lecturer.class)
      throw new RepositoryException("Not correct type of an object");
    Lecturer lecturer = (Lecturer) person;
    List<Lecturer> found = data.stream().filter(o -> o.getId() == person.getId()).toList();
    if (found.size() != 1)
      throw new RepositoryException("Error in repository data or person with id " + person.getId() + " does not exists");
    data.remove(found.get(0));
    data.add(lecturer);
  }

  /**
   *
   * @param specification - any specification
   * @return list of Lecturers from data that specified to specification
   */

  @Override
  public List<Lecturer> query(Specification specification) {
    return data.stream().filter(o -> specification.specified(o)).toList();
  }
}
