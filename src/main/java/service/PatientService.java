package service;

import dev.langchain4j.agent.tool.Tool;
import dto.CreatePatientDTO;
import entity.CaloricGoal;
import entity.Patient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class PatientService {


    @Transactional
    public Patient createPatient(CreatePatientDTO dto){
        Patient patient = new Patient();
        patient.age = dto.age();
        patient.name = dto.name();
        patient.caloricGoal = dto.caloricGoal();
        patient.height = dto.height();
        patient.weight = dto.weight();
        patient.restrictions = dto.restrictions();
        patient.persist();

        return patient;
    }

    public Patient findById(long id){
        return Patient.findById(id);
    }
    public List<Patient> getAll(){return Patient.listAll();}

    @Transactional
    public void deleteById(long id){Patient.deleteById(id);}

    public Patient findByName(String name){return Patient.findByName(name);}

    public List<Patient> filterByCaloricgoal(CaloricGoal caloricGoal){return Patient.filterByCaloricGoal(caloricGoal);}
}
