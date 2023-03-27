<template>

  <h1>Les salles</h1>

  <v-btn href="/addSalle">Ajouter une nouvelle salle</v-btn>

  <h1>Liste des salles</h1>
  <!-- Pour Afficher la liste sous forme de tableau -->

  <table>
    <!-- Les intitulé des colonnes -->
    <tr>
      <th>Nom de la salle</th>
      <th>Supprimer</th>
    </tr>
    <!-- Si le tableau des catégories est vide -->
    <tr v-if="!listeS">
      <td colspan="2">Veuillez patienter, chargement des salles en cours...</td>
    </tr>
    <!-- Si le tableau des objets n'est pas vide -->
    <!-- On met les données dans les colonnes grâce a une boucle -->
    <tr v-for="salle of listeS" :key="salle.id">
      <td>{{ salle.nom }}</td>
      <td>
        <button @click="SupprimerObjet(salle.id)">Supprimer</button>
      </td>
    </tr>
  </table>

</template>

<script setup>
import {onMounted, reactive} from "vue";
const url = "http://localhost:8989/api";

//let listeS = reactive([]);


import {BACKEND, doAjaxRequest} from "../api";
// Pour réinitialiser le formuaire
const salleVide = {
  salleNom: ""
};
let data = reactive({
  // Les données saisies dans le formulaire
  formulaireSalle: { ...salleVide },
  // La liste des catégories affichée sous forme de table
  listeS: []
});
function chargeSalles() {
  console.log("coucou chargerSalles");
  // Appel à l'API pour avoir la liste des catégories
  // Trié par code, descendant
  // Verbe HTTP GET par défaut
  doAjaxRequest(BACKEND + "/api/salles")
      .then((json) => {
        data.listeSalles = json._embedded.salles;
      })
      .catch((error) => alert(error.message));
}


function getSalles() {
  const fetchOptions = { method: "GET", mode: "no-cors" };
  console.log("coucou getSalles");
  fetch(url, fetchOptions)
      .then((response) => {
        return response.json();
      })
      .then((dataJSON) => {
        console.log(dataJSON);
        // -- vider la liste des choses
        listeS.splice(0, listeS.length);
        // pour chaque donnée renvoyée par l'API
        //  créer un objet instance de la classe Chose
        //  et l'ajouter dans la liste listeC
        dataJSON.forEach((v) => listeS.push(new Salle(v.id, v.salleNom)));
      })
      .catch((error) => console.log(error));
}


// A l'affichage du composant, on affiche la liste
onMounted(chargeSalles);

</script>

<style scoped>

td,
th {
  border: 1px solid #ddd;
  padding: 8px;
}
th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #232623;
  color: rgb(255, 255, 255);
}

</style>