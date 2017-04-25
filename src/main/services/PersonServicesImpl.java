package main.services;


import main.models.dao.PersonDAO;
import main.models.dao.PersonDAOImpl;
import main.models.pojo.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 22.04.2017.123
 */
public class PersonServicesImpl implements PersonServices {

    private static PersonDAO personDAO = new PersonDAOImpl();

    @Override
    public List<Person> getAllPerson() {
        List<Person> persons = new ArrayList<>();
        persons.addAll(personDAO.getAll());
        return  persons;
    }
}
