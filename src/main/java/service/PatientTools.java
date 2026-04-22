package service;

import dev.langchain4j.agent.tool.Tool;
import dto.CreatePatientDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;


@ApplicationScoped
public class PatientTools {

    @Inject
    PatientService patientService;

    @Tool("Retorna as informações de um paciente com base no Id dele (PatientId)")
    public String findById(long id){
        try {
            return "Aqui está o paciente do sistema: " + patientService.findById(id);
        }catch (Exception e ){
            return  "Não foi possivel retornar o paciente apresentou este erro: " + e;
        }
    }

    @Tool("Retorna uma lista de todos os pacientes que estão no banco")
    public String getAllPatients(){
        try {
            return "Aqui está uma lista com todos os pacientes do sistema: " + patientService.getAll();
        }catch (Exception e ){
            return  "Não foi possivel retornar todos os pacientes apresentou este erro: " + e;
        }
    }

    @Tool("Exclui um paciente do banco com base no Id dele (PatientId)")
    @Transactional
    public String deleteById(long id){
        try {
            return "Paciente deletado com sucesso";
        }catch (Exception e ){
            return  "Não foi possivel retornar todos os pacientes apresentou este erro: " + e;
        }
    }
    @Tool("Retorna as informações de um paciente com base no nome dele (String name)")
    public String findByName(String name){
        try {
            return "Dados do paciente: " + patientService.findByName(name);
        }catch (Exception e ){
            return  "Não foi achar o paciente apresentou este erro: " + e;
        }
    }


    @Tool("Cria um novo paciente")
    public String createPatient(CreatePatientDTO dto){
        try {
            return "Paciente criado no sistema, este é o paciente: " + patientService.createPatient(dto);
        }catch (Exception e ){
            return  "Não foi possivel criar o paciente apresentou este erro: " + e;
        }

    }



}
