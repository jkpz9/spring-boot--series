package itus.king.dao.impl;

import itus.king.dao.StudentDao;
import itus.king.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@Repository
@Qualifier("mongoData")
public class MongoStudentDaoImpl implements StudentDao {
    @Override
    public Collection<Student> getAllStudents() {
        return new ArrayList<Student>() {
            {
                add(new Student(1, "Dare Devil", "UI-UX"));
                add(new Student(2, "Captain Marvel", "Javascript ES6"));
                add(new Student(2, "Captain VN", "NodeJS"));
            }
        };
    }

    @Override
    public Student getStudentById(int id) {
       for(Student student : getAllStudents()) {
            if(student.getId() == id)
                return student;
       }
       return null;
    }

    @Override
    public void removeStudentById(int id) {
        Iterator<Student> iter = getAllStudents().iterator();
        while(iter.hasNext()) {
            Student s = iter.next();
            if (s.getId() == id)
            {
                iter.remove();
                break;
            }
        }
    }

    @Override
    public void updateStudent(Student student) {
        Iterator<Student> iter = getAllStudents().iterator();
        while(iter.hasNext()) {
            Student s = iter.next();
            if (s.getId() == student.getId()) {
                s.setCourse(student.getCourse());
                break;
            }
        }
    }

    @Override
    public void insertStudentToDb(Student student) {
        getAllStudents().add(student);
    }
}
