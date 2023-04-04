<script setup>
import { RouterLink, RouterView } from "vue-router";
</script>

<template>
  <nav>
    <ul id="bandeau">
      <RouterLink to="/">Notre collection</RouterLink>
      <li><a href="accueil.html">Accueil</a></li>
      <li><a href="nos_collections.html">Nos collections</a></li>
      <li><a href="infos_pratiques.html">Informations pratiques</a>
        <ul class="sous">
          <li><a href="infos_pratiques.html#horaires">Horaires</a></li>
          <li><a href="infos_pratiques.html#tarifs">Tarifs</a></li>
          <li><a href="infos_pratiques.html#contact">Contact</a></li>
          <li><a href="infos_pratiques.html#map">Accès</a></li>
        </ul>
      </li>
      <li><a href="acteurs.html">Qui sommes nous ?</a>
        <ul class="sous">
          <li><a href="#">Le musée</a></li>
          <li><a href="#">Nos bénévoles</a></li>
          <li><a href="#">Partenaires</a></li>
        </ul></li>
      <li><a href="histoire.html">Un peu d'histoire</a></li>
      <li><a href="visite_virtuelle.html">Visite virtuelle d'un bloc opératoire</a></li>
    </ul>
  </nav>
</template>



<style scoped>
/*bandeau de navigation*/

#bandeau{
  height: 47px;
  display: flex;  /*répartit les titres sur toute la ligne du bandeau*/
  padding: 0px;
  background-color: rgba(255, 121, 0, 0);
  width: 100%;    /*s'étale sur toute la largeur de l'écran*/
  top: 0px;   /* fixe le bandeau tout en haut de la page*/
  margin: 0 auto;
}

#bandeau li{
  flex: auto;     /*met le texte du bandeau sur 1 ligne en créant des cases de différentes tailles*/
  list-style-type: none;
  text-align: center;
  line-height: auto;
  position: relative;
}

#bandeau a{
  text-transform: uppercase;
  color: black;
  text-decoration: none;
  display: block;
  border-bottom: 2px solid black;
  border-top: 2px solid black;
  padding: 15px 0px;
}

#bandeau a:hover{
  color: rgb(255,121,0);
  border-bottom: 2px solid rgb(255,121,0);
  border-top: 2px solid rgb(255,121,0);
}

nav #bandeau::after{
  display: table;
}

/*sous catégories du bandeau*/

nav ul li:hover .sous{display: block;}     /* affiche le sous menu quand la souri passe sur l'item titre */

.sous{
  display: none;    /* cache le sous menu */
  text-align: center;
  position: absolute;
  z-index: 1000;
  width: 100%;
  background-color: rgba(255, 255, 255, 0.90);
  padding: 0;     /* les "sous cases" sont de la même taille que les "cases titre" */
}

.sous li{
  width: 100%;
  float: none;
}

#bandeau .sous li a{
  font-weight: normal;
  text-transform: capitalize;
  text-align: center;
  border-bottom: none;
  border-top: none;
  padding-top: 6px;
  padding-bottom: 6px;
}

#bandeau .sous li a:hover{
  background-color: white;
  color: rgb(255,121,0);
}
</style>