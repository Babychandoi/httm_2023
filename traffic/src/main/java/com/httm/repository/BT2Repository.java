package com.httm.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.httm.entity.SimpleBT2Entity;

public interface BT2Repository extends JpaRepository<SimpleBT2Entity,Long> {
}
