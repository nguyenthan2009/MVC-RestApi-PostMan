package com.than.repository;

import com.than.model.Company;
import com.than.model.Staff;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompanyRepo extends PagingAndSortingRepository<Company,Long> {
    Iterable<Company> findAllByNameContaining(String name);
}
