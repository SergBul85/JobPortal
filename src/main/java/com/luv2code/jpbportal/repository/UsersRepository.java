package com.luv2code.jpbportal.repository;

import com.luv2code.jpbportal.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
