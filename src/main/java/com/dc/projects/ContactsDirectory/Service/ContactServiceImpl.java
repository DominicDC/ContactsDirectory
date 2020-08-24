package com.dc.projects.ContactsDirectory.Service;

import com.dc.projects.ContactsDirectory.Model.Contact;
import com.dc.projects.ContactsDirectory.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepo;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepo) {
        this.contactRepo = contactRepo;
    }

    @Override
    public Contact getContactById(Long id) {
        Optional<Contact> obj = contactRepo.findById(id);
        if (obj.isPresent())
            return obj.get();
        throw new IllegalArgumentException("Contact Id "+id+" does not exist");
    }

    @Override
    public Contact getContactByName(String name) {
        Optional<Contact> obj = contactRepo.findByName(name);
        if (obj.isPresent())
            return obj.get();
        throw new IllegalArgumentException("Contact name "+name+" does not exist");
    }

    @Override
    public Contact saveContact(Contact obj) {
        return contactRepo.save(obj);
    }

    @Override
    public void deleteContact(Contact obj) {
        contactRepo.delete(obj);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepo.findAll(Sort.by(Sort.Direction.ASC,"name"));
    }
}
