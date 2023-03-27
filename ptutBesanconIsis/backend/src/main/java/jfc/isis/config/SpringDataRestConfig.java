package jfc.isis.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Component
@Configuration
public class SpringDataRestConfig
        implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {


    // Autorise les requêtes CORS
    cors.addMapping("/**") // Toutes les adresses sont autorisées
        .allowedOrigins("*") // Toutes les origines sont autorisées
        .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE")// Toutes les méthodes http sont autorisées
        .allowedHeaders("*")
        .allowCredentials(false) // Pas de cookies
        .maxAge(3600); // Durée de la réponse en secondes
    }
}
