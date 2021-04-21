package com.training.platform.controllers;


import com.training.platform.entities.User;
import com.training.platform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/demo")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public List<User> index(){
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<User> showWithPath(@PathVariable String id){
        return userService.findById(Integer.parseInt(id));
    }

    @GetMapping(value = "/param1")
    public Page<User> showWithParam(@RequestParam String start,@RequestParam String limit,@RequestParam String field){
        return userService.findAllByLimit(Integer.parseInt(start),Integer.parseInt(limit),field);

    }

    @GetMapping(value = "/{city}/{active}/{age}")
    public List<User> showWithPath(@PathVariable String city,@PathVariable String active,@PathVariable String age){
        return userService.findByCityAndActiveAndAge(city,Integer.parseInt(active),Integer.parseInt(age));
    }

    @GetMapping(value = "/findByAgeIn")
    public List<User> findByAgeIn(@RequestBody Map<String,Object> inputs){
        return userService.findByAgeIn((List<Integer>) inputs.get("age"));
    }


    @GetMapping(value = "/test1")
    public List<User> test1() {
        return userService.findAllByQuery();
    }

    @GetMapping(value = "/test2")
    public List<User> test2(@RequestParam String active, @RequestParam String city ) {
        return userService.findAllByParamsQuery(Integer.parseInt(active), city);
    }

    @GetMapping(value = "/test3")
    public List<User> test3() {
        return userService.findAllByJpqlQuery();
    }

    @GetMapping(value = "/test4")
    public List<User> test4(@RequestParam String active, @RequestParam String city) {
        return userService.findAllByJpqlParamsQuery(Integer.parseInt(active), city);
    }

}
