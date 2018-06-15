package com.gilvam.helpdesk.service;

import com.gilvam.helpdesk.model.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserService {

	Optional<User> findById(String id);

	User findByEmail(String email);

	User createOrUpdate(User user);

	void delete(String id);

	Page<User> findAll(int page, int count);
}
