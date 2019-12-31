package com.theresourceroom.api.service.student;

import com.theresourceroom.api.dal.dao.StudentDAO;
import com.theresourceroom.api.models.Student;

import java.util.List;

public class StudentServiceWebImpl implements  StudentService {

    private StudentDAO studentDAO;

    public StudentServiceWebImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    public Student getStudentsOfTeacher(int teacher_id) {
        return studentDAO.getStudentsOfTeacher(teacher_id);
    }

    @Override
    public Student getChildrenOfParent(int parent_id) {
        return studentDAO.getChildrenOfParent(parent_id);
    }

    @Override
    public Student addStudent(int parent_id, int teacher_id, String name) {
        return studentDAO.addStudent(parent_id, teacher_id, name);
    }

    @Override
    public int updateStudentInfo(String name, int teacher_id, int parent_id, int id) {
        return studentDAO.updateStudentInfo(name, teacher_id, parent_id, id);
    }

    @Override
    public int deleteStudent(int student_id) {
        return studentDAO.deleteStudent(student_id);
    }
}
