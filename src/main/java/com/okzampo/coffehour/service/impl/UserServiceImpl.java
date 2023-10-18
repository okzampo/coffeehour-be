package com.okzampo.coffehour.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.okzampo.coffehour.entity.User;
import com.okzampo.coffehour.exception.ConflictException;
import com.okzampo.coffehour.exception.InternalServerException;
import com.okzampo.coffehour.exception.NotFoundException;
import com.okzampo.coffehour.repository.UserRepository;
import com.okzampo.coffehour.service.UserService;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repo;

    UserServiceImpl(UserRepository repo){
        this.repo = repo;
    }

    @Override
    @SneakyThrows
    public User createUser(User user){
        //Check for email
        if(repo.existsByEmail(user.getEmail())){
            log.info("Someone has tried to create an user with an already used email");
            throw new ConflictException();
        }

        try{
            user = repo.save(user);
            return user;
        }catch(Exception e){
            log.warn("Database failure while trying to save a user", e);
            throw new InternalServerException();
        }
    }

    @Override
    @SneakyThrows
    public User editUser(String id, User user) {
        User onDb = getUser(id);
        if(!user.getEmail().equals(onDb.getEmail())){
            if(repo.existsByEmail(user.getEmail())){
                log.info("Someone has tried to edit an user with an already used email");
                throw new ConflictException();
            }
            onDb.setEmail(user.getEmail());
        }

        onDb.setFirstName(user.getFirstName());
        onDb.setLastName(user.getLastName());

        if(user.getPassword() != null && !user.getPassword().isEmpty()){
            onDb.setPassword(user.getPassword());
        }

        try{
            onDb = repo.save(onDb);
            return onDb;
        }catch(Exception e){
            log.warn("Database failure while trying to save a user", e);
            throw new InternalServerException();
        }
    }

    @Override
    @SneakyThrows
    public User deleteUser(String id) {
        User user = getUser(id);

        try{
            repo.delete(user);
            return user;
        }catch(Exception e){
            log.warn("Database failure while trying to delete a user", e);
            throw new InternalServerException();
        }
    }

    @Override
    @SneakyThrows
    public User getUser(String id) {
        return repo.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }
    
}
