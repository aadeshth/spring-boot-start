package com.springboot.crudoperation.contoller;

import com.springboot.crudoperation.model.School;
import com.springboot.crudoperation.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    // NEW Format
   @GetMapping(value = "/school1")
   public School getSchoolDetails1()
   {
       return schoolService.findSchoolById(1);
   }

//    @GetMapping(value = "/school")
//    public ResponseEntity<?> getSchoolDetailsWithResponseEntity()
//    {
//        return  new ResponseEntity<>(schoolService.findSchoolById(1), HttpStatus.FOUND);
//    }
    @GetMapping(value = "/school/{schoolId}")
    public ResponseEntity<?> getSchoolDetailsPath(@PathVariable int schoolId)
    {
        return new ResponseEntity<>(schoolService.findSchoolById(schoolId), HttpStatus.OK);
    }

    @GetMapping(value = "/school")
    public ResponseEntity<?> getSchool(@RequestParam(value = "schoolID" , required = false) int schoolId)
    {
        return new ResponseEntity<>(schoolService.findSchoolById(schoolId), HttpStatus.OK);
    }

   // OLD Format
    @RequestMapping(value = "/school2", method = RequestMethod.GET, produces = "application/json")
    public School getSchoolDetails2()
    {
        return  schoolService.findSchoolById(1);
    }


    @PostMapping("/school")
    public ResponseEntity<?> createSchool(@RequestBody School school)
    {
        return new ResponseEntity<>(schoolService.saveSchool(school), HttpStatus.OK);
    }

    @PutMapping("/school")
    public ResponseEntity<?> updateSchool(@RequestBody School school) throws Exception {
        return new ResponseEntity<>(schoolService.updateSchool(school), HttpStatus.OK);
    }
    @DeleteMapping(value = "/school/{schoolId}")
    public ResponseEntity<?> deleteSchool(@PathVariable int schoolId)
    {
        return new ResponseEntity<>(schoolService.deleteSchool(schoolId), HttpStatus.OK);
    }

}
