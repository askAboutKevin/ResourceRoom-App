package com.theresourceroom.api.service.license;

import com.theresourceroom.api.dal.dao.LicenseDAO;
import com.theresourceroom.api.models.License;

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
        return licenseDAO.getLicensesForRoleFromSchool(role, school_id);
    }

    @Override
    public License getLicenseByNum(int num) {
        return licenseDAO.getLicenseByNum(num);
    }

    @Override
    public int createLicense(Date purchased, int purchased_by, String role) {
        return licenseDAO.createLicense(purchased, purchased_by, role);
    }

    @Override
    public License getUnusedLicenseForRole(int school, String role) {
        return licenseDAO.getUnusedLicenseForRole(school, role);
    }

    @Override
    public int cancelLicense(int num) {
        return licenseDAO.cancelLicense(num);
    }
}
