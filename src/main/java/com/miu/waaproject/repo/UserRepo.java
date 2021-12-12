package com.miu.waaproject.repo;

import com.miu.waaproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUserName(String username);
}
