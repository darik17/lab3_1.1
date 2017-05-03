package main.services;


import main.models.dao.PersonDAO;
import main.models.pojo.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 22.04.2017.123
 */
@Service
public class PersonServicesImpl implements PersonServices {

    private /*static*/ PersonDAO personDAO /*= new PersonDAOImpl()*/;

    @Override
    public List<Person> getAllPerson() {
        List<Person> persons = new ArrayList<>();
        persons.addAll(personDAO.getAll());
        return persons;
    }

    @Override
    public void insert(String fio, String email, String phone) {
        Person person =new Person();
        personDAO.insert(person);
    }

    public PersonDAO getPersonDAO() {
        return personDAO;
    }


    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
}
