package by.kovalski.studentinformationsystem.repository;

import by.kovalski.studentinformationsystem.entity.*;
import by.kovalski.studentinformationsystem.exception.RepositoryException;
import by.kovalski.studentinformationsystem.repository.impl.RepositoryImpl;
import by.kovalski.studentinformationsystem.repository.specification.NameSpecification;
import by.kovalski.studentinformationsystem.repository.specification.lecturerspeciicationimpl.AcademicDegreeSpecification;
import by.kovalski.studentinformationsystem.repository.specification.lecturerspeciicationimpl.DisciplineSpecification;
import by.kovalski.studentinformationsystem.repository.specification.studentspecificationimpl.AverageMarkSpecificationLess;
import by.kovalski.studentinformationsystem.repository.specification.studentspecificationimpl.AverageMarkSpecificationMore;
import by.kovalski.studentinformationsystem.repository.specification.studentspecificationimpl.GroupSpecification;
import by.kovalski.studentinformationsystem.util.IdGenerator;
import by.kovalski.studentinformationsystem.warehouse.Warehouse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RepositoryTest {
  private static List<Person> data = new ArrayList<>();

  @BeforeAll
  private static void createTestData() {
    Person lecturer1 = new Lecturer(IdGenerator.getId(), "Name1 Sname1", Faculty.FIB, "someemail@gmail.com", "8-888-888-88-88", Disciplines.HISTORY, AcademicDegree.MASTER);
    Person lecturer2 = new Lecturer(IdGenerator.getId(), "Name2 Sname2", Faculty.FRE, "someemail@gmail.com", "8-888-888-88-88", Disciplines.PROGRAMMING, AcademicDegree.PROFESSOR);
    Person lecturer3 = new Lecturer(IdGenerator.getId(), "Name3 Sname3", Faculty.KSIS, "someemail@gmail.com", "8-888-888-88-88", Disciplines.PHILOSOPHY, AcademicDegree.READER);
    Person lecturer4 = new Lecturer(IdGenerator.getId(), "Name4 Sname4", Faculty.FITU, "someemail@gmail.com", "8-888-888-88-88", Disciplines.PHILOSOPHY, AcademicDegree.MASTER);
    Person student1 = new Student(IdGenerator.getId(), "Name5 Sname5", Faculty.FITU, "someemail@gmail.com", "8-888-888-88-88", Arrays.asList(Disciplines.HISTORY, Disciplines.MATH), "g1");
    Person administrator1 = new Administrator(IdGenerator.getId(), "Name6 Sname6", Faculty.FITU, "someemail@gmail.com", "8-888-888-88-88", 111);

    data.add(lecturer1);
    data.add(lecturer2);
    data.add(lecturer3);
    data.add(lecturer4);
    data.add(student1);
    data.add(administrator1);
  }

  @Test
  void add() {
    RepositoryImpl repository = RepositoryImpl.getInstance();
    for (Person person : data)
      try {
        repository.addPerson(person);
      } catch (RepositoryException e) {
        e.printStackTrace();
      }
    HashSet<Person> persons = repository.getData();
    Assertions.assertTrue(persons.contains(data.get(0)));
    Assertions.assertTrue(persons.contains(data.get(1)));
    Assertions.assertTrue(persons.contains(data.get(2)));
    Assertions.assertTrue(persons.contains(data.get(3)));
    Assertions.assertTrue(persons.contains(data.get(4)));
    Assertions.assertTrue(persons.contains(data.get(5)));
  }

  @Test
  void addNullException() {
    RepositoryImpl repository = RepositoryImpl.getInstance();
    Assertions.assertThrows(RepositoryException.class, () -> repository.addPerson(null));
  }

  @Test
  void addWrongException() {
    RepositoryImpl repository = RepositoryImpl.getInstance();
    Assertions.assertThrows(RepositoryException.class, () -> repository.addPerson(data.get(0)));
  }

  @Test
  void removeTest() {
    RepositoryImpl repository = RepositoryImpl.getInstance();
    try {
      repository.removePerson(data.get(2));
    } catch (RepositoryException e) {
      e.printStackTrace();
    }
    Assertions.assertFalse(repository.getData().contains(data.get(2)));

  }

  @Test
  void removeException() {
    RepositoryImpl repository = RepositoryImpl.getInstance();
    Assertions.assertThrows(RepositoryException.class, () -> repository.removePerson(data.get(2)));
  }

  @Test
  void updatePerson() {
    RepositoryImpl repository = RepositoryImpl.getInstance();
    Person lecturer3 = new Lecturer(6, "Name3 Sname3", Faculty.KSIS, "someemail@gmail.com", "8-888-888-88-88", Disciplines.PHILOSOPHY, AcademicDegree.READER);
    try {
      repository.addPerson(lecturer3);
    } catch (RepositoryException e) {
      e.printStackTrace();
    }
    lecturer3.setName("Some Name");
    try {
      repository.updatePerson(lecturer3);
    } catch (RepositoryException e) {
      e.printStackTrace();
    }
    Assertions.assertTrue(repository.getData().contains(lecturer3));
  }

  @Test
  void updateExceptionTest() {
    RepositoryImpl repository = RepositoryImpl.getInstance();
    Person lecturer3 = new Lecturer(12323, "Name3 Sname3", Faculty.KSIS, "someemail@gmail.com", "8-888-888-88-88", Disciplines.PHILOSOPHY, AcademicDegree.READER);
    Assertions.assertThrows(RepositoryException.class, () -> repository.updatePerson(lecturer3));
  }

  @Test
  void nameQuery() {
    RepositoryImpl repository = RepositoryImpl.getInstance();
    for (Person person : data)
      try {
        repository.addPerson(person);
      } catch (RepositoryException e) {
      }
    Person test = new Lecturer(4, "Name1 Sname1", Faculty.FIB, "someemail@gmail.com", "8-888-888-88-88", Disciplines.HISTORY, AcademicDegree.MASTER);
    Person test1 = new Student(8, "Name5 Sname5", Faculty.FITU, "someemail@gmail.com", "8-888-888-88-88", Arrays.asList(Disciplines.HISTORY, Disciplines.MATH), "g1");
    Person test2 = new Administrator(9, "Name6 Sname6", Faculty.FITU, "someemail@gmail.com", "8-888-888-88-88", 111);
    Person query = repository.query(new NameSpecification("Name1 Sname1")).get(0);
    Person query1 = repository.query(new NameSpecification("Name5 Sname5")).get(0);
    Person query2 = repository.query(new NameSpecification("Name6 Sname6")).get(0);
    Assertions.assertEquals(query, test);
    Assertions.assertEquals(query1, test1);
    Assertions.assertEquals(query2, test2);
  }

  @Test
  void averageMarkLessQuery() {
    RepositoryImpl repository = new RepositoryImpl();
    Student test = new Student(IdGenerator.getId(), "Test Test", Faculty.FITU, "someemail@gmail.com", "8-888-888-88-88", Arrays.asList(Disciplines.HISTORY, Disciplines.MATH), "g1");
    test.takeMark(Disciplines.HISTORY, 6);
    test.takeMark(Disciplines.MATH, 6);
    try {
      repository.addPerson(test);
    } catch (RepositoryException e) {
    }
    Person actual = repository.query(new AverageMarkSpecificationLess(8)).get(0);
    Assertions.assertEquals(test, actual);
    try {
      repository.removePerson(test);
    } catch (RepositoryException e) {

    }
  }

  @Test
  void averageMarkMoreQuery() {
    RepositoryImpl repository = new RepositoryImpl();
    Student test = new Student(IdGenerator.getId(), "Test Test", Faculty.FITU, "someemail@gmail.com", "8-888-888-88-88", Arrays.asList(Disciplines.HISTORY, Disciplines.MATH), "g1");
    test.takeMark(Disciplines.HISTORY, 6);
    test.takeMark(Disciplines.MATH, 6);
    try {
      repository.addPerson(test);
    } catch (RepositoryException e) {
    }
    Warehouse warehouse = Warehouse.getInstance();
    Person actual = repository.query(new AverageMarkSpecificationMore(5)).get(0);
    Assertions.assertEquals(test, actual);
    try {
      repository.removePerson(test);
    } catch (RepositoryException e) {
    }
  }

  @Test
  void groupQuery() {
    RepositoryImpl repository = new RepositoryImpl();
    Student test = new Student(IdGenerator.getId(), "Test Test", Faculty.FITU, "someemail@gmail.com", "8-888-888-88-88", Arrays.asList(Disciplines.HISTORY, Disciplines.MATH), "g1");
    try {
      repository.addPerson(test);
    } catch (RepositoryException e) {
    }
    Person actual = repository.query(new GroupSpecification("g1")).get(0);
    Assertions.assertEquals(test, actual);
    try {
      repository.removePerson(test);
    } catch (RepositoryException e) {
    }
  }

  @Test
  void academicDegreeQuery() {
    RepositoryImpl repository = new RepositoryImpl();
    Lecturer test = new Lecturer(IdGenerator.getId(), "Test Test", Faculty.FITU, "someemail@gmail.com", "8-888-888-88-88", Disciplines.HISTORY, AcademicDegree.MASTER);
    try {
      repository.addPerson(test);
    } catch (RepositoryException e) {
    }
    Person actual = repository.query(new AcademicDegreeSpecification(AcademicDegree.MASTER)).get(0);
    Assertions.assertEquals(test, actual);
    try {
      repository.removePerson(test);
    } catch (RepositoryException e) {
    }
  }

  @Test
  void disciplineSpecification() {
    RepositoryImpl repository = new RepositoryImpl();
    Lecturer test = new Lecturer(IdGenerator.getId(), "Test Test", Faculty.FITU, "someemail@gmail.com", "8-888-888-88-88", Disciplines.HISTORY, AcademicDegree.MASTER);
    try {
      repository.addPerson(test);
    } catch (RepositoryException e) {
    }
    Person actual = repository.query(new DisciplineSpecification(Disciplines.HISTORY)).get(0);
    Assertions.assertEquals(test, actual);
    try {
      repository.removePerson(test);
    } catch (RepositoryException e) {
    }
  }
}
