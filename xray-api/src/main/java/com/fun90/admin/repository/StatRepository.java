package com.fun90.admin.repository;

import com.fun90.admin.model.Stat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface StatRepository extends JpaRepository<Stat, Integer> {

	Stat findByAccountIdAndFromDateBeforeAndToDateAfter(Integer accountId, Date date, Date date1);
}
