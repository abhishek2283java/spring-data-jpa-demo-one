package org.abhishek.om.spring.data.jpa.demo.one.repository;

import org.abhishek.om.spring.data.jpa.demo.one.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
