package security;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.guardrail.OutputGuardrail;
import dev.langchain4j.guardrail.OutputGuardrailResult;
import jakarta.inject.Inject;

public class ToneJudgeGuard implements OutputGuardrail {

    @Inject
    ToneJudge judge;

    @Override
    public OutputGuardrailResult validate(AiMessage responseFromLLM) {
        if(!judge.isProfessional(responseFromLLM.text())){
            return reprompt(responseFromLLM.text(), "Sua resposta foi informal demais, reescreva mantendo a polidez");
        }
        return OutputGuardrailResult.success();
    }
}
