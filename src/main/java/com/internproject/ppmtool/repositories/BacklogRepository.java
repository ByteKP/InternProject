package com.internproject.ppmtool.repositories;

import com.internproject.ppmtool.domain.Backlog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogRepository extends CrudRepository<Backlog, Long> {

}