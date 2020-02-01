package com.theresourceroom.api.service.license;

import com.theresourceroom.api.models.License;

import java.util.Date;
import java.util.List;

public interface LicenseService {

    List<License> getLicenses();

    List<License> getLicensesForRoleFromSchool(String role, int school_id);

    License getLicenseByNum(int num);

    int createLicense(int purchased_by, String role);

    License getUnusedLicenseForRole(int school, String role);

    boolean cancelLicense(int num);
}
