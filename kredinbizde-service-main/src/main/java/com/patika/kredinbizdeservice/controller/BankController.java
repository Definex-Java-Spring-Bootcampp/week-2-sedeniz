package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.model.User;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.service.BankService;
import com.patika.kredinbizdeservice.service.CampaignService;
import com.patika.kredinbizdeservice.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/banks")
public class BankController {

    @Autowired
    private BankService bankService;
    @Autowired
    private CreditCardService creditCardService;
    @Autowired
    private CampaignService campaignService;


    // create a bank
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bank create(@RequestBody Bank bank) {
        System.out.println("userService: " + bankService.hashCode());
        return bankService.save(bank);
    }

    // create a credit card of a bank
    @PostMapping("/{bankName}/credit-cards")
    public ResponseEntity<CreditCard> addCreditCardToBank(@PathVariable String bankName, @RequestBody CreditCard creditCard) {
        Bank bank = bankService.findByName(bankName);
        if (bank == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (bank.getCreditCards() == null) {
            bank.setCreditCards(new ArrayList<>());
        }

        // Set the bank of the credit card
        creditCard.setBank(bank);
        bank.getCreditCards().add(creditCard);

        CreditCard savedCard = creditCardService.save(creditCard);
        return new ResponseEntity<>(savedCard, HttpStatus.CREATED);
    }


    @GetMapping("/credit-cards")
    public List<Bank> getAllCreditCardsAndCampaigns()
    {
        return bankService.getAllCreditCardsWithCampaigns();
    }

    @GetMapping("/{bankName}/credit-cards")
    public ResponseEntity<List<CreditCard>> getCreditCardsOfBank(@PathVariable String bankName) {
        List<CreditCard> creditCards = bankService.getCreditCardsOfBank(bankName);
        if (creditCards.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(creditCards, HttpStatus.OK);
    }
}
