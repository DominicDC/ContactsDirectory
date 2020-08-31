package com.dc.projects.ContactsDirectory.Service;

import com.dc.projects.ContactsDirectory.Model.User;

public interface UserService {

    User getUserById(Long id);
    User getUserByUserName(String userName);
    User saveUser(User obj);
    void deleteUser(User obj);

}
