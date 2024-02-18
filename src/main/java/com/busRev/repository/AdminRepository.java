package com.busRev.repository;

import com.busRev.model.Admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
//    public Admin findByEmail(String email);
	List<Admin> findByEmail(String email);
    
}
