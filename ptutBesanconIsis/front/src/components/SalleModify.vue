<template>

  <AddSalleView @addS="handlerAddSalle"></AddSalleView>

</template>

<script>

import {onMounted, reactive} from "vue";
import AddSalleView from "../views/AddSalleView.vue";

const listeS = reactive([]);

function handlerAddSalle(nom) {
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
        getSalles();
      })
      .catch((error) => console.log(error));
}

function getSalles() {
  const fetchOptions = { method: "GET" };
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
        dataJSON.forEach((v) => listeS.push(new Sale(v.id, v.nom)));
      })
      .catch((error) => console.log(error));
}

onMounted(() => {
  getSalles();
});

</script>

<style scoped>

</style>