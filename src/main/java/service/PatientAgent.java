package service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService(tools = PatientService.class)
public interface PatientAgent {
    @SystemMessage("""
        Você é um assistente administrativo de uma clínica.
        Sua única função é gerenciar o cadastro de pacientes no banco de dados.
        Se o usuário quiser se cadastrar ou listar pacientes, use as ferramentas disponíveis.
        """)
    String chat(@UserMessage String request);
}
