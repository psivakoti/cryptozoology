package com.learn.cryptozoology;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.cryptozoology.model.Animal;
import com.learn.cryptozoology.model.Habitat;
import com.learn.cryptozoology.repository.HabitatRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class CryptoZoologyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    HabitatRepository habitatRepository;

    @Test
    void addAnimalTest() throws Exception {


        Habitat habitat = new Habitat("Forest");
       // habitatRepository.save(habitat);
        Animal animal = new Animal("Elephant","Walking","Unhappy");
        animal.setHabitat(habitat);

        mockMvc.perform(post("/api/animals")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(animal)))
        .andExpect(status().isCreated())
        .andDo(print())
        .andExpect(jsonPath("$.id").exists())
        .andExpect(jsonPath("$.name").value("Elephant"))
        .andExpect(jsonPath("$.type").value("Walking"))
        .andExpect(jsonPath("$.mood").value("Unhappy"))
        .andExpect(jsonPath("$.habitat.name").value("Forest"));
    }

}
