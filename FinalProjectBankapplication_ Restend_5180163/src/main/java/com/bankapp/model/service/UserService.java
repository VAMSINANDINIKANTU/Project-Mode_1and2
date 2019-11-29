package com.bankapp.model.service;

import java.util.List;
import java.util.Optional;

import com.bankapp.model.entities.AppUser;

public interface UserService {

	public Optional<AppUser> findUserById(Long id);

	public AppUser findByEmail(String email);

	public AppUser addUser(AppUser user);

	public List<AppUser> findAll();

	public void blockUser(Long userId);

	public void deleteUser(Long userId);

	public AppUser updateUser(Long id, AppUser user);

}
