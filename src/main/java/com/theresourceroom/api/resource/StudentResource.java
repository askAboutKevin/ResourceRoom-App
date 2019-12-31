package com.theresourceroom.api.resource;


import com.theresourceroom.api.models.Student;
import com.theresourceroom.api.service.student.StudentService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {

    private StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GET
    public Response fetchAllStudents() {

        List<Student> students = this.studentService.getAllStudents();

        if (students != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(students)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @GET
    @Path("teacher/{id}")
    public Response fetchStudentsOfTeacher(@PathParam("id") int id) {

        Student students = this.studentService.getStudentsOfTeacher(id);

        if (students != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(students)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @GET
    @Path("parent/{id}")
    public Response fetchStudentsOfParent(@PathParam("id") int id) {

        Student students = this.studentService.getChildrenOfParent(id);

        if (students != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(students)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @POST
    public Response createStudent(Student student) {

        int parent_id = student.getParent();
        int teacher_id = student.getTeacher();
        String name = student.getName();

        Student studentsAdded = this.studentService.addStudent(parent_id, teacher_id, name);

        Boolean success = Boolean.FALSE;

        if( studentsAdded != null ) {
            success = Boolean.TRUE;
        }

        return Response
                .status(Response.Status.OK)
                .entity(studentsAdded)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateStudentInfo(Student student, @PathParam("id") int id) {

        int parent_id = student.getParent();
        int teacher_id = student.getTeacher();
        String name = student.getName();

        int studentsUpdated = this.studentService.updateStudentInfo(name, teacher_id, parent_id, id);

        Boolean success = Boolean.FALSE;

        if( studentsUpdated == 1 ) {
            success = Boolean.TRUE;
        }

        return Response
                .status(Response.Status.OK)
                .entity(success)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteStudent(@PathParam("id") int id) {

        Boolean success = Boolean.FALSE;

        int deletedStudent = this.studentService.deleteStudent(id);

        if( deletedStudent == 1 ) {
            success = Boolean.TRUE;
        }

        return Response
                .status(Response.Status.OK)
                .entity(success)
                .build();
    }

}
