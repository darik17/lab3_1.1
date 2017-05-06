package main.services;

import main.models.pojo.Publication;

import java.util.List;

/**
 * Created by admin on 04.05.2017. 123
 */
public interface PublicationServices {
    List<Publication> getAllPublicationToFree();
    void insert(String fio, String email, String phone);
    Publication getById(int public_id);
}
