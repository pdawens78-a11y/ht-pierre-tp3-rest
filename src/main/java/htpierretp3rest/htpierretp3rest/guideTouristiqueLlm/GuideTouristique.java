package htpierretp3rest.htpierretp3rest.guideTouristiqueLlm;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface GuideTouristique {

    @SystemMessage("""
               Tu es un guide touristique.
            
                        Donne les 2 principaux endroits à visiter dans le lieu demandé
                        ainsi que le prix moyen d'un repas dans la devise locale.
                        
                        N'utilise pas Markdown
            
                        Réponds exactement au format JSON suivant :
            
                        {
                          "ville_ou_pays": "nom de la ville ou du pays",
                          "endroits_a_visiter": ["endroit 1", "endroit 2"],
                          "prix_moyen_repas": "<prix> <devise>"
                        }
            
                        Exemple :
            
                        {
                          "ville_ou_pays": "Nice",
                          "endroits_a_visiter": ["Promenade des Anglais", "Vieux Nice"],
                          "prix_moyen_repas": "20 EUR"
                        }
                        ""\")
            """)
    String guide(@UserMessage String lieu);
}