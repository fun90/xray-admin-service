package com.fun90.admin.repository;

import com.fun90.admin.model.PackageCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageCodeRepository extends JpaRepository<PackageCode, Integer> {
}