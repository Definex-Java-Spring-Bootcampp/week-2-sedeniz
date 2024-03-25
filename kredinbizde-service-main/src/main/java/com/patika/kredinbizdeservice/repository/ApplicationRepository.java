package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.Application;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ApplicationRepository {

    private List<Application> applicationList = new ArrayList<>();

    public void save(Application application) {
        applicationList.add(application);
    }

    public List<Application> findAll() {
        return new ArrayList<>(applicationList);
    }

}
