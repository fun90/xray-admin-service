package com.fun90.admin.repository;

import com.fun90.admin.model.UserPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPlanRepository extends JpaRepository<UserPackage, Integer> {
}
