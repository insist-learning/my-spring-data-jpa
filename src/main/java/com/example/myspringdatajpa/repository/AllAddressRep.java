
package com.example.myspringdatajpa.repository;
import com.example.myspringdatajpa.common.R;
import com.example.myspringdatajpa.entity.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.Repository;
import org.springframework.data.util.Streamable;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;

import javax.persistence.QueryHint;
import java.util.List;

public interface AllAddressRep  extends Repository<Address,Long> {
    Streamable<Address> findAll();

    R<Address> findAllById(Long id);

    @NonNull
    Address findById(Long id);

    List<Address> myfindAll();

    @Query("select a from Address a where a.id = ?#{[0]}")
    Address myFindById(Long id);

    @QueryHints(value = { @QueryHint(name = "name", value = "value")},forCounting = false)
    Page<Address> findByName(String name, Pageable pageable);

}
