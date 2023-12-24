package by.kovalski.studentinformationsystem.entity;

import by.kovalski.studentinformationsystem.util.IdGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;

public class EntityTest {
  @Test
  void getInfoTest() {
    Person student = new Student(IdGenerator.getId(),"Some Name", Faculty.FIB, "someemail@gmail.com", "8-888-888-88-88", new ArrayList<>(Arrays.asList(Disciplines.MATH, Disciplines.HISTORY)), "g1");
    Person lecturer = new Lecturer(IdGenerator.getId(),"Some Name", Faculty.FIB, "someemail@gmail.com", "8-888-888-88-88", Disciplines.HISTORY, AcademicDegree.MASTER);
    Person administrator = new Administrator(IdGenerator.getId(),"Some Name", Faculty.FIB, "someemail@gmail.com", "8-888-888-88-88",111);
    String expected1 = "I'm student with name Some Name, from group g1, learning disciplines [MATH, HISTORY]";
    String expected2 = "I'm lecturer with name Some Name, My discipline is HISTORY, My academic degree is MASTER";
    String expected3 = "I'm administrator with name Some Name, from faculty FIB, from office 111";
    Assertions.assertEquals(expected1,student.getPersonInformation());
    Assertions.assertEquals(expected2, lecturer.getPersonInformation());
    Assertions.assertEquals(expected3,administrator.getPersonInformation());
  }
}
