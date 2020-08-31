package com.dc.projects.ContactsDirectory;

import com.dc.projects.ContactsDirectory.Model.Address;
import com.dc.projects.ContactsDirectory.Model.Contact;
import com.dc.projects.ContactsDirectory.Model.Relationship;
import com.dc.projects.ContactsDirectory.Service.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ContactDirectoryApplicationTests {

    @Autowired
    ContactService contactService;

    @Test
    void contextLoads() {
    }

    @BeforeEach
    void LoadContact() {

        Contact con = new Contact();
        con.setName("Jack Ryan");
        con.setAddress(new Address("123 Main St", "Apt# 420", "San Jose", "California", 94582));
        con.setCellphone("9867500001");
        con.setWorkPhone("5156768080");
        con.setEmailId("jack.ryan@cares.com");
        con.setRelation(Relationship.COUSIN);
        Contact savedContact = contactService.saveContact(con);
    }

    @Test
    void getContactById() {

        Contact savedContact = contactService.getContactById(1L);
        assertEquals(1L, savedContact.getId());
        System.out.println("In getContactById " + savedContact.getId());
    }

    @Test
    void getContactByName() {

        Contact savedContact = contactService.getContactByName("Jack Ryan");
        assertEquals("Jack Ryan", savedContact.getName());
        System.out.println("In getContactByName " + savedContact.getName() + " having Id " + savedContact.getId());
    }

    @Test
    void testInvalidContactFetchByName() {

        Exception exp = assertThrows(IllegalArgumentException.class,
                () -> contactService.getContactByName("Lucifer Morningstar"));

        String expectedMessage = "Contact name Lucifer Morningstar does not exist";
        assertEquals(expectedMessage, exp.getMessage());
        System.out.println("Testing testInvalidContactFetchByName => " + exp.getMessage());
    }
}
