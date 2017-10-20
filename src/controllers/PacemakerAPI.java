package controllers;

import java.util.*;

import models.User;
import com.google.common.base.Objects;

public class PacemakerAPI
{
	private Map<String, User> users = new HashMap<>();
	private Map<Long, User> userIndex = new HashMap<>();
	private Map<String, User>emailIndex = new HashMap<>();

	public Collection<User> getUsers ()
	  {
		return userIndex.values();
	  }

  public  void deleteUsers() 
  {
	  userIndex.clear();
	  emailIndex.clear();
  }

  public User createUser(String firstName, String lastName, String email, String password) 
  {
	  User user = new User (firstName, lastName, email, password);
	    userIndex.put(user.id, user);
	    emailIndex.put(email, user);
	    return user;
  }
  
  public User getUserByEmail(String email) 
  {
    return emailIndex.get(email);
  }

  public User getUser(long id) 
  {
	  return userIndex.get(id);
  }

  public void deleteUser(long id) 
  {
	  User user = userIndex.remove(id);
	  emailIndex.remove(user.email);
  }
}