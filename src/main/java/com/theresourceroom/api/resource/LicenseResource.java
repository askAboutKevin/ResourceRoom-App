package com.theresourceroom.api.resource;

import com.theresourceroom.api.models.License;
import com.theresourceroom.api.service.license.LicenseService;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/license")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LicenseResource {

    private LicenseService licenseService;

    public LicenseResource(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @GET
    public Response fetchLicenses(@QueryParam("school_id") OptionalInt school_id, @QueryParam("role") Optional<String> role) {

        if (!school_id.isEmpty() && !role.isEmpty()) {
            List<License> licenses = this.licenseService.getLicensesForRoleFromSchool(role.get(), school_id.getAsInt());

            return Response
                    .status(Response.Status.OK)
                    .entity(licenses)
                    .build();
        }
        // ADD SOME LOGIC HERE TO CHECK IF THE USER IS AN ADMIN FOR THE SCHOOL
        return null;
    }

    @GET
    @Path("/{num}")
    public Response fetchLicenseByNum(@PathParam("num") int num) {

        if(num >= 1) {
            License license = this.licenseService.getLicenseByNum(num);

            if (license != null) {
                return Response
                        .status(Response.Status.OK)
                        .entity(license)
                        .build();
            }
         }
        throw new WebApplicationException(Response.Status.BAD_REQUEST);
    }


    @GET
    @Path("/new")
    public Response fetchUnusedLicenseForRole(@QueryParam("school_id") OptionalInt school_id, @QueryParam("role") Optional<String> role) {
        License license = this.licenseService.getUnusedLicenseForRole(school_id.getAsInt(), role.get());
        if(license != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(license)
                    .build();
        }
        throw new WebApplicationException(Response.Status.BAD_REQUEST);
    }

    @POST
    public Response License(License license) {
        Date purchased = license.getPurchased();
        int purchased_by = license.getPurchased_by();
        String role = license.getRole();

        Boolean success = Boolean.FALSE;

        int licenseCreated = this.licenseService.createLicense(purchased, purchased_by, role);

        if(licenseCreated == 1) {
            success = Boolean.TRUE;
        }
        return Response
                .status(Response.Status.OK)
                .entity(success)
                .build();    }


    @DELETE
    @Path("/{num}")
    public Response cancelLicense(@PathParam("num") int num) {
        Boolean success;

        if (num >= 1) {
            success = Boolean.valueOf(this.licenseService.cancelLicense(num));
            return Response
                    .status(Response.Status.OK)
                    .entity(success)
                    .build();
        }
        throw new WebApplicationException(Response.Status.BAD_REQUEST);
    }





}


