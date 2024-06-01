package com.travelassitant.microservice.usermanagementservice.DAOs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import com.travelassitant.microservice.usermanagementservice.bean.ContactUs;
import com.travelassitant.microservice.usermanagementservice.dbRepositories.ContactUsRepository;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import java.util.Collections;

@Service
public class ContactUsDAO {
    @Autowired
    private ContactUsRepository contactUsRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public void markAllAsRead() {
        Query query = new Query();
        Update update = new Update().set("isRead", true);
        mongoTemplate.updateMulti(query, update, ContactUs.class);
    }

    public ContactUs save(ContactUs contactUs) {
        return contactUsRepository.save(contactUs);
    }

    public ContactUs findById(String id) {
        return contactUsRepository.findById(id).orElse(null);
    }

    public List<ContactUs> findAll() {
        List<ContactUs> messages = contactUsRepository.findAll();
        Collections.reverse(messages);
        return messages;
    }

    public void deleteById(String id) {
        contactUsRepository.deleteById(id);
    }
}
