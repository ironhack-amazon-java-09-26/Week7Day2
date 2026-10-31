package com.ironhack.hellocrud.service;

import com.ironhack.hellocrud.dto.ChangeMonsterHabitatRequest;
import com.ironhack.hellocrud.model.Monster;
import com.ironhack.hellocrud.repository.MonsterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MonsterService {

    private final MonsterRepository monsterRepository;

    public List<Monster> getAll(){
        return monsterRepository.findAll();
    }

    public Monster getById(Integer id){
        Optional<Monster> foundMonsterBox =  monsterRepository.findById(id);
        if (foundMonsterBox.isPresent()){
            return foundMonsterBox.get();
        } else {
            return null;
        }
    }

    public Monster create(Monster monster){
        return monsterRepository.save(monster);
    }

    public Monster updateHabitat(Integer id, ChangeMonsterHabitatRequest request){
        Optional<Monster> foundMonsterBox =  monsterRepository.findById(id);
        if(foundMonsterBox.isPresent()){
            Monster monster = foundMonsterBox.get();
            monster.setHabitat(request.getNewMonsterHabitat());
            return monsterRepository.save(monster);
        } else {
            return null;
        }
    }

    public void deleteById(Integer id){
        monsterRepository.deleteById(id);
    }
}
