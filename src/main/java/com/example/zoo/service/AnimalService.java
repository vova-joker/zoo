package com.example.zoo.service;

import com.example.zoo.entity.Animal;
import zoo.dto.AnimalPostDto;
import zoo.dto.AnimalResultDto;

import java.util.List;

public interface AnimalService {

    AnimalResultDto getAnimalById(Long id);

    List<AnimalResultDto> getAllAnimals();

    AnimalResultDto addAnimal(AnimalPostDto animal);

    AnimalResultDto updateAnimal(AnimalResultDto animal);

    String deleteAnimal(Long id);
}
