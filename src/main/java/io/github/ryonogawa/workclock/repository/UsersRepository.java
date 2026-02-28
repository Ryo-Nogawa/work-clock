package io.github.ryonogawa.workclock.repository;

public interface UsersRepository {
    // 新規ユーザー登録
    public void register(String email, String passwordHash, String name);

    // userId取得
    public Long getUserId(String email);

}
