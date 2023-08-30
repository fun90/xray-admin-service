package com.fun90.admin.repository;

import com.fun90.admin.model.InvitationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitationCodeRepository extends JpaRepository<InvitationCode, Integer> {
}
