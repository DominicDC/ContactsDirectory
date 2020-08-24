package com.dc.projects.ContactsDirectory.Service;

import com.dc.projects.ContactsDirectory.Model.Contact;

import java.util.List;

public interface ContactService {

    Contact getContactById(Long id);
    Contact getContactByName(String name);
    Contact saveContact(Contact obj);
    void deleteContact(Contact obj);
    List<Contact> getAllContacts();
}
