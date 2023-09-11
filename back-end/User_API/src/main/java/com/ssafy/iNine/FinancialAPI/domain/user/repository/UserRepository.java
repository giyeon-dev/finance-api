package com.ssafy.iNine.FinancialAPI.domain.user.repository;

import com.ssafy.iNine.FinancialAPI.common.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findByUserId(String userId);

    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.email=:email")
    boolean isDuplicatedEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.email=:email AND u.isDeleted=false")
    Optional<User> findByEmail(@Param("email") String email);

    @Modifying
    @Query("UPDATE User u SET u.isDeleted = true, u.deletedTime = :deletedTime WHERE u.id = :userId")
    void deleteUser(@Param("userId") Long UserId, @Param("deletedTime")LocalDateTime deletedTime);

    @Modifying
    @Query("UPDATE User u SET u.password = :password WHERE u.id = :userId")
    void modifyPassword(@Param("userId") Long UserId, @Param("password") String password);
}
