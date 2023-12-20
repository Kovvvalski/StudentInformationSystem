package by.kovalski.studentinformationsystem.entity;

import by.kovalski.studentinformationsystem.observer.StudentObserver;
import by.kovalski.studentinformationsystem.service.impl.StudentServiceImpl;
import by.kovalski.studentinformationsystem.warehouse.Warehouse;

import java.util.*;

public class Student extends Person {
  private StudentObserver observer = o -> {
    Warehouse.getInstance().put(o, new StudentServiceImpl().countAverageMark(o));
  };

  /**
   * subset of enum disciplines
   */
  private List<Disciplines> disciplines;
  /**
   * all marks by every discipline
   */
  private final Map<Disciplines, ArrayList<Integer>> marks = new HashMap<>();
  /**
   * course of the student
   */
  private String group;

  /**
   * @param name            - any name
   * @param faculty         - faculty of the student
   * @param email           - valid email of student
   * @param telephoneNumber - valid telephone number
   * @param disciplines     - disciplines
   * @param group           - course of the student
   */
  public Student(String name, Faculty faculty, String email, String telephoneNumber, List<Disciplines> disciplines, String group) {
    super(name, faculty, email, telephoneNumber);
    setDisciplines(disciplines);
    this.group = group;
    notifyObserver();
  }

  /**
   * @return all disciplines
   */

  public List<Disciplines> getDisciplines() {
    return new ArrayList<>(disciplines);
  }

  /**
   * sets copy of disciplines
   *
   * @param disciplines - disciplines
   */

  public void setDisciplines(List<Disciplines> disciplines) {
    this.disciplines = new ArrayList<>(disciplines);
  }

  /**
   * @return copy of map marks
   */

  public Map<Disciplines, ArrayList<Integer>> getMarks() {
    return new HashMap<>(marks);
  }

  /**
   * @return course
   */

  public String getGroup() {
    return group;
  }

  /**
   * @param group - course
   */

  public void setGroup(String group) {
    this.group = group;
  }

  /**
   * @param o - any object
   * @return true if objects are equals
   */

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Student student = (Student) o;
    return group.equals(student.group) && disciplines.equals(student.disciplines) && marks.equals(student.marks);
  }

  /**
   * @return hash code of an objects
   */

  @Override
  public int hashCode() {
    return super.hashCode() + group.hashCode() + disciplines.hashCode() + marks.hashCode();
  }

  /**
   * @param discipline - discipline to set mark
   * @param mark       - mark
   */

  public void takeMark(Disciplines discipline, int mark) {
    marks.get(discipline).add(mark);
    notifyObserver();
  }

  /**
   * @return string of an object
   */

  @Override
  public String toString() {
    return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
            .add(getName())
            .add("disciplines=" + disciplines)
            .add("marks=" + marks)
            .add("group='" + group + "'")
            .toString();
  }

  private void notifyObserver() {
    observer.changeStudentStatistics(this);
  }

}
