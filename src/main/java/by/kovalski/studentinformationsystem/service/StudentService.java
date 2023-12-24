package by.kovalski.studentinformationsystem.service;

import by.kovalski.studentinformationsystem.entity.Disciplines;
import by.kovalski.studentinformationsystem.entity.Student;
import by.kovalski.studentinformationsystem.exception.ServiceException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface StudentService {
  /**
   * @param student - any student
   * @return average mrk by all disciplines
   */
  double countAverageMark(Student student);

  /**
   * @param student    - any student
   * @param discipline - discipline to count average mark of
   * @return average mark by current discipline
   * @throws ServiceException if student does not hav this discipline in his schedule
   */
  double countAverageMarkByDiscipline(Student student, Disciplines discipline) throws ServiceException;
  void sortByCondition(List<Student> students, Condition condition);
}
