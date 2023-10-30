package com.httm.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.httm.entity.CoordinatesEntity;
public interface CoorReqository extends JpaRepository<CoordinatesEntity,Long> {
}
