package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.Bank;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BankRepository {

    private final List<Bank> bankList = new ArrayList<>();

    public void save(Bank bank) {
        bankList.add(bank);
    }

    public List<Bank> findAll() {
        return bankList;
    }

    public Optional<Bank> findByName(String name) {
        return bankList.stream()
                .filter(bank -> bank.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
