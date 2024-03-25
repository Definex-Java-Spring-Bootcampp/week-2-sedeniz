package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.CreditCard;

import java.util.List;

public interface IBankService {
    Bank save(Bank bank);
    Bank findByName(String name);
    List<Bank> getAllCreditCardsWithCampaigns();
    List<CreditCard> getCreditCardsOfBank(String bankName);
}
