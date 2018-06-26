package itus.king.dao.impl;

import itus.king.dao.StudentDao;
import itus.king.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Collection;

@Repository
@Qualifier("fakeData")
public class FakeStudentDaoImpl implements StudentDao {

    private static HashMap<Integer, Student> students;

    static {

        students = new HashMap<Integer, Student>(){

            {
                put(1, new Student(1, "Jimmy JR", "Spring Boot"));
                put(2, new Student(2, "Jessica Jones", "Java Fx"));
                put(3, new Student(3, "King Pham", "Design Patterns"));
            }
        };
    }

    @Override
    public Collection<Student> getAllStudents() {
        return students.values();
    }

    @Override
    public Student getStudentById(int id) {
        return students.get(id);
    }

    @Override
    public void removeStudentById(int id) {
        students.remove(id);
    }

    @Override
    public void updateStudent(Student student) {
        Student target = students.get(student.getId());
        target.setCourse(student.getCourse());
        students.put(student.getId(), target);
    }

    @Override
    public void insertStudentToDb(Student student) {
        students.put(student.getId(), student);
    }
}
