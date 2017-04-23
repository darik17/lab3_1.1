package services;

import models.dao.PersonDAO;
import models.dao.PersonDAOImpl;
import models.pojo.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 22.04.2017.
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
