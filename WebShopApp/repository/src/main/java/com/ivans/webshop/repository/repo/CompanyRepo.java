package com.ivans.webshop.repository.repo;

import com.ivans.webshop.repository.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepo extends JpaRepository<CompanyEntity, Integer> {

    CompanyEntity findByName(String companyName);
}
