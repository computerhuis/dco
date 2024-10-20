package com.gitlab.computerhuis.dco.repository;

import com.gitlab.computerhuis.dco.repository.model.Postal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostalRepository extends JpaRepository<Postal, String> {
}
