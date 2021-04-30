package com.zmonteiro.dancersapi.service;

import com.zmonteiro.dancersapi.document.Dancers;
import com.zmonteiro.dancersapi.repository.DancersRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DancersService {
    private final DancersRepository dancersRepository;

    public DancersService(DancersRepository dancersRepository){
        this.dancersRepository = dancersRepository;
    }

    public Flux<Dancers> findAll(){
        return Flux.fromIterable(this.dancersRepository.findAll());
    }

    public Mono<Dancers> findById(String id){
        return Mono.justOrEmpty(this.dancersRepository.findById(id));
    }

    public Mono<Dancers> save(Dancers dancer){
        return Mono.justOrEmpty(this.dancersRepository.save(dancer));
    }

    public Mono<Boolean> deleteById (String  id){
        dancersRepository.deleteById(id);
        return Mono.just(true);
    }
}
