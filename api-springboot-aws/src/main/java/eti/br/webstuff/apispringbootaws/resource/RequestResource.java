package eti.br.webstuff.apispringbootaws.resource;

import eti.br.webstuff.apispringbootaws.entity.Request;
import eti.br.webstuff.apispringbootaws.entity.RequestStage;
import eti.br.webstuff.apispringbootaws.service.RequestService;
import eti.br.webstuff.apispringbootaws.service.RequestStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestControllerAdvice
@RequestMapping(value = "requests")
public class RequestResource {

    @Autowired
    private RequestService requestService;

    @Autowired
    private RequestStageService requestStageService;


    @PostMapping
    public ResponseEntity<Request> save (@RequestBody Request request){
        Request createdRequest = requestService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Request> update (@PathVariable(name = "id") Long id, @RequestBody Request request){
        request.setId(id);
        Request updateRequest = requestService.update(request);
        return ResponseEntity.status(HttpStatus.OK).body(updateRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Request> getById (@PathVariable(name = "id") Long id){
        Request request = requestService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(request);
    }

    @GetMapping("/{id}/request-stages")
    public ResponseEntity<List<RequestStage>> listAllSatgesByIdOfRequestStage(@PathVariable(name = "id") Long id){
        List<RequestStage> stages = requestStageService.listAllByRequestId(id);
        return ResponseEntity.status(HttpStatus.OK).body(stages);
    }

    @GetMapping
    public ResponseEntity<List<Request>> getAll (){
        List<Request> requests = requestService.listAll();
        return ResponseEntity.status(HttpStatus.OK).body(requests);
    }


}
