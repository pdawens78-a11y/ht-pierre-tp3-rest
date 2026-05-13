package htpierretp3rest.htpierretp3rest.guideTouristiqueLlm;

import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.Duration;

@ApplicationScoped
public class LlmClientForGuideTouristique {

    private final GuideTouristique guideTouristique;

    public LlmClientForGuideTouristique() {

        // Récupère la clé secrète pour travailler avec l'API du LLM, mise dans une variable d'environnement
        // du système d'exploitation.
        String key = System.getenv("GEMINI_KEY");

        if (key == null) {
            throw new RuntimeException("Clé GEMINI_KEY manquante !");
        }

        GoogleAiGeminiChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(key)
                .modelName("gemini-2.5-flash")
                .timeout(Duration.ofSeconds(30))
                .build();

        guideTouristique = AiServices.create(
                GuideTouristique.class,
                model
        );
    }

    public String demanderGuide(String lieu) {

        return guideTouristique.guide(lieu);
    }
}