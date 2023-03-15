package com.example.zoo.service;

import com.example.zoo.entity.Animal;
import com.example.zoo.mapper.AnimalMapper;
import com.example.zoo.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zoo.dto.AnimalPostDto;
import zoo.dto.AnimalResultDto;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService{

    private final AnimalRepository animalRepository;

    private final AnimalMapper animalMapper;

    @Override
    public AnimalResultDto getAnimalById(Long id) {
        Animal animal = animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal with id = " + id + " is not found!"));
        return animalMapper.mapAnimalToDto(animal);
    }

    @Override
    public List<AnimalResultDto> getAllAnimals() {
        return animalMapper.mapAnimalListToDtoList(animalRepository.findAll());
    }

    @Override
    public AnimalResultDto addAnimal(AnimalPostDto animalPostDto) {
        return animalMapper.mapAnimalToDto(
                animalRepository.saveAndFlush(
                        animalMapper.mapAnimalDtoToAnimal(animalPostDto)
                )
        );
//        Animal animal = animalRepository.saveAndFlush(animalMapper.mapAnimalDtoToAnimal(animalPostDto));
//        return animalMapper.mapAnimalToDto(animal);
    }

    @Override
    public AnimalResultDto updateAnimal(AnimalResultDto animalResultDto) {
        Animal animal = animalRepository.saveAndFlush(animalMapper.mapAnimalDtoToAnimal(animalResultDto));
        return animalMapper.mapAnimalToDto(animal);
    }

    @Override
    public String deleteAnimal(Long id) {
        Animal animal = animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal with id = " + id + " is not found!"));
        animalRepository.delete(animal);
        return "Animal with name = " + animal.getName() + " was successfully deleted!";
    }
}
