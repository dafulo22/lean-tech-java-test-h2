package com.bolsadeideas.springboot.app.domain.repository;

import com.bolsadeideas.springboot.app.domain.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
