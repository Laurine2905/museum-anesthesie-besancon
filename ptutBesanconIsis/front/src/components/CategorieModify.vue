<template>

  <AddCategorieView @addC="handlerAddCategorie"></AddCategorieView>

 </template>

<script>

import {onMounted, reactive} from "vue";
import AddCategorieView from "../views/AddCategorieView.vue";
const listeC = reactive([]);

function handlerAddCategorie(nom) {
  console.log(nom);
  let myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");
  // --  le libelle de la nouvelle chose est envoyé au serveur
  //  via le body de la req AJAX
  const fetchOptions = {
    method: "POST",
    headers: myHeaders,
    body: JSON.stringify({ nom: nom }),
  };
  fetch(url, fetchOptions)
      .then((response) => {
        return response.json();
      })
      .then((dataJSON) => {
        console.log(dataJSON);
        getCategories();
      })
      .catch((error) => console.log(error));
}

function getCategories() {
  const fetchOptions = { method: "GET" };
  fetch(url, fetchOptions)
      .then((response) => {
        return response.json();
      })
      .then((dataJSON) => {
        console.log(dataJSON);
        // -- vider la liste des choses
        listeC.splice(0, listeC.length);
        // pour chaque donnée renvoyée par l'API
        //  créer un objet instance de la classe Chose
        //  et l'ajouter dans la liste listeC
        dataJSON.forEach((v) => listeC.push(new Categorie(v.id, v.nom)));     //vérifier les attributs de catégorie
      })
      .catch((error) => console.log(error));
}

onMounted(() => {
  getCategories();
});

</script>

<style scoped>

</style>