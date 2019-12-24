package com.theresourceroom.api.dal.dao;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.theresourceroom.api.models.Student;

public interface StudentDAO {

	List<Student> getAllStudents();
	
	Student getStudentOfTeahcer(String name, int teacher_id, int parent_id);
	
	Student getStudentOfParent(String name, int parent_id, int teacher_id);
	
	int addStudent(int parent_id, int teacher_id);
	
	List<Student> getStudentsWithTeacher(int teacher_id);
	
	List<Student> getStudentsOfParent(int parent_id);
	
	int deleteStudent(int student_id);
	

}
