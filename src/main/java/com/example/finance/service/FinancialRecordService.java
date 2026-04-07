package com.example.finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finance.entity.FinancialRecord;
import com.example.finance.enumtype.RecordType;
import com.example.finance.repository.FinancialRecordRepository;

@Service
public class FinancialRecordService {

    @Autowired
    private FinancialRecordRepository repository;

    public FinancialRecord save(FinancialRecord record) {
        return repository.save(record);
    }

    public List<FinancialRecord> getAll() {
        return repository.findAll();
        
    
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
    public List<FinancialRecord>getByType(RecordType type){
    	return repository.findByType(type);
    }
    public Double getTotalByType(RecordType type) {
        List<FinancialRecord> records = repository.findByType(type);

        return records.stream()
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
    }	
    public Double getBalance() {
        Double income = getTotalByType(RecordType.INCOME);
        Double expense = getTotalByType(RecordType.EXPENSE);

        return income - expense;
    }
}