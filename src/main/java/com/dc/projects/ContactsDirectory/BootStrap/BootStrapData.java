package com.dc.projects.ContactsDirectory.BootStrap;

import com.dc.projects.ContactsDirectory.Model.Address;
import com.dc.projects.ContactsDirectory.Model.Contact;
import com.dc.projects.ContactsDirectory.Model.Relationship;
import com.dc.projects.ContactsDirectory.Model.User;
import com.dc.projects.ContactsDirectory.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {

    /**
     ** Author: Dominic Coutinho
     ** Created On: Jul,2020
     ** Description: This class is used to load the initial data for contacts application
     *
     * Additional Info: Initial data loading
     * Select *
     * From users;
     *
     * Output: 2 records
     *
     * Select *
     * From contacts;
     *
     * Output: 4 records
     * *
     */

    private final UserService userService;

    @Autowired
    public BootStrapData(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        Contact con1 = createContact("Mazikeen","5237 Sunset Blvd",""
                ,"Los Angeles","California",900027,"Mazikeen@lux.com","(323) 100-2000"
                ,"",Relationship.COLLEAGUE);
        Contact con2 = createContact("Amenadiel","5237 Sunset Blvd",""
                ,"Los Angeles","California",900027,"Amenadiel@lux.com","(323) 100-2001"
                ,"",Relationship.BROTHER);

        Contact con3 = createContact("Dan Espinoza","5237 Sunset Blvd",""
                ,"Los Angeles","California",900027,"Dan@lux.com","(323) 100-2002"
                ,"",Relationship.OTHERS);
        Contact con4 = createContact("Trixie Espinoza","5237 Sunset Blvd",""
                ,"Los Angeles","California",900027,"Trixie@lux.com","(323) 100-2003"
                ,"",Relationship.DAUGHTER);

        Set<Contact> contactSet1 = new HashSet<>();
        contactSet1.add(con1);
        contactSet1.add(con2);

        Set<Contact> contactSet2 = new HashSet<>();
        contactSet2.add(con3);
        contactSet2.add(con4);

        User user1 = createUser("Lucifer Morningstar","Devil","Devil$123"
                ,"Lucifer@lux.com","(323) 100-0666",contactSet1);

        User user2 = createUser("Chloe Decker","Chloe","Detective$123"
                ,"Chloe@lux.com","(323) 100-0001",contactSet2);

        con1.setUser(user1);
        con2.setUser(user1);
        con3.setUser(user2);
        con4.setUser(user2);

        User savedUser1 = userService.saveUser(user1);
        User savedUser2 = userService.saveUser(user2);

        System.out.println("Users saved: \n"+user1+"\n"+user2);

    }

    private Contact createContact(String name, String address1, String address2, String city,
                                  String state, Integer zip, String emailId, String cellphone,
                                  String workPhone, Relationship relation) {

        Contact contact = new Contact();

        contact.setName(name);
        contact.setAddress(new Address(address1, address2, city, state, zip));
        contact.setRelation(relation);
        contact.setWorkPhone(workPhone);
        contact.setEmailId(emailId);
        contact.setCellphone(cellphone);
        return contact;
    }

    private User createUser(String name, String userName, String password,
                            String emailId, String cellphone, Set<Contact> contacts
                            ) {

        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setName(name);
        user.setEmailId(emailId);
        user.setCellphone(cellphone);
        user.setContacts(contacts);
        return user;
    }
}
