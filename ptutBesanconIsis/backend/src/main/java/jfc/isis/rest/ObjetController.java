package jfc.isis.rest;

import jfc.isis.dao.CategorieRepository;
import jfc.isis.dao.ObjetRepository;
import jfc.isis.service.CategorieService;
import jfc.isis.service.ObjetService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/service/objet")
public class ObjetController {


    private final ObjetService objetService;
    private final ModelMapper mapper;

    public ObjetController(ObjetService objetService, ModelMapper mapper) {
        this.objetService = objetService;
        this.mapper = mapper;
    }

    @GetMapping("objetsParCategorie")
    public ObjetRepository objetsParCategorie(@RequestParam int idDeLaCategorie){
        var objets = objetService.getObjetsParCategorie(idDeLaCategorie);
        return mapper.map(objets,ObjetRepository.class);
    }
    //Exemple : http://localhost:8989/service/objet/objetsParCategorie?idDeLaCategorie=1


}
