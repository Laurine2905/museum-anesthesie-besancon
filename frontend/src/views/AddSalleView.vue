<script setup>
import { ref } from "vue";
const salleNom = ref("");

const url = "http://localhost:8989/api";

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
  fetch(url + "/salles", fetchOptions)
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

  <h1>Ajouter une nouvelle salle</h1>
  <p>Pour ajouter une nouvelle salle remplissez le formulaire ci-dessous et cliquer sur le bouton "submit".</p>
  <p>Une fois la salle ajoutée vous serez en mesure de la renseignée comme étant la salle d'exposition d'un objet.</p>

  <v-sheet width="300" class="mx-auto">
    <v-form @submit.prevent=handlerAddSalle(salleNom)>
      <v-text-field
          v-model="salleNom"
          label="Nom de la salle"
      ></v-text-field>
      <v-btn type="submit" block class="mt-2">Valider</v-btn>
    </v-form>
  </v-sheet>

</template>

<style scoped>

</style>