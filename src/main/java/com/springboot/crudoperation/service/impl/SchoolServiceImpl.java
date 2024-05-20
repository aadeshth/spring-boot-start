package com.springboot.crudoperation.service.impl;

import com.springboot.crudoperation.entity.School;
import com.springboot.crudoperation.exception.DataNotFoundException;
import com.springboot.crudoperation.mapper.SchoolMapper;
import com.springboot.crudoperation.model.PageResponse;
import com.springboot.crudoperation.model.SchoolDto;
import com.springboot.crudoperation.model.SearchRequest;
import com.springboot.crudoperation.repository.SchoolRepository;
import com.springboot.crudoperation.service.SchoolService;
import com.springboot.crudoperation.valitation.SchoolDataValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    SchoolRepository schoolRepository;
    @Override
    public SchoolDto saveSchool(SchoolDto schoolDto) {
        SchoolDataValidation.requestValidation(schoolDto);
        School school = SchoolMapper.mapToSchool(schoolDto,"Admin");
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

    @Override
    public List<SchoolDto> findSchoolBySearchText(String searchText) {
        List<School> schools = schoolRepository.findSchoolBySearchText(searchText);
        return schools.stream().map(school -> SchoolMapper.maptoSchoolDto(school)).collect(Collectors.toList());
      /*  List<SchoolDto> schoolDtos = new ArrayList<>();
        for (School school:schools) {
            schoolDtos.add(SchoolMapper.maptoSchoolDto(school));
        }
        return schoolDtos;*/
    }

    @Override
    public PageResponse findAll(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()  : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<School> page = schoolRepository.findAll(pageable);
        List<School> listOfSchool = page.getContent();
        List<SchoolDto> listDto = listOfSchool.stream().map(school -> SchoolMapper.maptoSchoolDto(school)).collect(Collectors.toList());
        PageResponse pageResponse = new PageResponse();
        pageResponse.setListData(listDto);
        pageResponse.setPageNo(page.getNumber());
        pageResponse.setPageSize(page.getSize());
        pageResponse.setTotalPages(page.getTotalPages());
        pageResponse.setLast(page.isLast());
        pageResponse.setTotalRecords(page.getTotalElements());

        return pageResponse;
    }

    @Override
    public PageResponse searchAll(String searchText, int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()  : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<School> page = schoolRepository.findSchoolBySearchTextWithPagination(searchText, pageable);
        List<School> listOfSchool = page.getContent();
        List<SchoolDto> listDto = listOfSchool.stream().map(school -> SchoolMapper.maptoSchoolDto(school)).collect(Collectors.toList());
        PageResponse pageResponse = new PageResponse();
        pageResponse.setListData(listDto);
        pageResponse.setPageNo(page.getNumber());
        pageResponse.setPageSize(page.getSize());
        pageResponse.setTotalPages(page.getTotalPages());
        pageResponse.setLast(page.isLast());
        pageResponse.setTotalRecords(page.getTotalElements());

        return pageResponse;
    }
}
