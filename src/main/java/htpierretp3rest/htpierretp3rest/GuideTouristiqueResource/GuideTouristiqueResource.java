package htpierretp3rest.htpierretp3rest.GuideTouristiqueResource;

import htpierretp3rest.htpierretp3rest.guideTouristiqueLlm.LlmClientForGuideTouristique;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/guide")
public class GuideTouristiqueResource {


    @Inject
    private LlmClientForGuideTouristique llmClient;

    // @param villeOuPays nom du lieu
    // @return le lieu demandé

    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String endroitsDeVisite(
            @PathParam("ville_ou_pays") String villeOuPays) {

//        return villeOuPays;
//        return new String[]{villeOuPays};
        return llmClient.demanderGuide(villeOuPays);
    }
}