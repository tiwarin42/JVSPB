package com.training.platform.services;

import com.training.platform.entities.Shop;
import com.training.platform.entities.User;

import java.util.List;


public interface AssignService {

    List<User> findByActive(Integer active);
    List<User> findByNameAndSurname(String name,String surname);
}
