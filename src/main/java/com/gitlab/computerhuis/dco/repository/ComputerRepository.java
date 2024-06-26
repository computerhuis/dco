package com.gitlab.computerhuis.dco.repository;

import com.gitlab.computerhuis.dco.repository.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {

}
