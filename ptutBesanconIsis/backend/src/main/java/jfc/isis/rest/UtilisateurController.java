package jfc.isis.rest;

import jfc.isis.dao.UtilisateurRepository;
import jfc.isis.service.UtilisateurService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/services/utilisateur")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;
    private final ModelMapper mapper;

    public UtilisateurController(UtilisateurService utilisateurService, ModelMapper mapper) {
        this.utilisateurService = utilisateurService;
        this.mapper = mapper;
    }

    @PostMapping("log")
    public UtilisateurRepository log(@RequestParam String login, @RequestParam String mdp) throws Exception {
        var utilisateur = utilisateurService.log(login,mdp);
        return mapper.map(utilisateur,UtilisateurRepository.class);
    }

}
