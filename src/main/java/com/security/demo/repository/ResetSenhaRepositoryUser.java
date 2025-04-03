package com.security.demo.repository;

import com.security.demo.model.entity.ResetSenhaUser;
import com.security.demo.model.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResetSenhaRepositoryUser extends JpaRepository<ResetSenhaUser, String> {
    Optional<ResetSenhaUser> findByCodigoUser(String codigo);
    Optional<ResetSenhaUser> findByUser(User user);

    @Modifying
    @Query("DELETE FROM ResetSenhaUser r WHERE r.user = :user")
    void deleteAllByUser(@Param("user") User user);
}
