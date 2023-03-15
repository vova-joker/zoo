package com.example.zoo.mapper;

import com.example.zoo.entity.Animal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import zoo.dto.AnimalPostDto;
import zoo.dto.AnimalResultDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnimalMapper {

    AnimalResultDto mapAnimalToDto(Animal animal);

    List<AnimalResultDto> mapAnimalListToDtoList(List<Animal> animals);

    Animal mapAnimalDtoToAnimal(AnimalResultDto animalResultDto);

    Animal mapAnimalDtoToAnimal(AnimalPostDto animalResultDto);

    List<Animal> mapAnimalDtoListToAnimalList(List<AnimalResultDto> animalResultDtos);


}
