package com.zmonteiro.dancersapi.repository;

import com.zmonteiro.dancersapi.document.Dancers;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface DancersRepository extends CrudRepository<Dancers, String>{

}
