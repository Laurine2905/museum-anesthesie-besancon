package jfc.isis.rest;

import jfc.isis.dao.CategorieRepository;
import jfc.isis.dao.UtilisateurRepository;
import jfc.isis.service.CategorieService;
import jfc.isis.service.UtilisateurService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/service/categorie")
public class CategorieController {

    private final CategorieService categorieService;
    private final ModelMapper mapper;

    public CategorieController(CategorieService categorieService, ModelMapper mapper) {
        this.categorieService = categorieService;
        this.mapper = mapper;
    }

    @GetMapping("listeCategories")
    public CategorieRepository listeCategories(){
        var categories = categorieService.listeDesCategoriesService();
        return mapper.map(categories,CategorieRepository.class);
    }
    //Exemple : http://localhost:8989/service/categorie/listeCategories

}
