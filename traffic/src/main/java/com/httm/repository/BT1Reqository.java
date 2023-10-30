package com.httm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.httm.entity.SimpleBT1Entity;

public interface BT1Reqository extends JpaRepository<SimpleBT1Entity,Long> {
}
