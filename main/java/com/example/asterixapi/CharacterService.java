package com.example.asterixapi;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Data
public class CharacterService {

    private final CharacterRepo repo;

    public List<Character> getAllCharacter() {
        return repo.findAll();
    }

    public Character createCharacter(Character character) {
        return repo.save(character);
    }

    public void deleteCharacter(String id) {
        repo.deleteById(id);
    }

    public Character updateCharacter(Character updatedCharacter, String id) {
        Optional<Character> existingCharacterOptional = repo.findById(id);

        if (existingCharacterOptional.isPresent()) {
            Character existingCharacter = existingCharacterOptional.get();
            Character updatedRecord = new Character(
                    existingCharacter.id(),
                    updatedCharacter.name(),
                    updatedCharacter.age(),
                    updatedCharacter.profession()
            );
            return repo.save(updatedRecord);
        } else {
            throw new RuntimeException("Character with id " + id + " not found");
        }
    }

}
