package eti.br.webstuff.apispringbootaws.service;

import eti.br.webstuff.apispringbootaws.entity.User;
import eti.br.webstuff.apispringbootaws.exceptions.GenericNotFoundException;
import eti.br.webstuff.apispringbootaws.model.PageModel;
import eti.br.webstuff.apispringbootaws.model.PageRequestModel;
import eti.br.webstuff.apispringbootaws.model.PageSimpleRequestModel;
import eti.br.webstuff.apispringbootaws.repository.UserRepository;
import eti.br.webstuff.apispringbootaws.service.util.HashUtil;
import eti.br.webstuff.apispringbootaws.specification.UserSpecification;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


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

    //FIXME: Implementando paginação no modo preguiçoso
    public PageModel<User> listAllOnLazyMode(PageRequestModel pr) {
        Pageable pageable = PageRequest.of(pr.getPage(), pr.getSize());

       // Specification<User> spec = UserSpecification.search(pr.getSearch());

        Page<User> page = repository.findAll(pageable);

        PageModel<User> pm = new PageModel<>((int)page.getTotalElements(), page.getSize(), page.getTotalPages(), page.getContent());

        return pm;
    }


    //FIXME: Implementando paginação no modo preguiçoso
    public PageModel<User> listAllSimpleOnLazyMode(PageSimpleRequestModel pr) {
        Pageable pageable = PageRequest.of(pr.getPage(), pr.getSize());

        Page<User> page = repository.findAll(pageable);

        PageModel<User> pm = new PageModel<>((int)page.getTotalElements(), page.getSize(), page.getTotalPages(), page.getContent());

        return pm;
    }


}
