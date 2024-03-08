package com.github.computerhuis.dco.repository;

import com.github.computerhuis.dco.repository.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
