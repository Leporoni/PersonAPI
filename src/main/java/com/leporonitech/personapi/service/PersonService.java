package com.leporonitech.personapi.service;

import com.leporonitech.personapi.dto.MessageResponseDTO;
import com.leporonitech.personapi.dto.request.PersonDTO;
import com.leporonitech.personapi.entity.Person;
import com.leporonitech.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person savedPerson = personRepository.save(personDTO);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();

    }
}

