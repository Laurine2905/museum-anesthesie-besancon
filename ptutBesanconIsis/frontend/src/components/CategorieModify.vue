<template>

  <AddCategorieView @addCat="handlerAddCategorie"></AddCategorieView>

 </template>

<script>

// PROBLEME : @addCat ne fonctionne pas, à voir avec les filles

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


</script>

<style scoped>

</style>