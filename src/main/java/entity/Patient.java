package entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

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
}
