package com.okzampo.coffehour.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.okzampo.coffehour.entity.User;
import org.springframework.stereotype.Repository;

public interface UserRepository extends MongoRepository<User,String>{
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
