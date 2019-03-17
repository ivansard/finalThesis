package com.ivans.webshop.repository.repo;

import com.ivans.webshop.repository.entity.LineItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineItemRepo extends JpaRepository<LineItemEntity, Integer> {
}
