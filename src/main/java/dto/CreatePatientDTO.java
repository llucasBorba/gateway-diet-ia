package dto;

import entity.CaloricGoal;

public record CreatePatientDTO(
         String name,
         long weight,
         long height,
         int age,
         String restrictions,
         CaloricGoal caloricGoal){}
