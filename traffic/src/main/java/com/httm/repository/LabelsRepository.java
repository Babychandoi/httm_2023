package com.httm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.httm.entity.LabelsEntity;
public interface LabelsRepository extends JpaRepository<LabelsEntity,Long> {
	LabelsEntity findOneByName(String name);
}
