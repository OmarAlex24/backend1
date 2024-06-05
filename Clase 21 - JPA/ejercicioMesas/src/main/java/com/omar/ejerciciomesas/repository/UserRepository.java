package com.omar.ejerciciomesas.repository;

import com.omar.ejerciciomesas.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
