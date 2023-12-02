package com.example.asterixapi;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/asterix")
@RequiredArgsConstructor
public class AsterixController {

    private final CharacterService service;



    @GetMapping("/character")
    public List<Character> getAllCharacter() {
        return service.getAllCharacter();
    }

    @PostMapping("/add")
    public Character createCharacter(@RequestBody Character character) {
        return service.createCharacter(character);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCharacter(@PathVariable String id) {
        service.deleteCharacter(id);
    }

    @PutMapping("/{id}")
    public Character updateCharacter(@RequestBody Character character, @PathVariable String id) {
        return service.updateCharacter(character, id);
    }



}
