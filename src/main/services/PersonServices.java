package main.services;


import main.models.pojo.Person;

import java.util.List;

/**
 * Created by admin on 22.04.2017. 11
 */
public interface PersonServices {

    List<Person> getAllPerson();
    void insert(String fio, String email, String phone);
}
