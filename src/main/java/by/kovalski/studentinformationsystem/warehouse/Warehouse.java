package by.kovalski.studentinformationsystem.warehouse;

import by.kovalski.studentinformationsystem.entity.Student;

import java.util.HashMap;
import java.util.Map;

/**
 * class that contains all statistics about students
 */
public class Warehouse {
  private static Warehouse instance;
  private final Map<Student, Double> studentsStatistics = new HashMap<>();

  private Warehouse() {

  }

  public static synchronized Warehouse getInstance() {
    if (instance == null)
      instance = new Warehouse();
    return instance;
  }

  public Double put(Student key, Double value) {
    return studentsStatistics.put(key, value);
  }

  public Double get(Student student) {
    return studentsStatistics.get(student);
  }

}
