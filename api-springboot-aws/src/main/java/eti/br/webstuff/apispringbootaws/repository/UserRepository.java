package eti.br.webstuff.apispringbootaws.repository;

import eti.br.webstuff.apispringbootaws.entity.User;
import eti.br.webstuff.apispringbootaws.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> { //, JpaSpecificationExecutor<User>

    //FIXME: MANEIRA DE BUSCAR -TESTE
    /*
    public User getByName(String name);
    public User getByEmailAndPassword(String email, String password);
    */

    @Query("SELECT u FROM user u WHERE email = ?1 AND password = ?2")
    public Optional<User> login(String email, String password);

    @Transactional(readOnly = false)
    @Modifying
    @Query("UPDATE user SET role = ?2 WHERE id = ?1")
    public int updateRole(Long id, RoleEnum role);

    public Optional<User> findByEmail(String email);

}
