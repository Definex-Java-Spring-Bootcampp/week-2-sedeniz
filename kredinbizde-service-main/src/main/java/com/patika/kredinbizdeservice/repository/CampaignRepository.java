package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.Campaign;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CampaignRepository {

    private List<Campaign> campaignList = new ArrayList<>();

    public void save(Campaign campaign) {
        campaignList.add(campaign);
    }

    public List<Campaign> findAll() {
        return campaignList;
    }
}
