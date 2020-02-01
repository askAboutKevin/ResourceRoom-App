package com.theresourceroom.api.dal.dao;

import java.util.Date;
import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.theresourceroom.api.dal.mapper.LicenceMapper;
import com.theresourceroom.api.models.License;


public interface LicenseDAO {

	@SqlQuery("SELECT num, purchased, expires, purchased_by, role FROM License")
	@RegisterRowMapper(LicenceMapper.class)
	List<License> getLicenses();
	
	@SqlQuery("SELECT num, purchased, expires, purchased_by, role FROM License WHERE role = ? AND purchased_by = ?")
	@RegisterRowMapper(LicenceMapper.class)
	List<License> getLicensesForRoleFromSchool(String role, int school_id);

	@SqlQuery("SELECT num, purchased, expires, purchased_by, role FROM License WHERE num = ?")
	@RegisterRowMapper(LicenceMapper.class)
	License getLicenseByNum(int num);
	
	@SqlUpdate("INSERT INTO License(purchased, purchased_by, role) VALUES (CURRENT_TIMESTAMP(), ?, ?)")
	int createLicense(int purchased_by, String role);

	@SqlQuery("SELECT num, purchased, expires, purchased_by, role FROM License WHERE purchased_by = ? AND role = ? AND num NOT IN (SELECT license_used FROM User) LIMIT 15")
	@RegisterRowMapper(LicenceMapper.class)
	License getUnusedLicenseForRole(int school, String role);

	@SqlUpdate("UPDATE License SET expires = CURRENT_TIMESTAMP() WHERE num = ?")
	int cancelLicense(int num);
}