package com.theresourceroom.api.dal.dao;

import com.theresourceroom.api.dal.mapper.StudentMapper;
import com.theresourceroom.api.models.Student;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface StudentDAO {

	@SqlQuery("SELECT id, name, teacher, parent, license_used FROM Student")
	@RegisterRowMapper(StudentMapper.class)
	List<Student> getAllStudents();

	@SqlQuery("SELECT id, name, teacher, parent, license_used FROM Student WHERE teacher = ?")
	@RegisterRowMapper(StudentMapper.class)
	Student getStudentsOfTeacher(int teacher_id);

	@SqlQuery("SELECT id, name, teacher, parent, license_used FROM Student WHERE  parent_id = ?")
	@RegisterRowMapper(StudentMapper.class)
	Student getChildrenOfParent(int parent_id);

	@SqlUpdate("INSERT INTO Student (name, teacher, parent) VALUES (?, ?, ?)")
	int addStudent(int parent_id, int teacher_id, String name);

	@SqlUpdate("UPDATE Student SET name = ?, teacher = ?, parent = ? WHERE id = ?")
	int updateStudentInfo(String name, int teacher_id, int parent_id, int id);

	@SqlUpdate("DELETE FROM Student WHERE id = ?")
	int deleteStudent(int student_id);
	
}
