package com.springboot.crudoperation.repository;

import com.springboot.crudoperation.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School,Long> {
    Optional<School> findByIdAndIsDeleted(Long id, int isDeleted);
}
