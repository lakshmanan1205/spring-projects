package com.lionel.library_management_v1.dao;

import com.lionel.library_management_v1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    // NO NEED TO WRITE JPA CODE FOR ACCESS DB
    public User findByEmail(String email);
}
