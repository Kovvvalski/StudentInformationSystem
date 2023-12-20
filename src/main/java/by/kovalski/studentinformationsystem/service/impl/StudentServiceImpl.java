package by.kovalski.studentinformationsystem.service.impl;

import by.kovalski.studentinformationsystem.entity.Disciplines;
import by.kovalski.studentinformationsystem.entity.Student;
import by.kovalski.studentinformationsystem.exception.ServiceException;
import by.kovalski.studentinformationsystem.service.StudentService;

import java.util.ArrayList;
import java.util.Collection;

public class StudentServiceImpl implements StudentService {
  /**
   * @param student - any student
   * @return average mark of all disciplines
   */
  @Override
  public double countAverageMark(Student student) {
    Collection<ArrayList<Integer>> marks = student.getMarks().values();
    int counter = 0;
    int valueCounter = 0;
    for (ArrayList<Integer> subj : marks) {
      for (Integer i : subj)
        valueCounter += i;
      counter += subj.size();
    }
    if (valueCounter != 0)
      return (double) valueCounter / counter;
    return 0;
  }

  /**
   * @param student    - any student
   * @param discipline - discipline to count average mark of
   * @return average mark by current discipline
   * @throws ServiceException if student does not have this discipline
   */

  @Override
  public double countAverageMarkByDiscipline(Student student, Disciplines discipline) throws ServiceException {
    ArrayList<Integer> marks = student.getMarks().get(discipline);
    if (marks == null)
      throw new ServiceException("The student with id " + student.getId() + " has not any marks on subject " + discipline);
    int counter = 0;
    for (Integer mark : marks)
      counter += mark;
    if (counter != 0)
      return (double) counter / marks.size();
    return 0;
  }
}
