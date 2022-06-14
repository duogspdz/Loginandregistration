package vn.dasvision.loginandregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.dasvision.loginandregistration.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select user from User user where user.email = ?1")
    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.verificationCode = ?1")
    public User findByVerificationCode(String code);

}
