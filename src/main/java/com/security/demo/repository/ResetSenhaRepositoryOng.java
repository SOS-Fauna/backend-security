package com.security.demo.repository;

import com.security.demo.model.entity.Ong;
import com.security.demo.model.entity.ResetSenhaOng;
import com.security.demo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResetSenhaRepositoryOng extends JpaRepository<ResetSenhaOng, String> {
    Optional<ResetSenhaOng> findByCodigoOng(String codigo);
    Optional<ResetSenhaOng> findByOng(Ong ong);

    @Modifying
    @Query("DELETE FROM ResetSenhaOng r WHERE r.ong = :ong")
    void deleteAllByOng(@Param("ong") Ong ong);
}
