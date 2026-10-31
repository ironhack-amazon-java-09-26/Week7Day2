package com.ironhack.hellocrud.controller;

import com.ironhack.hellocrud.dto.ChangeMonsterHabitatRequest;
import com.ironhack.hellocrud.model.Monster;
import com.ironhack.hellocrud.service.MonsterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monsters")
@RequiredArgsConstructor
public class MonsterController {

    private final MonsterService monsterService;


    @GetMapping
    public List<Monster> getAll(){
        return monsterService.getAll();
    }

    @GetMapping("/{id}")
    public Monster getById(@PathVariable Integer id){
        return monsterService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Monster create(@RequestBody Monster monster){
        return monsterService.create(monster);
    }

    @PatchMapping("/{id}")
    public Monster updateHabitat(@PathVariable Integer id, @RequestBody ChangeMonsterHabitatRequest request){
        return monsterService.updateHabitat(id, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        monsterService.deleteById(id);
    }

}
