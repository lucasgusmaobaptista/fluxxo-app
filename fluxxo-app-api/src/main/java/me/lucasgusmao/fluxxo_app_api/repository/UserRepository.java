package me.lucasgusmao.fluxxo_app_api.repository;

import me.lucasgusmao.fluxxo_app_api.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Optional<User> findByActivationToken(String activationToken);

    Optional<User> findByLoginToken(String loginToken);
}
