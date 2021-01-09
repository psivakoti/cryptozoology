package com.learn.cryptozoology.service;

import com.learn.cryptozoology.model.Animal;
import com.learn.cryptozoology.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public Animal save(Animal animal){
        animal.setId(10);
        return animal;
    }


}
