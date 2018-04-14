package com.espark.adarsh.web.manager;

import java.util.Collection;

import com.espark.adarsh.persistence.entites.impl.User;
import com.espark.adarsh.persistence.entites.impl.UserRole;

public interface UserManager<M> {
	public void refreshUser(User user);

	public Boolean saveUser(User user);

	public Boolean updateUser(User user);

	public Boolean deleteUser(User user);

	public User getUser(User user);

	public User getUserById(User user);

	public User getUserByName(User user);

	public Collection<User> getAllUser();

	public UserRole getUserRole(String roleName);
}
