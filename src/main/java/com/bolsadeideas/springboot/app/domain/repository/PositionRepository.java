package com.bolsadeideas.springboot.app.domain.repository;

import com.bolsadeideas.springboot.app.domain.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {

    Boolean existsByNameIgnoreCaseContaining(String name);

    Position findByNameIgnoreCaseContaining(String name);

}
