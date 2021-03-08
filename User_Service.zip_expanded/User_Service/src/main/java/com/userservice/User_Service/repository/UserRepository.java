package com.userservice.User_Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userservice.User_Service.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{

}
