package com.dc.projects.ContactsDirectory.Repository;

import com.dc.projects.ContactsDirectory.Model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact,Long> {
    Optional<Contact> findByName(String name);
}
