package com.theresourceroom.api.service.license;

import com.theresourceroom.api.dal.dao.LicenseDAO;
import com.theresourceroom.api.models.License;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

public class LicenseServiceWebImpl implements LicenseService {

    private LicenseDAO licenseDAO;

    public LicenseServiceWebImpl(LicenseDAO licenseDAO) {
        this.licenseDAO = licenseDAO;
    }

    @Override
    public List<License> getLicenses() {
        return licenseDAO.getLicenses();
    }

    @Override
    public List<License> getLicensesForRoleFromSchool(String role, int school_id) {
        role = role.strip().toUpperCase();
        if(school_id < 1 || !role.matches("TEACHER") || !role.matches("ADMIN") || !role.matches("STUDENT") || !role.matches("PARENT")) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return licenseDAO.getLicensesForRoleFromSchool(role, school_id);
    }

    @Override
    public License getLicenseByNum(int num) {
        if(num < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return licenseDAO.getLicenseByNum(num);
    }

    @Override
    public int createLicense(int purchased_by, String role) {
        role = role.strip().toUpperCase();
        if(purchased_by < 1 && (role.matches("TEACHER") || role.matches("ADMIN") || role.matches("STUDENT") || role.matches("PARENT")) ) {
            System.out.println(role);
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return licenseDAO.createLicense(purchased_by, role);
    }

    @Override
    public License getUnusedLicenseForRole(int school, String role) {
        role = role.strip().toUpperCase();
        if(school < 1 && (role.matches("TEACHER") || role.matches("ADMIN") || role.matches("STUDENT") || role.matches("PARENT")) ) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return licenseDAO.getUnusedLicenseForRole(school, role);
    }

    @Override
    public boolean cancelLicense(int num) {
        if(num < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return (licenseDAO.cancelLicense(num) == 1);
    }
}
