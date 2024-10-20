package com.gitlab.computerhuis.dco.repository;

import com.gitlab.computerhuis.dco.repository.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
