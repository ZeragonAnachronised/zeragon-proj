package com.zeragon.forum.repository;

import com.zeragon.forum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}