package be.intecbrussel;

import be.intecbrussel.data.Auteur;
import be.intecbrussel.data.User;
import be.intecbrussel.repository.AuteurRepository;
import be.intecbrussel.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;




@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@SpringBootTest
class BlogCentralMainApplicationTests {


    @Autowired
    private AuteurRepository repo;

    @Autowired
    private UserRepository repo2;

    @Test
    public void testCreateUser() {
        Auteur auteur = new Auteur("emrahyavuz3225@gmail.com","123456789","Emrah", null);

        Auteur savedAuteur = repo.save(auteur);



    }

    @Test
    public void testFindUserByEmail(){







    }
}


