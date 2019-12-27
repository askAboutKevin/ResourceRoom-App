package com.theresourceroom.api.service.student;

import com.theresourceroom.api.models.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentsOfTeacher(int teacher_id);

    Student getChildrenOfParent(int parent_id);

    int addStudent(int parent_id, int teacher_id, String name);

    int updateStudentInfo(String name, int teacher_id, int parent_id, int id);

    int deleteStudent(int student_id);
}
