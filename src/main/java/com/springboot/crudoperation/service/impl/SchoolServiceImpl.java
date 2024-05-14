package com.springboot.crudoperation.service.impl;

import com.springboot.crudoperation.entity.School;
import com.springboot.crudoperation.exception.DataNotFoundException;
import com.springboot.crudoperation.mapper.SchoolMapper;
import com.springboot.crudoperation.model.ResponseDto;
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
import java.util.Optional;

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
    public SchoolDto updateSchool(SchoolDto schoolDto) {
        Optional<School> optionalData = schoolRepository.findByIdAndIsDeleted(schoolDto.getId(),0);
        if(optionalData.isPresent()) {
            School school = optionalData.get();
            if(!schoolDto.getName().isEmpty())
            school.setName(schoolDto.getName());

            school.setUpdatedBy("Admin");
            school.setUpdatedDate(Date.valueOf(LocalDate.now()));
            schoolRepository.save(school);
            return SchoolMapper.maptoSchoolDto(school);
        }else
            throw new DataNotFoundException("Record not found!");
    }

    @Override
    public SchoolDto findSchoolById(int schoolId) {
          Optional<School> optionalData = schoolRepository.findByIdAndIsDeleted((long) schoolId,0);
        if(optionalData.isPresent()) {
            return SchoolMapper.maptoSchoolDto(optionalData.get());
        }else
            throw new DataNotFoundException("Record not found!");

    }

    @Override
    public void deleteSchool(int schoolId) {
        // check where schoold exist or not  if exsit then delete else throw error
        Optional<School> optionalData = schoolRepository.findByIdAndIsDeleted((long) schoolId,0);
        if(optionalData.isPresent())
        {
            School school = optionalData.get();
            school.setIsDeleted(1);
            schoolRepository.save(school);
        }else
            throw new DataNotFoundException("Record not found!");

    }
}
