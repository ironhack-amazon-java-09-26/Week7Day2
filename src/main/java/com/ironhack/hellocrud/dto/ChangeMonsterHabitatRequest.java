package com.ironhack.hellocrud.dto;

import com.ironhack.hellocrud.model.MonsterHabitat;
import lombok.Data;

@Data
public class ChangeMonsterHabitatRequest {
    private Integer id;
    private MonsterHabitat newMonsterHabitat;
}
