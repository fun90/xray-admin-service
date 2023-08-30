package com.fun90.admin.repository;

import com.fun90.admin.model.MessageReceiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageReceiverRepository extends JpaRepository<MessageReceiver, Integer> {
}
