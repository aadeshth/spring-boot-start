package com.springboot.crudoperation.service.impl;

import com.springboot.crudoperation.entity.School;
import com.springboot.crudoperation.model.SchoolDto;
import com.springboot.crudoperation.repository.SchoolRepository;
import com.springboot.crudoperation.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    SchoolRepository schoolRepository;
    @Override
    public SchoolDto saveSchool(SchoolDto schoolDto) {
        School school = new School();
        school.setName(schoolDto.getName());
        school.setAddress(schoolDto.getName());
        school.setDressCodeColors(schoolDto.getDressCodeColors());
        school.setCreatedBy("Admin");
        school.setCreatedDate(Date.valueOf(LocalDate.now()));
        schoolRepository.save(school);
        schoolDto.setId(school.getId());
    return schoolDto;
    }

    @Override
    public SchoolDto updateSchool(SchoolDto schoolDto) throws Exception {
        if(schoolDto.getId()==0)
            throw new Exception("ID Not exist in request!");
        return schoolDto;
    }

    @Override
    public SchoolDto findSchoolById(int schoolId) {
        SchoolDto schoolDto = new SchoolDto();
        schoolDto.setId(1L);
        schoolDto.setName("RIS");
        String [] colors= {"RED","BLUE"};
        schoolDto.setDressCodeColors(Arrays.asList(colors));
        return schoolDto;
    }

    @Override
    public Map deleteSchool(int schoolId) {
      Map<String, Object> mp = new HashMap<>();
      mp.put("id",schoolId);
      mp.put("Message","Deleted!");

      return mp;
    }
}
