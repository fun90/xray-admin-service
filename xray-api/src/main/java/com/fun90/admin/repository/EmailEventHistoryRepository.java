package com.fun90.admin.repository;

import com.fun90.admin.model.EmailEventHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailEventHistoryRepository extends JpaRepository<EmailEventHistory, Integer> {
}
