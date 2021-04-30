package com.zmonteiro.dancersapi.controller;

import com.zmonteiro.dancersapi.document.Dancers;
import com.zmonteiro.dancersapi.repository.DancersRepository;
import com.zmonteiro.dancersapi.service.DancersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.zmonteiro.dancersapi.constants.DancersConstant.DANCERS_ENDPOINT_LOCAL;

@SuppressWarnings("ALL")
@RestController
@Slf4j
public class DancersController {

    DancersService dancersService;
    DancersRepository dancersRepository;

    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(DancersController.class);

    public DancersController(DancersService dancersService, DancersRepository dancersRepository){
        this.dancersRepository = dancersRepository;
        this.dancersService = dancersService;
    }

    @GetMapping(DANCERS_ENDPOINT_LOCAL)
    public Flux<Dancers> getAllItems(){
        log.info("Requesting the list of all dancers");

        return dancersService.findAll();
    }

    @GetMapping(DANCERS_ENDPOINT_LOCAL+"/id")
    public Mono<ResponseEntity<Dancers>> findByIdDancer(@PathVariable String id){
        log.info("Requesting dancer by id {}", id);

        return dancersService.findById(id)
                .map((item)-> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(DANCERS_ENDPOINT_LOCAL)
    @ResponseStatus(code=HttpStatus.CREATED)
    public Mono<Dancers> createDancer (@RequestBody Dancers dancers){
        log.info("A new dancer was created!");

        return dancersService.save(dancers);
    }

    @GetMapping(DANCERS_ENDPOINT_LOCAL+"/id")
    @ResponseStatus(code=HttpStatus.CONTINUE)
    public Mono<HttpStatus> deleteByIdDancer(@PathVariable String id){
        dancersService.deleteById(id);
        log.info("deleting dancer by id {}", id);

        return Mono.just(HttpStatus.CONTINUE);
    }

}
