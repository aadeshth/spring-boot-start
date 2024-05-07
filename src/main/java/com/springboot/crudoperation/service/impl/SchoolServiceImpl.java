package com.springboot.crudoperation.service.impl;

import com.springboot.crudoperation.model.SchoolDto;
import com.springboot.crudoperation.service.SchoolService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Override
    public SchoolDto saveSchool(SchoolDto schoolDto) {
        SchoolDto schoolDtoResponse = schoolDto;
            schoolDtoResponse.setId(123);
    return schoolDtoResponse;
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
        schoolDto.setId(1);
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
