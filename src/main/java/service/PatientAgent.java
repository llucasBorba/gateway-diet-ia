package service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.guardrail.InputGuardrails;
import dto.ResponseDTO;
import io.quarkiverse.langchain4j.RegisterAiService;
import io.quarkiverse.langchain4j.mcp.runtime.McpToolBox;
import security.InjectionGuard;

@RegisterAiService()
public interface PatientAgent {
    @SystemMessage("""
        Você é um assistente administrativo de uma clínica.
        Sua única função é gerenciar o cadastro de pacientes no banco de dados.
        Se o usuário quiser se cadastrar ou listar pacientes, use as ferramentas disponíveis.
        """)
    @McpToolBox("patient-server")
    @InputGuardrails(InjectionGuard.class)
    String chat(@UserMessage String request);
}
