package by.kovalski.studentinformationsystem.service;

import by.kovalski.studentinformationsystem.entity.Disciplines;
import by.kovalski.studentinformationsystem.entity.Faculty;
import by.kovalski.studentinformationsystem.entity.Person;
import by.kovalski.studentinformationsystem.entity.Student;
import by.kovalski.studentinformationsystem.exception.ServiceException;
import by.kovalski.studentinformationsystem.service.impl.StudentServiceImpl;
import by.kovalski.studentinformationsystem.util.IdGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceTest {
  @Test
  void countAverageMarkByDiscipline() {
    Student test = new Student(IdGenerator.getId(), "Test Test", Faculty.FITU, "someemail@gmail.com", "8-888-888-88-88", Arrays.asList(Disciplines.HISTORY, Disciplines.MATH), "g1");
    test.takeMark(Disciplines.HISTORY, 6);
    test.takeMark(Disciplines.MATH, 6);
    StudentService service = new StudentServiceImpl();
    try {
      Assertions.assertEquals(6.0, service.countAverageMarkByDiscipline(test, Disciplines.HISTORY));
    } catch (ServiceException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  void countAverageMarkByDisciplineException() {
    Student test = new Student(IdGenerator.getId(), "Test Test", Faculty.FITU, "someemail@gmail.com", "8-888-888-88-88", Arrays.asList(Disciplines.HISTORY, Disciplines.MATH), "g1");
    StudentService service = new StudentServiceImpl();
    Assertions.assertThrows(ServiceException.class, () -> service.countAverageMarkByDiscipline(test, Disciplines.OPERATING_SYSTEMS));
  }

  @Test
  void sortByName(){
    Student test = new Student(IdGenerator.getId(), "A B", Faculty.FITU, "someemail@gmail.com", "8-888-888-88-88", Arrays.asList(Disciplines.HISTORY, Disciplines.MATH), "g1");
    Student test1 = new Student(IdGenerator.getId(), "B B", Faculty.FITU, "someemail@gmail.com", "8-888-888-88-88", Arrays.asList(Disciplines.HISTORY, Disciplines.MATH), "g1");
    List<Student> testList = new ArrayList<>();
    testList.add(test1);
    testList.add(test);
    new StudentServiceImpl().sortByCondition(testList,Condition.NAME);
    Assertions.assertEquals(test,testList.get(0));
    Assertions.assertEquals(test1,testList.get(1));
  }

  @Test
  void sortByAverageMark(){
    Student test = new Student(IdGenerator.getId(), "A B", Faculty.FITU, "someemail@gmail.com", "8-888-888-88-88", Arrays.asList(Disciplines.HISTORY, Disciplines.MATH), "g1");
    Student test1 = new Student(IdGenerator.getId(), "B B", Faculty.FITU, "someemail@gmail.com", "8-888-888-88-88", Arrays.asList(Disciplines.HISTORY, Disciplines.MATH), "g1");
    List<Student> testList = new ArrayList<>();
    testList.add(test1);
    testList.add(test);
    test.takeMark(Disciplines.HISTORY,5);
    test1.takeMark(Disciplines.HISTORY,6);
    new StudentServiceImpl().sortByCondition(testList,Condition.AVERAGE_MARK);
    Assertions.assertEquals(test,testList.get(0));
    Assertions.assertEquals(test1,testList.get(1));
  }

  @Test
  void sortByGroup(){
    Student test = new Student(IdGenerator.getId(), "A B", Faculty.FITU, "someemail@gmail.com", "8-888-888-88-88", Arrays.asList(Disciplines.HISTORY, Disciplines.MATH), "a");
    Student test1 = new Student(IdGenerator.getId(), "B B", Faculty.FITU, "someemail@gmail.com", "8-888-888-88-88", Arrays.asList(Disciplines.HISTORY, Disciplines.MATH), "b");
    List<Student> testList = new ArrayList<>();
    testList.add(test1);
    testList.add(test);
    new StudentServiceImpl().sortByCondition(testList,Condition.GROUP);
    Assertions.assertEquals(test,testList.get(0));
    Assertions.assertEquals(test1,testList.get(1));
  }


}
