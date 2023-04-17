<script>

// PROBLEME : @addCat ne fonctionne pas, à voir avec les filles
// de même pour @delteCat
// Ces deux pb sont temporairement solutionnés en écrivant les fonctions directement dans la view

import CategoriesView from "@/views/CategoriesView.vue";
import AddCategorieView from "@/views/AddCategorieView.vue";

const url = "http://localhost:8989/api/categories";

function handlerAddCategorie(nom, description, urlPhoto) {
  console.log(nom);
  let myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");
  console.log(myHeaders);
  // --  le libelle de la nouvelle chose est envoyé au serveur
  //  via le body de la req AJAX
  const fetchOptions = {
    method: "POST",
    headers: myHeaders,
    body: JSON.stringify({ nom: nom, description: description, urlPhoto: urlPhoto }),
  };
  fetch(url, fetchOptions)
      .then((response) => {
        return response.json();
      })
      .then((dataJSON) => {
        console.log(dataJSON);
      })
      .catch((error) => console.log(error));
}


function handlerDeleteCategorie(id) {
  console.log(id);
  const fetchOptions = {
    method: "DELETE",
  };
  // -- l'id de la chose à supprimer doit être
  //  ajouté à la fin de l'url
  fetch(url + "/" + id, fetchOptions)
      .then((response) => {
        return response.json();
      })
      .then((dataJSON) => {
        console.log(dataJSON);
      })
      .catch((error) => console.log(error));
}

</script>

<template>

  <AddCategorieView @addCat="handlerAddCategorie"></AddCategorieView>
  <CategoriesView @deleteCat="handlerDeleteCategorie"></CategoriesView>

</template>

<style scoped>

</style>