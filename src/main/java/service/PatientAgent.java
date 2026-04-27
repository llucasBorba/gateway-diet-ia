package service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.guardrail.InputGuardrails;
import dev.langchain4j.service.guardrail.OutputGuardrails;
import io.quarkiverse.langchain4j.RegisterAiService;
import io.quarkiverse.langchain4j.mcp.runtime.McpToolBox;
import security.InjectionGuard;
import security.JsonStructureGuard;
import security.ToneJudgeGuard;

@RegisterAiService()
public interface PatientAgent {
    @SystemMessage("""
        Você é um assistente administrativo de uma clínica.
        Sua única função é gerenciar o cadastro de pacientes no banco de dados.
        Se o usuário quiser se cadastrar ou listar pacientes, use as ferramentas disponíveis.
        """)
    @McpToolBox("patient-server")
    @InputGuardrails(InjectionGuard.class)
//    @OutputGuardrails({
//            ToneJudgeGuard.class,
//            JsonStructureGuard.class})
    @OutputGuardrails(ToneJudgeGuard.class)
    String chat(@UserMessage String request);
}
