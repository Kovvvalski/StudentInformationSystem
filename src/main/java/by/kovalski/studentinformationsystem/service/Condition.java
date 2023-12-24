package by.kovalski.studentinformationsystem.service;

import by.kovalski.studentinformationsystem.entity.Student;
import by.kovalski.studentinformationsystem.warehouse.Warehouse;

import java.util.Comparator;

public enum Condition {
  AVERAGE_MARK {
    @Override
    public Comparator<Student> getComparator() {
      return (o1, o2) -> Warehouse.getInstance().get(o1).intValue() - Warehouse.getInstance().get(o2).intValue();
    }

  }, GROUP {
    @Override
    public Comparator<Student> getComparator() {
      return (o1, o2) -> o1.getGroup().compareTo(o2.getGroup());
    }
  }, NAME {
    @Override
    public Comparator<Student> getComparator() {
      return (o1, o2) -> o1.getName().compareTo(o2.getName());
    }
  };

  public abstract Comparator<Student> getComparator();
}
