package com.theresourceroom.api.dal.dao;

import java.util.Date;
import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.theresourceroom.api.models.License;

public interface LicenseDAO {

	List<License> getLicenses();

	List<License> getLicensesForRoleFromSchool(String role, int school_id);

	License getLicense(int num);
	
	int createLicense(Date purchased, int purchased_by, String role);
	
}
