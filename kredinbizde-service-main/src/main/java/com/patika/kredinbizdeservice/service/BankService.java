package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankService implements IBankService {

    private final BankRepository bankRepository;

    @Autowired
    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public Bank save(Bank bank) {
        bankRepository.save(bank);
        return bank;
    }

    @Override
    public Bank findByName(String name) {
        return bankRepository.findByName(name).orElse(null);
    }

    @Override
    public List<Bank> getAllCreditCardsWithCampaigns()
    {
        return bankRepository.findAll();
    }

    @Override
    public List<CreditCard> getCreditCardsOfBank(String bankName) {
        Bank bank = this.findByName(bankName);
        if (bank != null) {
            return bank.getCreditCards();
        }
        return new ArrayList<>();
    }
}

