package com.fun90.admin.repository;

import com.fun90.admin.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ServerRepository extends JpaRepository<Server, Integer> {

	List<Server> findByLevelLessThanEqualAndStatusOrderByLevelDesc(Short level, Integer status);

	List<Server> findByProtocolInAndStatus(Set<String> protocols, Integer status);

	List<Server> findByLevelLessThanEqualAndStatusAndClientDomainOrderByLevelDesc(Short level, Integer status, String clientDomain);
}
