package by.kovalski.studentinformationsystem.repository.impl;

import by.kovalski.studentinformationsystem.entity.Lecturer;
import by.kovalski.studentinformationsystem.entity.Person;
import by.kovalski.studentinformationsystem.entity.Student;
import by.kovalski.studentinformationsystem.exception.RepositoryException;
import by.kovalski.studentinformationsystem.repository.Repository;
import by.kovalski.studentinformationsystem.repository.specification.Specification;

import java.util.HashSet;
import java.util.List;

public class StudentRepository implements Repository {
  private static StudentRepository instance;
  private HashSet<Student> data;

  private StudentRepository() {

  }

  public static StudentRepository getInstance() {
    if (instance == null) {
      instance = new StudentRepository();
      instance.data = new HashSet<>();
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
      throw new RepositoryException();
    if (person.getClass() != Student.class)
      throw new RepositoryException("Not correct type of an object");
    Student student = (Student) person;
    if (!data.add(student))
      throw new RepositoryException("Can not add lecturer " + student.getName());
  }

  /**
   * @param person - any person
   * @throws RepositoryException if person is not correct
   */

  @Override
  public void removePerson(Person person) throws RepositoryException {
    if (person.getClass() != Student.class)
      throw new RepositoryException("Not correct type of an object");
    Student student = (Student) person;
    if (!data.remove(person))
      throw new RepositoryException("Can not remove lecturer " + student.getName());
  }

  /**
   * @param person - any person
   * @throws RepositoryException if person does not exist
   */

  @Override
  public void updatePerson(Person person) throws RepositoryException {
    if (person.getClass() != Student.class)
      throw new RepositoryException("Not correct type of an object");
    Student student = (Student) person;
    List<Student> found = data.stream().filter(o -> o.getId() == person.getId()).toList();
    if (found.size() != 1)
      throw new RepositoryException("Error in repository data or person with id " + person.getId() + " does not exists");
    data.remove(found.get(0));
    data.add(student);
  }

  /**
   * @param specification - any specification
   * @return list of students from data that specified to specification
   */

  @Override
  public List<Student> query(Specification specification) {
    return data.stream().filter(o -> specification.specified(o)).toList();
  }
}
