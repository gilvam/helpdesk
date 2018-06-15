package com.gilvam.helpdesk.service.impl;

import com.gilvam.helpdesk.model.User;
import com.gilvam.helpdesk.repository.UserRepository;
import com.gilvam.helpdesk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<User> findById(String id) {
		//return this.userRepository.findOne(id);
		return this.userRepository.findById(id);
	}

	@Override
	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}

	@Override
	public User createOrUpdate(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public void delete(String id) {
		//this.userRepository.delete(id);
		this.userRepository.deleteById(id);
	}

	@Override
	public Page<User> findAll(int page, int count) {
		Pageable pageables = new QPageRequest(page, count);
		return this.userRepository.findAll(pageables);
	}
}
