package com.example.myspringdatajpa.repository;

import com.example.myspringdatajpa.entity.User;
import com.example.myspringdatajpa.entity.UserAddress;
import com.example.myspringdatajpa.repository.model.NamesOnly;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public interface UserRep extends CrudRepository<User,Long>, QueryByExampleExecutor<User> ,JpaSpecificationExecutor<User> {
    <T> T findProjectedById(Long id, Class<T> projection);
}
