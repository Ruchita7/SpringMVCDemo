package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Person;

public interface PersonDao extends CrudRepository<Person, Integer>{

	List<Person> findByTech(String tech);

	List<Person> findByIdGreaterThan(int i);


	@Query("from Person where tech=?1 order by name")
	List<Person> findByTechSorted(String tech);

}
