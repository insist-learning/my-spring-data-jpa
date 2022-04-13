package com.example.myspringdatajpa.repository;

import com.example.myspringdatajpa.entity.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.util.Streamable;

public interface AddresssRep extends JpaRepository<Address,Long> {
}
