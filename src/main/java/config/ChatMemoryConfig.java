package config;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.store.memory.chat.InMemoryChatMemoryStore;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import  dev.langchain4j.memory.ChatMemory;

@ApplicationScoped
public class ChatMemoryConfig {

    @Produces
    public ChatMemory chatMemory(){
        return MessageWindowChatMemory.builder()
                .maxMessages(10)
                .chatMemoryStore(new InMemoryChatMemoryStore())
                .build();
    }

}
