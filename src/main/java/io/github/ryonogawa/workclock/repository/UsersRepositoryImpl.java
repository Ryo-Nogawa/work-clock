package io.github.ryonogawa.workclock.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import io.github.ryonogawa.workclock.entity.Users;

@Repository
public class UsersRepositoryImpl implements UsersRepository {

    private final JdbcTemplate jdbcTemplate;

    public UsersRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void register(String email, String passwordHash, String name) {
        Users user = new Users(email, passwordHash, name);
        jdbcTemplate.update("INSERT INTO users VALUES (?,?,?,?,?)",
                user.getEmail(),
                user.getPasswordHash(),
                user.getName(),
                user.getUpdatedAt(),
                user.getCreatedAt());
    }
}
