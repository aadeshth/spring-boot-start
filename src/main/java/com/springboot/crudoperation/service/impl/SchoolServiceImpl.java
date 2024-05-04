package com.springboot.crudoperation.service.impl;

import com.springboot.crudoperation.model.School;
import com.springboot.crudoperation.service.SchoolService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Override
    public School saveSchool(School school) {
        School schoolResponse = school;
            schoolResponse.setId(123);
    return schoolResponse;
    }

    @Override
    public School updateSchool(School school) throws Exception {
        if(school.getId()==0)
            throw new Exception("ID Not exist in request!");
        return school;
    }

    @Override
    public School findSchoolById(int schoolId) {
        School school = new School();
        school.setId(1);
        school.setName("RIS");
        String [] colors= {"RED","BLUE"};
        school.setDressCodeColors(Arrays.asList(colors));
        return school;
    }

    @Override
    public Map deleteSchool(int schoolId) {
      Map<String, Object> mp = new HashMap<>();
      mp.put("id",schoolId);
      mp.put("Message","Deleted!");
      return mp;
    }
}
