package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.User;

public interface UserService
{
   public User createUser(UserAccount user);
   public User updateUser(Long id,UserAccount user);
   public User getUserById(Long id);
   public List<UserAccount>getAllUsers();
   public void deactivateUser(Long id);
}