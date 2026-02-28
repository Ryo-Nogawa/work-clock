package io.github.ryonogawa.workclock.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;

@Table("users")
@Getter
public class Users {

    @Id
    @Column("id")
    private Long id;

    @Column("email")
    private String email;

    @Column("password_hash")
    private String passwordHash;

    @Column("name")
    private String name;

    @Column("updated_at")
    private LocalDateTime updatedAt;

    @Column("created_at")
    private LocalDateTime createdAt;

    public Users(String email, String passwordHash, String name) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.name = name;
        this.updatedAt = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
    }
}
