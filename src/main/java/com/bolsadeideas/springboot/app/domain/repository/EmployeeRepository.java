package com.bolsadeideas.springboot.app.domain.repository;

import com.bolsadeideas.springboot.app.domain.entities.Employee;
import com.bolsadeideas.springboot.app.domain.entities.Position;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByPositionAndPersonNameIgnoreCaseContaining(Position position, String name);

    List<Employee> findByPosition(Position position);

    List<Employee> findByPersonNameIgnoreCaseContaining(String name);

    Boolean existsByPersonId(Long personId);

}
