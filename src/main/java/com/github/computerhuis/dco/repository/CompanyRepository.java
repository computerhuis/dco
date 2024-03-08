package com.github.computerhuis.dco.repository;

import com.github.computerhuis.dco.repository.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
