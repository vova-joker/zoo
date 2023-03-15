package com.example.zoo.controller;

import com.example.zoo.service.AnimalService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import zoo.api.AnimalApi;
import zoo.dto.AnimalPostDto;
import zoo.dto.AnimalResultDto;
import zoo.dto.ProductPostDto;
import zoo.dto.ProductResultDto;

import java.util.List;

@RestController
@Api(tags = {"animal"})
@RequiredArgsConstructor
public class AnimalController implements AnimalApi {

    private final AnimalService animalService;


    @Override
    public ResponseEntity<AnimalResultDto> addAnimal(AnimalPostDto animalPostDto) {
        return ResponseEntity.ok(animalService.addAnimal(animalPostDto));
    }

    @Override
    public ResponseEntity<String> deleteAnimal(Long id) {
        return ResponseEntity.ok(animalService.deleteAnimal(id));
    }

    @Override
    public ResponseEntity<List<AnimalResultDto>> getAllAnimals() {
        return ResponseEntity.ok(animalService.getAllAnimals());
    }

    @Override
    public ResponseEntity<AnimalResultDto> getAnimalById(Long id) {
        return ResponseEntity.ok(animalService.getAnimalById(id));
    }

    @Override
    public ResponseEntity<AnimalResultDto> updateAnimal(AnimalResultDto animalResultDto) {
        return ResponseEntity.ok(animalService.updateAnimal(animalResultDto));
    }
}
