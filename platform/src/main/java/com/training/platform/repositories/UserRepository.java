package com.training.platform.repositories;

import com.training.platform.entities.Shop;
import com.training.platform.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {

    public List<User> findByCityAndActiveAndAge(String city, Integer active, Integer age);
    public List<User> findByAgeIn(List<Integer> ages);

    @Query(value = "SELECT * FROM users u WHERE u.active = 1 and u.city = 'Bangkok' ",
            nativeQuery = true)
    public List<User> findAllByQuery();

    @Query(value = "SELECT * FROM users u WHERE u.active = ?1 and u.city = ?2 ",
            nativeQuery = true)
    public List<User> findAllByParamsQuery(Integer active,  String city);

    @Query("SELECT u FROM User u WHERE u.active = 1 and u.city = 'Bangkok' ")
    public List<User> findAllByJpqlQuery();

    @Query("SELECT u FROM User u WHERE u.active = ?1 and u.city = ?2 ")
    public List<User> findAllByJpqlParamsQuery(Integer active, String city);

    public List<User> findByActive(Integer active);
    public List<User> findByNameAndSurname(String name,String surname);

}

