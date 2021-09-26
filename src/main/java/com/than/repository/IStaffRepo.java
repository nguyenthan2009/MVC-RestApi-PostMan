package com.than.repository;

import com.than.model.Staff;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStaffRepo extends PagingAndSortingRepository<Staff,Long> {
    Iterable<Staff> findAllByNameContaining(String name);
}
