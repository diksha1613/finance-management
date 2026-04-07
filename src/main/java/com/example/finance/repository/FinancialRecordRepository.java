package com.example.finance.repository;

import com.example.finance.entity.FinancialRecord;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.finance.enumtype.RecordType;


public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {
	List<FinancialRecord> findByType(RecordType type);
}