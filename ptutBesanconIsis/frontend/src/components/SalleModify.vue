<template>

</template>

<script setup>

import {onMounted, reactive} from "vue";
const listeS = reactive([]);

const url = "http://localhost:8989/api";

function getSalles() {
  const fetchOptions = { method: "GET" };
  fetch(url + "/salles" , fetchOptions)
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