package com.perscholas.camppower.repositories;

import com.perscholas.camppower.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}