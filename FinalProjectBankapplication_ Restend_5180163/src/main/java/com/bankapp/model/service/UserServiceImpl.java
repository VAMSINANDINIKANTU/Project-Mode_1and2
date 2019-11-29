package com.bankapp.model.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.entities.AppUser;
import com.bankapp.model.repository.UserRepository;
import com.bankapp.model.service.exceptions.UserNotFoundException;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public AppUser findByEmail(String email) {

		return userRepository.findByEmail(email);
	}

	@Override
	public AppUser addUser(AppUser user) {
		return userRepository.save(user);

	}

	@Override
	public List<AppUser> findAll() {
		// TODO Auto-generated method stub
		return (List<AppUser>) userRepository.findAll();
	}

	@Override
	public void blockUser(Long userId) {

	}

	@Override
	public void deleteUser(Long userId) {

		userRepository.deleteById(userId);
	}

	@Override
	public AppUser updateUser(Long id, AppUser user) {

		AppUser usertoBeUpdated = userRepository.findById(id).orElseThrow(
				UserNotFoundException::new);
		usertoBeUpdated.setName(user.getName());
		return userRepository.save(usertoBeUpdated);
	}

	@Override
	public Optional<AppUser> findUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

}
