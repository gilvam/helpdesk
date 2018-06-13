package com.gilvam.helpdesk.repository;

import com.gilvam.helpdesk.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

	User findByEmail(String email);
}
