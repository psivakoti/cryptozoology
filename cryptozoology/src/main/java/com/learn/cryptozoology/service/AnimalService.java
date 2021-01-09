package com.learn.cryptozoology.service;

import com.learn.cryptozoology.model.Animal;
import com.learn.cryptozoology.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public Animal save(Animal animal){
        animal.setId(UUID.randomUUID().toString());
        return animal;
    }


}
