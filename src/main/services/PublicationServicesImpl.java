package main.services;

import main.models.dao.PublicationDAO;
import main.models.pojo.Publication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 04.05.2017. 123
 */

@Service
public class PublicationServicesImpl implements PublicationServices {

    private PublicationDAO publicationDAO;

    @Override
    public List<Publication> getAllPublicationToFree() {
        List<Publication> publications =new ArrayList<>();
        publications.addAll(publicationDAO.getAll());
        return publications;
    }

    @Override
    public void insert(String fio, String email, String phone) {

    }

    public PublicationDAO getPublicationDAO() {
        return publicationDAO;
    }

    public void setPublicationDAO(PublicationDAO publicationDAO) {
        this.publicationDAO = publicationDAO;
    }
}
