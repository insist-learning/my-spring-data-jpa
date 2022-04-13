package com.example.myspringdatajpa.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

@NoRepositoryBean
public interface MyPageRep<T,ID> extends PagingAndSortingRepository<T,ID> {
    Optional<T> findById(ID id);
}
