package vn.dasvision.loginandregistration;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import vn.dasvision.loginandregistration.entity.User;
import vn.dasvision.loginandregistration.repository.UserRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setUsername("duongjifewnx6");
        user.setEmail("duongjewfinx6@rêggmail.com");
        user.setPassword("asd123");

        User savedUser = repo.save(user);

        User exitsUser = entityManager.find(User.class, savedUser.getId());

        assertThat (exitsUser.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void testFindUserByEmail(){
        String email = "duongjinx6@gmail.com";
        User user = repo.findByEmail(email);
        assertThat(user).isNotNull();
    }

}
