package eti.br.webstuff.apispringbootaws.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import eti.br.webstuff.apispringbootaws.entity.RequestStage;
import eti.br.webstuff.apispringbootaws.enums.RequestStateEnum;
import eti.br.webstuff.apispringbootaws.exceptions.GenericNotFoundException;
import eti.br.webstuff.apispringbootaws.model.PageModel;
import eti.br.webstuff.apispringbootaws.model.PageRequestModel;
import eti.br.webstuff.apispringbootaws.repository.RequestRepository;
import eti.br.webstuff.apispringbootaws.repository.RequestStageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class RequestStageService {

    @Autowired
    private RequestStageRepository requestStageRepository;

    @Autowired
    private RequestRepository requestRepository;

    public RequestStage save(RequestStage stage){

        stage.setRealizationDate(new Date());

        RequestStage createdStage = requestStageRepository.save(stage);

        Long requestId = stage.getRequest().getId();
        RequestStateEnum state = stage.getStateEnum();

        requestRepository.updateStatus(requestId, state);

        return createdStage;

    }

    public RequestStage getById(Long id) {
        Optional<RequestStage> result = requestStageRepository.findById(id);
        return result.orElseThrow(()-> new GenericNotFoundException("There are not request stage with id = " + id));
    }

    //FIXME: Lista os estágios dado o ID da requisição
    public List<RequestStage> listAllByRequestId(Long requestId) {
        return requestStageRepository.findAllByRequestId(requestId);
    }


    public PageModel<RequestStage> listAllByRequestIdOnLazyModel(Long requestId, PageRequestModel pr) {
        Pageable pageable = pr.toSpringPageRequest();
        Page<RequestStage> page = requestStageRepository.findAllByRequestId(requestId, pageable);

        PageModel<RequestStage> pm = new PageModel<>((int)page.getTotalElements(), page.getSize(), page.getTotalPages(), page.getContent());
        return pm;
    }
}
