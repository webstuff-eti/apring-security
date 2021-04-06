package eti.br.webstuff.apispringbootaws.service;

import eti.br.webstuff.apispringbootaws.entity.Request;
import eti.br.webstuff.apispringbootaws.enums.RequestStateEnum;
import eti.br.webstuff.apispringbootaws.exceptions.GenericNotFoundException;
import eti.br.webstuff.apispringbootaws.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    RequestRepository repository;

    public Request save (Request request){

        request.setStateEnum(RequestStateEnum.OPEN);
        request.setCreationDate(new Date());

        return repository.save(request);
    }

    public Request update(Request request){
        return repository.save(request);
    }

    public Request getById(Long id){
        Optional<Request> result = repository.findById(id);
        return result.orElseThrow(()-> new GenericNotFoundException("There are not request with id = " + id));
    }

    public List<Request> listAll(){
        return repository.findAll();
    }

    //FIXME: Busca todas requisições de acordo com o ID do usuário
    public List<Request> listAllRequestsByUserId(Long idUser){
        return repository.findAllByUserId(idUser);
    }


}
