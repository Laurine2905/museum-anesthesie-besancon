<script setup>
import { ref } from "vue";
// -- donnée réactive pour la saisie de la nouvelle catégorie
const nom = ref("");
const description = ref("");
const urlPhoto = ref("");


//const emit = defineEmits(['addCat']);

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

<template>

  <h1>Ajouter une nouvelle catégorie</h1>
  <p>Pour ajouter une nouvelle catégorie remplissez le formulaire ci-dessous et cliquer sur le bouton "valider".</p>
  <p>Une fois la catégorie ajoutée vous serez en mesure de la renseignée comme étant la catégorie d'un objet.</p>

  <v-sheet width="500" class="mx-auto">
    <v-form @submit.prevent=handlerAddCategorie(nom,description,urlPhoto)>  <!-- normalement on met $ devant emit -->
      <v-text-field
          v-model="nom"
          label="Nom de la catégorie"
      ></v-text-field>
      <v-text-field
          v-model="description"
          label="Description de la catégorie"
      ></v-text-field>
      <!--
          <v-textarea
              name="description"
              variant="filled"
              label="Description"
              auto-grow
              model-value=""
          ></v-textarea>
    -->
          <v-text-field
              v-model="urlPhoto"
              label="Lien de l'image"
          ></v-text-field>
          <v-btn type="submit" block class="mt-2">Valider</v-btn>
        </v-form>
      </v-sheet>

      <!-- voir error-message pour textarea  et
                :rules="rules"
                @submit.prevent="emit('addCat', nom, description, urlPhoto)"
-->


</template>

<style scoped>

</style>