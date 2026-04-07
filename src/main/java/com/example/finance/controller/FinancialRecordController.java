package com.example.finance.controller;

import com.example.finance.entity.FinancialRecord;
import com.example.finance.enumtype.RecordType;
import com.example.finance.service.FinancialRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/records")
public class FinancialRecordController {

    @Autowired
    private FinancialRecordService service;

    @PostMapping
    public FinancialRecord createRecord(@RequestBody FinancialRecord record) {
        return service.save(record);
    }

    @GetMapping
    public List<FinancialRecord> getAllRecords() {
        return service.getAll();
    
    }
    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Long id) {
        service.delete(id);
        return "Record deleted successfully";
    }
    @GetMapping("/type/{type}")
    public List<FinancialRecord> getByType(@PathVariable RecordType type) {
        return service.getByType(type);
    }
    @GetMapping("/balance-details")
    public Map<String, Double> getBalanceDetails() {
        Double income = service.getTotalByType(RecordType.INCOME);
        Double expense = service.getTotalByType(RecordType.EXPENSE);

        Map<String, Double> result = new HashMap<>();
        result.put("income", income);
        result.put("expense", expense);
        result.put("balance", income - expense);

        return result;
    }
} 	