package com.theresourceroom.api.service.school;

import com.theresourceroom.api.models.School;

import java.util.List;

public interface SchoolService {

    List<School> getAllSchools();

    School getSchoolById(int id);

    School getSchoolByNcesNumber(String nces_number);

    int addSchool(String name, String street_address, String city, String state, String zipcode, String country, String nces_number, String code_hash);

    int updateSchool(String name, String street_address, String city, String state, String zipcode, String country, String nces_number, String code_hash, int id);

    int deleteSchool(int id);

}
