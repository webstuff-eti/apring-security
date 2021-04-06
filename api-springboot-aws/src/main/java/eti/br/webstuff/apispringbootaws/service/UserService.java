package eti.br.webstuff.apispringbootaws.service;

import eti.br.webstuff.apispringbootaws.entity.User;
import eti.br.webstuff.apispringbootaws.exceptions.GenericNotFoundException;
import eti.br.webstuff.apispringbootaws.repository.UserRepository;
import eti.br.webstuff.apispringbootaws.service.util.HashUtil;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User save(User user) {
        String hash = HashUtil.getSecureHash(user.getPassword());
        user.setPassword(hash);

        User createdUser = repository.save(user);

        return createdUser;
    }

    public User update(User user) {
        String hash = HashUtil.getSecureHash(user.getPassword());
        user.setPassword(hash);

        User updatedUser = repository.save(user);

        return updatedUser;
    }

    public User getById(Long id){
        Optional<User> result = repository.findById(id);

        return result.orElseThrow(()-> new GenericNotFoundException("There are not user with id = " + id));
    }

    public List<User> listAll() {
        List<User> users = repository.findAll();

        return users;
    }

    public User login(String email, String password) {
        password = HashUtil.getSecureHash(password);

        Optional<User> result = repository.login(email, password);

        return result.get();
    }

    public int updateRole(User user) {

        return repository.updateRole(user.getId(), user.getRoleEnum());
    }


}
