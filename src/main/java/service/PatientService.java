package service;

import dev.langchain4j.agent.tool.Tool;
import dto.CreatePatientDTO;
import entity.Patient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class PatientService {

    @Tool("Cria um novo paciente")
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

    @Tool("Retorna as informações de um paciente com base no Id dele (PatientId)")
    public Patient findById(long id){
        return Patient.findById(id);
    }
    @Tool("Retorna uma lista de todos os pacientes que estão no banco")
    public List<Patient> getAll(){return Patient.listAll();}

    @Tool("Exclui um paciente do banco com base no Id dele (PatientId)")
    @Transactional
    public void deleteById(long id){Patient.deleteById(id);}

    @Tool("Retorna as informações de um paciente com base no nome dele (String name)")
    public Patient findByName(String name){return Patient.findByName(name);}
}
