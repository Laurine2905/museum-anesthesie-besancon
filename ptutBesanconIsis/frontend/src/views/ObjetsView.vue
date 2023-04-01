<template>

  <v-btn href="/addObjets">Ajouter un nouvel objet à la collection</v-btn>

  <!--

  <label for="categorie">Sélectionner la catégorie d'objet voulue : </label>
  <select id="categorie" name="categorie">
    <option value="test" selected="selected">Testdfghjk</option>
    <option value="test1">Test</option>
    <option value="test2">Test</option>
  </select>
-->

  <!--
<option v-for="categorie of listeCat" :key="categorie.id">{{categorie.nom}}</option>
  -->

  <!--

  <v-container fluid>
    <v-row align="center">
      <v-col
          class="d-flex"
          cols="12"
          sm="6"
      >
        <v-select
            :items="items"      ###liste des catégories
            label="Catégories"
        ></v-select>
      </v-col>
    </v-row>
  </v-container>

  -->

  <h1>Liste des objets</h1>
  <!-- Pour Afficher la liste sous forme de tableau -->

  <table>
    <!-- Les intitulé des colonnes -->
    <tr>
      <th>Nom</th>
      <th>Catégorie</th>
      <th>Modifier</th>
      <th>Supprimer</th>
    </tr>
    <!-- Si le tableau des catégories est vide -->
    <tr v-if="!listeObj">
      <td colspan="4">Veuillez patienter, chargement des objets en cours...</td>
    </tr>
    <!-- Si le tableau des objets n'est pas vide -->
    <!-- On met les données dans les colonnes grâce a une boucle -->
    <tr v-for="objet in listeObj" :key="objet.id">
      <td>{{ objet.nom }}</td>
      <td>{{ categorieObjet(objet.id) }}</td>
      <td>
        <button @click="ModifierObjet(objet.id)">Supprimer</button>
      </td>
      <td>
        <button @click="SupprimerObjet(objet.id)">Modifier</button>
      </td>
    </tr>
  </table>

</template>


<script setup>

// script pour v-select

//export default {
//  data: () => ({
//    items: ['Foo', 'Bar', 'Fizz', 'Buzz'],
//  }),
//}

import { reactive, onMounted } from "vue";

let listeObj = reactive([]);
let nomCat = reactive([]);

const url = "http://localhost:8989/api/objets";
function chargeObjets(url = "http://localhost:8989/api/objets") {
  const fetchOptions = { method: "GET" };
  fetch(url, fetchOptions)
      .then((response) => {
        return response.json();
      })
      .then((dataJSON) => {
        listeObj = dataJSON._embedded.objets;
        console.log(listeObj);
      })
      .catch((error) => console.log(error));
}


function categorieObjet(id){
  console.log("categorieObjet");
  const fetchOptions = { method: "GET" };
  console.log("http://localhost:8989/api/objets/" + id + "/categorie");
  fetch("http://localhost:8989/api/objets/" + [] + "/categorie", fetchOptions)
      .then((response) => {
        return response.json();
      })
      .then((dataJSON) => {
        nomCat = dataJSON.nom;
        console.log(nomCat);
      })
      .catch((error) => console.log(error));
}


onMounted(() => {
  chargeObjets();
  categorieObjet();
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

select{
  color: black;
}

option{
  color : black;
  border : solid 1px black;
}


</style>