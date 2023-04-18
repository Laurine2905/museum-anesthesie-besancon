<!-- Page pour ajouter une nouvelle salle -->
<template>

  <h1>Ajouter une nouvelle salle</h1>
  <p>Pour ajouter une nouvelle salle remplissez le formulaire ci-dessous et cliquer sur le bouton "submit".</p>
  <p>Une fois la salle ajoutée vous serez en mesure de la renseignée comme étant la salle d'exposition d'un objet.</p>

  <v-sheet width="300" class="mx-auto">
    <v-form @submit.prevent=handlerAddSalle(salleNom)> <!-- On ajoute la salle au moment du click sur le bouton valider en bas du formulaire -->
      <!-- Une salle est décrite par son nom uniquement -->
      <v-text-field
          v-model="salleNom"
          label="Nom de la salle"
      ></v-text-field>
      <v-btn type="submit" block class="mt-2">Valider</v-btn>
    </v-form>
  </v-sheet>

</template>

<script setup>
import { ref } from "vue";
const salleNom = ref("");

const url = "http://localhost:8989/api";

//Pour ajouter une salle
function handlerAddSalle(nom) {
  let myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");
  const fetchOptions = {
    method: "POST",
    headers: myHeaders,
    body: JSON.stringify({nom: nom}),
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

<style scoped>

</style>