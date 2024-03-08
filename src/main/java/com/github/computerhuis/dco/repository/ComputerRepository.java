package com.github.computerhuis.dco.repository;

import com.github.computerhuis.dco.repository.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {

}
