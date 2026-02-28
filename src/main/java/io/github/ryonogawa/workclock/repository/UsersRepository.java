package io.github.ryonogawa.workclock.repository;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import io.github.ryonogawa.workclock.entity.Users;

public interface UsersRepository extends ListCrudRepository<Users, Long> {

    Optional<Users> findByEmail(String email);
}
