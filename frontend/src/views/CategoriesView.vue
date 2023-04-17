<template>
  <h1>Les catégories</h1>

  <v-btn href="/addCategorie">Ajouter une nouvelle catégorie</v-btn>

  <h1>Liste des catégories</h1>
  <!-- Pour Afficher la liste sous forme de tableau -->

  <table>
    <!-- Les intitulé des colonnes -->
    <tr>
      <th>Nom de la catégorie</th>
      <th>Modifier la catégorie</th>
      <th>Supprimer la catégorie</th>
    </tr>
    <!-- Si le tableau des catégories est vide -->
    <tr v-if="!listeCat">
      <td colspan="3">Veuillez patienter, chargement des catégories en cours...</td>
    </tr>
    <!-- Si le tableau des catégories n'est pas vide -->
    <!-- On met les données dans les colonnes grâce a une boucle -->
    <tr v-else v-for="cat in listeCat" :key="cat.id">
      <td>{{ cat.nom }}</td>
      <td>
        <button @click="ModifierCategorie(cat.id)">Modifier</button>
      </td>
      <td>
        <button @click="SupprimerCategorie(cat.id)">Supprimer</button>
      </td>
    </tr>
  </table>
</template>

<script setup>
import {reactive, onMounted} from "vue";
import {doAjaxRequest} from "@/api";

let listeCat = reactive([]);

const url = "http://localhost:8989/api/categories";

function chargeCategories(url = "http://localhost:8989/api/categories") {
  const fetchOptions = {method: "GET"};
  fetch(url, fetchOptions)
      .then((response) => {
        return response.json();
      })
      .then((dataJSON) => {
        listeCat.splice(0, listeCat.length);
        // pour chaque donnée renvoyée par l'API
        // l'ajouter dans la liste listeCat
        dataJSON._embedded.categories.forEach((v) => listeCat.push(v));
      })
      .catch((error) => console.log(error));
}

// n'a pas pu être vérifié puisque l'affichage du tableau fait des siennes
function SupprimerCategorie(id) {
  doAjaxRequest("http://localhost:8989/api/categories/" + id, {method: "DELETE"})
      .then(chargeCategories)
      .catch((error) => alert(error.message));
}

onMounted(() => {
  chargeCategories();
});

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