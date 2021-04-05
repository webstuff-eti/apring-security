package eti.br.webstuff.apispringbootaws.resource;


import eti.br.webstuff.apispringbootaws.entity.RequestStage;
import eti.br.webstuff.apispringbootaws.service.RequestStageService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class RequestStageResource {

    @Autowired
    private RequestStageService requestStageService;


    @PostMapping
    public ResponseEntity<RequestStage> save(@RequestBody RequestStage requestStage){
        RequestStage createdRequestStage = requestStageService.save(requestStage);
        return  ResponseEntity.status(HttpStatus.CREATED).body(createdRequestStage);
    }

    @GetMapping
    public ResponseEntity<RequestStage> grtById(@PathVariable("id") Long id) throws NotFoundException {
        RequestStage  stage = requestStageService.getById(id);
        return  ResponseEntity.ok(stage);
    }


}
