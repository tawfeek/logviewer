package com.log.loggitor.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.log.loggitor.domain.App;

public interface AppRepository extends CrudRepository<App, Long>{
List<App> findAll();
}
