package com.training.platform.services;

import com.training.platform.entities.Shop;
import com.training.platform.entities.User;
import com.training.platform.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class AssignServiceImpl implements AssignService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findByActive(Integer active){
        return userRepository.findByActive(active);
    }

    @Override
    public List<User> findByNameAndSurname(String name,String surname) {
        return userRepository.findByNameAndSurname(name,surname);
    }

}
