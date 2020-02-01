package com.theresourceroom.api.resource;

import com.theresourceroom.api.models.School;
import com.theresourceroom.api.service.school.SchoolService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/school")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SchoolResource {

    private SchoolService schoolService;

    public SchoolResource(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GET
    public Response getAllSchools() {
        List<School> schools = this.schoolService.getAllSchools();

        return Response
                .status(Response.Status.OK)
                .entity(schools)
                .build();
    }

    @GET
    @Path("/{id}")
    public Response getSchoolById(@PathParam("id") int id) {

        School school = this.schoolService.getSchoolById(id);

        return Response
                .status(Response.Status.OK)
                .entity(school)
                .build();
    }

    @GET
    @Path("nces/{nces}")
    public Response getSchoolByNcesNumber(@PathParam("nces") String nces_number) {
        School school = this.schoolService.getSchoolByNcesNumber(nces_number);

        return Response
                .status(Response.Status.OK)
                .entity(school)
                .build();
    }

    @POST
    public Response addSchool(School school) {

        String name = school.getName();
        String street_address = school.getStreet_address();
        String city = school.getCity();
        String state = school.getState();
        String zipcode = school.getZipcode();
        String country = school.getCountry();
        String nces_number = school.getNces_number();
        String code_hash = school.getCode_hash();

        int createdSchool = this.schoolService.addSchool(name, street_address, city, state, zipcode, country, nces_number, code_hash);

        Boolean success = Boolean.FALSE;

        if (createdSchool == 1) {
            success = Boolean.TRUE;
        }
        return Response
                .status(Response.Status.OK)
                .entity(success)
                .build();
    }

    @PUT
    public Response updateSchool(School school) {

        String name = school.getName();
        String street_address = school.getStreet_address();
        String city = school.getCity();
        String state = school.getState();
        String zipcode = school.getZipcode();
        String country = school.getCountry();
        String nces_number = school.getNces_number();
        String code_hash = school.getCode_hash();
        int id = school.getId();

        int updatedSchool = this.schoolService.updateSchool(name, street_address, city, state, zipcode, country, nces_number, code_hash, id);
        Boolean success = Boolean.FALSE;

        if(updatedSchool == 1) {
            success = Boolean.TRUE;
        }

        return Response
                .status(Response.Status.OK)
                .entity("success")
                .build();

    }

    @DELETE
    @Path("/{id}")
    public Response deleteSchool(@PathParam("id") int id) {

        int deletedSchool = this.schoolService.deleteSchool(id);
        Boolean success = Boolean.FALSE;

        if (deletedSchool == 1) {
            success = Boolean.TRUE;
        }
        return Response
                .status(Response.Status.OK)
                .entity(success)
                .build();
    }






}
