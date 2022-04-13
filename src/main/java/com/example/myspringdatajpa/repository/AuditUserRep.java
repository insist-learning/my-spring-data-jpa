package com.example.myspringdatajpa.repository;

import com.example.myspringdatajpa.entity.AuditUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditUserRep extends JpaRepository<AuditUser,Integer> {
}
