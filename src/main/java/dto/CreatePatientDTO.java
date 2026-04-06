package dto;

import dev.langchain4j.model.output.structured.Description;
import entity.CaloricGoal;

public record CreatePatientDTO(
         String name,

         @Description("Peso em kilos (ex: 80)")
         long weight,

         @Description("Altura em centímetros (ex: 180)")
         long height,

         @Description("Idade em anos")
         int age,

         @Description("Lista de alergias ou restrições alimentares separadas por vírgula")
         String restrictions,

         CaloricGoal caloricGoal){}
