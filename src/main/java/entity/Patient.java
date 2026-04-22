package entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.panache.common.Sort;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.List;

@Entity
public class Patient extends PanacheEntity {

    public String name;
    public long weight;
    public long height;
    public int age;
    public String restrictions;

    @Enumerated(EnumType.STRING)
    public CaloricGoal caloricGoal;

    public Patient(){}

    public Patient(String name, long weight, long height, CaloricGoal caloricGoal) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.caloricGoal = caloricGoal;
    }

    public static Patient findByName(String name) {
        return find("name",name).firstResult();
    }

    public static List<Patient> filterByCaloricGoal(CaloricGoal caloricGoal) {
        return list("caloricGoal", Sort.by("name"),caloricGoal);
    }
}
