package com.theresourceroom.api.service.school;

import com.theresourceroom.api.dal.dao.SchoolDAO;
import com.theresourceroom.api.models.School;

import java.util.List;

public class SchoolServiceWebImpl implements SchoolService {

    private SchoolDAO schoolDAO;

    public SchoolServiceWebImpl(SchoolDAO schoolDAO) {
        this.schoolDAO = schoolDAO;
    }

    @Override
    public List<School> getAllSchools() {
        return schoolDAO.getAllSchools();
    }

    @Override
    public School getSchoolById(int id) {
        return schoolDAO.getSchoolById(id);
    }

    @Override
    public School getSchoolByNcesNumber(String nces_number) {
        return schoolDAO.getSchoolByNcesNumber(nces_number);
    }

    @Override
    public int addSchool(String name, String street_address, String city, String state, String zipcode, String country, String nces_number, String code_hash) {
        return schoolDAO.addSchool(name, street_address, city, state, zipcode, country, nces_number, code_hash);
    }

    @Override
    public int updateSchool(String name, String street_address, String city,  String state, String zipcode, String country, String nces_number, String code_hash, int id) {
        return schoolDAO.updateSchool(name, street_address, city, zipcode, country, nces_number, code_hash, id);
    }

    @Override
    public int deleteSchool(int id) {
        return schoolDAO.deleteSchool(id);
    }
}
