<!-- Affichage des objets sous forme d'un tableau --->

<template>
  <v-btn href="/addObjets">Ajouter un nouvel objet à la collection</v-btn>
  <!-- le bouton renvoie vers la vue "AddObjetView" pour pouvoir ajouter un nouvel objet -->

  <h1>Liste des objets</h1>
  <!-- Pour Afficher la liste sous forme de tableau -->
  <!-- On a la possibilité de sélectionner la catégorie des objets que l'on veut voir dans le tableau
   Attention : non fonctionnel -->
  <v-container @submit.prevent="selectCat(categorieSelect)">
    <v-select
        label="Catégorie"
        :items="listeCatNom"
        v-model="categorieSelect"
    ></v-select>
    <v-btn type="submit">submit</v-btn>
  </v-container>
  <br><br>

  <table>
    <!-- Les intitulé des colonnes -->
    <tr>
      <th>Nom</th>
      <th>Catégorie</th>
      <th>Modifier</th>
      <th>Supprimer</th>
    </tr>
    <!-- Si le tableau des objets est vide -->
    <tr v-if="!listeObj">
      <td colspan="4">Veuillez patienter, chargement des objets en cours...</td>
    </tr>
    <!-- Si le tableau des objets n'est pas vide -->
    <!-- On met les données dans les colonnes grâce a une boucle -->
    <tr v-if="categorieSelect == null" v-for="objet in listeObj" :key="objet.id"> <!-- on observe chaque objet de la listeObj -->
      <!-- On affiche pour cahque objet le nom, la catégorie à laquelle il appartient et un boutton de suppression et de modification -->
      <td>{{ objet.nom }}</td>
      <td v-for="cat in nomCats">{{ cat }}</td>
      <td>
        <button @click="ModifierObjet(objet.id)">Supprimer</button>
      </td>
      <td>
        <button @click="SupprimerObjet(objet.id)">Modifier</button> <!-- non fonctionnel -->
      </td>
    </tr>

    <tr v-else v-for="objet in listeObjC" :key="objet.id"> <!-- on observe chaque objet de la listeObj -->
      <!-- On affiche pour cahque objet le nom, la catégorie à laquelle il appartient et un boutton de suppression et de modification -->
      <td>{{ objet.nom }}</td>
      <td>{{ categorieSelect[0] }}</td>
      <td>
        <button @click="ModifierObjet(objet.id)">Supprimer</button>
      </td>
      <td>
        <button @click="SupprimerObjet(objet.id)">Modifier</button> <!-- non fonctionnel -->
      </td>
    </tr>
  </table>
</template>

<script setup>

import {reactive, onMounted} from "vue";

let categorieSelect = reactive([]);
let listeObj = reactive([]);
let listeID = reactive([]);
let nomCats = reactive([]);

const url = "http://localhost:8989/api/objets";

//Pour charger les objets
function chargeObjets(url = "http://localhost:8989/api/objets") {
  const fetchOptions = {method: "GET"};
  fetch(url, fetchOptions)
      .then((response) => {
        return response.json();
      })
      .then((dataJSON) => {
        listeObj.splice(0, listeObj.length); //On vide la liste des objets
        dataJSON._embedded.objets.forEach((v) => listeObj.push(v)); //Puis on la remplie avec les objets présents dans l'API
        for (let indice = 0; indice < listeObj.length; indice++) {
          listeID.push(dataJSON._embedded.objets[indice].id); //Pour chaque objet on récupère son id pour pouvoir ensuite chager sa catégorie
          categorieObjet();
        }
      })
      .catch((error) => console.log(error));
}

//Pour connaître la catégorie associée à chaque objet
function categorieObjet() {
  const fetchOptions = {method: "GET"};
  for (let ident of listeID) {
    fetch("http://localhost:8989/api/objets/" + ident + "/categorie", fetchOptions) //Pour chaque id d'objet relevé précédement on récupère la catégorie associée
        .then((response) => {
          return response.json();
        })
        .then((dataJSON) => {
          nomCats.push(dataJSON.nom); //On récupère tous les noms des catégories
        })
        .catch((error) => console.log(error));
  }
}

let listeCatNom = reactive([]);
let listeCat = reactive([]);

//Pour charger toutes les catégories créées (même si elles ne contiennent pas d'objets) pour les afficher comme une option du select
function chargeCategories(url = "http://localhost:8989/api/categories") {
  const fetchOptions = {method: "GET"};
  fetch(url, fetchOptions)
      .then((response) => {
        return response.json();
      })
      .then((dataJSON) => {
        listeCat.splice(0, listeCat.length); //on vide la liste qui contiendra toutes les catégories
        dataJSON._embedded.categories.forEach((v) => listeCat.push(v)); //on met les catégories dans la liste
        for (let indice = 0; indice < listeCat.length; indice++) {
          //listeCatNom.push(dataJSON._embedded.categories[indice].nom); //Pour chaque catégorie on récupère le nom pour pouvoir les indiquer dans le select
          listeCatNom.push(dataJSON._embedded.categories[indice].nom, dataJSON._embedded.categories[indice].id);
        }
      })
      .catch((error) => console.log(error));
}

function chargeObjetsC(url = "http://localhost:8989/api/" + categorieSelect[1] + "/objet") {
  //objets ou objet ? est-ce que on récupère bien l'id de la catégorie selectionnée ?
  const fetchOptions = {method: "GET"};
  fetch(url, fetchOptions)
      .then((response) => {
        return response.json();
      })
      .then((dataJSON) => {
        listeObjC.splice(0, listeObjC.length); //On vide la liste des objets
        dataJSON._embedded.objets.forEach((v) => listeObjC.push(v)); //Puis on la remplie avec les objets présents dans l'API
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

select {
  color: black;
}

option {
  color: black;
  border: solid 1px black;
}

</style>