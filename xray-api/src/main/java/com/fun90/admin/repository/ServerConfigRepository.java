package com.fun90.admin.repository;

import com.fun90.admin.model.ServerConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerConfigRepository extends JpaRepository<ServerConfig, Integer> {
}
