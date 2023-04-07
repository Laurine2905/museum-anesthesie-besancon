package jfc.isis.rest;

import jfc.isis.dao.UtilisateurRepository;
import jfc.isis.service.UtilisateurService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path = "/service/utilisateur")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;
    private final ModelMapper mapper;

    public UtilisateurController(UtilisateurService utilisateurService, ModelMapper mapper) {
        this.utilisateurService = utilisateurService;
        this.mapper = mapper;
    }

    @PostMapping("login")
    public UtilisateurRepository log(@RequestParam String login, @RequestParam String mdp) throws Exception {
        var utilisateur = utilisateurService.log(login,mdp);
        return mapper.map(utilisateur,UtilisateurRepository.class);
    }
    //Exemple : http://localhost:8989/service/utilisateur/login?login=musee&mdp=besancon

    @RequestMapping("/loginView")
    public ModelAndView afficherloginView() {
        ModelAndView mav = new ModelAndView("loginView");
// Ajouter ici des données à passer à la vue, si nécessaire
        return mav;
    }

}
