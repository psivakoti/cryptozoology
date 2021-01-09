package com.learn.cryptozoology.controller;

import com.learn.cryptozoology.model.Animal;
import com.learn.cryptozoology.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CryptoZoologyController {

    @Autowired
    private AnimalService animalService;


    @PostMapping("/api/animals")
    @ResponseStatus(HttpStatus.CREATED)
    public Animal addAnimal(@RequestBody Animal animal){
        return animalService.save(animal);
    }

}
