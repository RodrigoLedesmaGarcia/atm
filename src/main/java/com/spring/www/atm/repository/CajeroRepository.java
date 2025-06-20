package com.spring.www.atm.repository;

import com.spring.www.atm.entity.Cajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CajeroRepository  extends JpaRepository<Cajero, Integer> {
}
