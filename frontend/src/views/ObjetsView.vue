<template>

  <v-btn href="/addObjets">Ajouter un nouvel objet à la collection</v-btn>


  <h1>Liste des objets</h1>
  <!-- Pour Afficher la liste sous forme de tableau -->


  <v-select
      label="Catégorie"
      :items="listeCatNom"
  ></v-select>


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
      <td v-for ="cat in nomCats">{{ cat }} </td>
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

import { reactive, onMounted } from "vue";

let listeObj = reactive([]);
let listeID = reactive([]);
let nomCats = reactive([]);

const url = "http://localhost:8989/api/objets";
function chargeObjets(url = "http://localhost:8989/api/objets") {
  const fetchOptions = { method: "GET" };
  fetch(url, fetchOptions)
      .then((response) => {
        return response.json();
      })
      .then((dataJSON) => {
        listeObj.splice(0, listeObj.length);
        dataJSON._embedded.objets.forEach((v) => listeObj.push(v));
        console.log(listeObj);
        for(let indice = 0; indice < listeObj.length; indice++){
          listeID.push(dataJSON._embedded.objets[indice].id);
          console.log(listeID);
          categorieObjet();
        }
      })
      .catch((error) => console.log(error));
}

function categorieObjet(){
  console.log("categorieObjet");
  const fetchOptions = { method: "GET" };
  for(let ident of listeID){
    console.log("http://localhost:8989/api/objets/" + ident + "/categorie");
    fetch("http://localhost:8989/api/objets/" + ident + "/categorie", fetchOptions)
        .then((response) => {
          return response.json();
        })
        .then((dataJSON) => {
          nomCats.push(dataJSON.nom);
          console.log(nomCats);
        })
        .catch((error) => console.log(error));
  }
}


let listeCatNom = reactive([]);
let listeCat = reactive([]);

function chargeCategories(url = "http://localhost:8989/api/categories") {
  const fetchOptions = {method: "GET"};
  fetch(url, fetchOptions)
      .then((response) => {
        return response.json();
      })
      .then((dataJSON) => {
        listeCat.splice(0, listeCat.length);
        dataJSON._embedded.categories.forEach((v) => listeCat.push(v));
        for(let indice = 0; indice < listeCat.length; indice++){
          listeCatNom.push(dataJSON._embedded.categories[indice].nom);
        }
      })
      .catch((error) => console.log(error));
}



onMounted(() => {
  chargeObjets();
  categorieObjet();
  chargeCategories()
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