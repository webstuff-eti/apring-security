package eti.br.webstuff.apispringbootaws.resource;

import eti.br.webstuff.apispringbootaws.converters.UserConverter;
import eti.br.webstuff.apispringbootaws.entity.Request;
import eti.br.webstuff.apispringbootaws.entity.User;
import eti.br.webstuff.apispringbootaws.model.PageModel;
import eti.br.webstuff.apispringbootaws.model.PageRequestModel;
import eti.br.webstuff.apispringbootaws.model.PageSimpleRequestModel;
import eti.br.webstuff.apispringbootaws.resource.dto.request.UseLoginRequestDto;
import eti.br.webstuff.apispringbootaws.resource.dto.request.UserSavedto;
import eti.br.webstuff.apispringbootaws.service.RequestService;
import eti.br.webstuff.apispringbootaws.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javassist.NotFoundException;

import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping(value = "users")
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private RequestService requestService;

    @Autowired
    private UserConverter userConverter;


    @PostMapping
    public ResponseEntity<User> save(@RequestBody @Valid UserSavedto userDto){ //TODO: Testar annotation @VAlid na implementação
        User user = userConverter.converterUserSavedtoToUSer(userDto);
        User createdUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable(name = "id") Long id, @RequestBody User user){
        user.setId(id);
        User updateUser = userService.update(user);
        return ResponseEntity.ok(updateUser);
    }

    //TODO: Não esta funcionando - Implementar
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UseLoginRequestDto useLoginRequest){
        User loginUser = userService.login(useLoginRequest.getEmail(), useLoginRequest.getPassword());
        return ResponseEntity.ok(loginUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("RequestsByIdUser/{id}")
    public ResponseEntity<List<Request>> listAllRequestsByIdUser(@PathVariable ("id") Long id){
        List<Request> requests = requestService.listAllRequestsByUserId(id);
        return ResponseEntity.ok(requests);
    }

    @GetMapping
    public ResponseEntity<List<User>> listAll(){
        List<User> users = userService.listAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/simple/by-page")
    public ResponseEntity<PageModel<User>> listAllByPage(
            @RequestParam(value = "numPage") int numPage,
            @RequestParam(value = "sizePage") int sizePage
    ){
        PageSimpleRequestModel psr = new PageSimpleRequestModel(numPage, sizePage);
        PageModel<User> usersByPage = userService.listAllSimpleOnLazyMode(psr);
        return ResponseEntity.ok(usersByPage);
    }

}
