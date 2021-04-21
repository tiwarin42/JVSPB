package com.training.platform.controllers;

import com.training.platform.entities.Shop;
import com.training.platform.entities.User;
import com.training.platform.services.AssignService;
import com.training.platform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/demo")
public class AssignController {

    @Autowired
    private AssignService assignService;

    @GetMapping(value = "/Assign1")
    public List<User> findByActive(@RequestParam String active){
        return assignService.findByActive(Integer.parseInt(active));
    }

    @GetMapping(value = "/Assign2")
    public List<User> findByNameAndSurname(@RequestParam String name,@RequestParam String surname){
        return assignService.findByNameAndSurname(name, surname);
    }
}
