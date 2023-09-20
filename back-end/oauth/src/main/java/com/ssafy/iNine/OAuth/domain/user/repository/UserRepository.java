package com.ssafy.iNine.OAuth.domain.user.repository;

import com.ssafy.iNine.OAuth.common.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById (String username);

    @Modifying
    @Query("update User u set u.password =: password where u.userID =: userId")
    int setUserPassword(String password, String userId);
}
