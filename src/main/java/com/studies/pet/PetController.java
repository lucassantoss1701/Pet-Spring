package com.studies.pet;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("pets")

public class PetController {

    private static final Map<UUID, Pet> db= new HashMap<>();

    @GetMapping
    public List<Pet> findAll(){
        return new ArrayList<>(db.values());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Pet pet){
        pet.setId(UUID.randomUUID());

        db.put(pet.getId(), pet);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void uptade (@PathVariable UUID id, @RequestBody Pet pet){
        pet.setId(id);
        db.computeIfPresent(id, (key, value) -> pet);
    }

    @DeleteMapping("{id}")
    public void delete (@PathVariable UUID id){
        db.remove(id);
    }


}
