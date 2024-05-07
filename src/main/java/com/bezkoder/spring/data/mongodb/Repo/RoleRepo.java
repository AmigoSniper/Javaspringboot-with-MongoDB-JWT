package com.bezkoder.spring.data.mongodb.Repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bezkoder.spring.data.mongodb.model.ERole;
import com.bezkoder.spring.data.mongodb.model.Role;

public interface RoleRepo extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
