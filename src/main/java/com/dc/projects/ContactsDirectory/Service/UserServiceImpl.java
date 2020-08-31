package com.dc.projects.ContactsDirectory.Service;

import com.dc.projects.ContactsDirectory.Model.User;
import com.dc.projects.ContactsDirectory.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> obj = userRepo.findById(id);
        if (obj.isPresent())
            return obj.get();
        throw new IllegalArgumentException("Id "+id+" does not exist");
    }

    @Override
    public User getUserByUserName(String userName) {
        Optional<User> obj = userRepo.findByUserName(userName);
        if (obj.isPresent())
            return obj.get();
        throw new IllegalArgumentException("User Id "+userName+" does not exist");
    }

    @Override
    public User saveUser(User obj) {
        return userRepo.save(obj);
    }

    @Override
    public void deleteUser(User obj) {
         userRepo.delete(obj);
    }

}
