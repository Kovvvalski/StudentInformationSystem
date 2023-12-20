package by.kovalski.studentinformationsystem.observer;

import by.kovalski.studentinformationsystem.entity.Student;
@FunctionalInterface
public interface StudentObserver {
  void changeStudentStatistics(Student student);
}
