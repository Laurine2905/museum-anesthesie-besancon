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

const url = "http://localhost:8989/api/salles";

let listeS = reactive([]);

function chargeSalles(url = "http://localhost:8989/api/salles") {
  const fetchOptions = {method: "GET"};
  fetch(url, fetchOptions)
      .then((response) => {
        return response.json();
      })
      .then((dataJSON) => {
        listeS.splice(0, listeS.length);
        // pour chaque donnée renvoyée par l'API
        // l'ajouter dans la liste listeCat
        dataJSON._embedded.salles.forEach((v) => listeS.push(v));
      })
      .catch((error) => console.log(error));
}

function SupprimerObjet(id) {
  console.log(id);
  const fetchOptions = {method: "DELETE"};
  fetch("http://localhost:8989/api/salles/" + id, fetchOptions)
      .then((response) => {
        return response.json();
      })
      .then((dataJSON) => {
        console.log(dataJSON);
        chargeSalles();
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