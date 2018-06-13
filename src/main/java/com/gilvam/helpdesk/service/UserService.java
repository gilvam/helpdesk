package com.gilvam.helpdesk.service;

import com.gilvam.helpdesk.model.User;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface UserService {

	Optional<User> findById(String id);

	User findByEmail(String email);

	User createOrUpdate(User user);

	void delete(String id);

	Page<User> findAll(int page, int count);
}
