<!-- Page d'ajout d'un nouvel objet -->
<template>

  <h1>Ajouter un nouvel objet</h1>
  <p>Pour ajouter un nouvel objet remplissez le formulaire ci-dessous et cliquer sur le bouton "valider".</p>
  <p>Une fois l'objet ajouté vous serez en mesure de le visualiser dans les collections du musée.</p>

  <v-card width="500" class="mx-auto" title="Nouvel objet">
    <v-container @submit.prevent="$emit('addC', nom)">
      <!-- On ajoute l'objet au moment du click sur le bouton valider en bas du formulaire -->
      <!-- Un objet est décrit par son nom, l'année de sa création, son créateur, le pays de création, une description,
      le nombre d'exemplaires que possède le musée, la salle où il est exposé, la catégorie à laquelle il appartient,
      une photo de présentation -->
      <v-text-field
          v-model="nom"
          :rules="rules"
          label="Nom de l'objet"
          type="text"
      ></v-text-field>
      <v-text-field
          v-model="annee"
          :rules="rules"
          label="Année de création de l'objet"
          type="number"
      ></v-text-field>
      <v-text-field
          v-model="createur"
          :rules="rules"
          label="Identité du créateur de l'objet"
          type="text"
      ></v-text-field>
      <v-text-field
          v-model="pays"
          :rules="rules"
          label="Pays de création de l'objet"
          type="text"
      ></v-text-field>
      <v-text-field
          v-model="description"
          label="Description"
          type="text"
      ></v-text-field>
      <v-text-field
          v-model="nbpossession"
          :rules="rules"
          label="Combien de fois l'objet est-il présenté dans le musée ?"
          type="number"
      ></v-text-field>
      <!--
      <v-text-field
          v-model="categorie"
          :rules="rules"
          label="Catégorie de l'objet"
          type="Categorie"
      ></v-text-field>
      -->
      <v-select
          label="Catégorie"
          :items="listeCatNom"
      ></v-select>
      <v-select
          model-value="salle"
          label="Salle d'exposition"
          :items="listeSalleNom"
      ></v-select>
      <v-file-input
          label="Image illustrant la catégorie"
          accept="image/*"
          v-model="image"
      ></v-file-input>
      <v-btn type="submit" block class="mt-2">Valider</v-btn>
    </v-container>
  </v-card>

</template>

<script setup>
import {reactive, ref} from "vue";
// -- donnée réactive pour la saisie du nouvel objet
const nom = ref("");
const annee = ref("");
const createur = ref("");
const pays = ref("");
const description = ref("");
const nbpossession = ref("");

let listeCatNom = reactive([]);
let listeCat = reactive([]);

//Pour récupérer toutes les catégories existantes, à afficher dans le select catégorie
function chargeCategories(url = "http://localhost:8989/api/categories") {
  const fetchOptions = {method: "GET"};
  fetch(url, fetchOptions)
      .then((response) => {
        return response.json();
      })
      .then((dataJSON) => {
        listeCat.splice(0, listeCat.length);
        dataJSON._embedded.categories.forEach((v) => listeCat.push(v));
        for (let indice = 0; indice < listeCat.length; indice++) {
          listeCatNom.push(dataJSON._embedded.categories[indice].nom);
        }
      })
      .catch((error) => console.log(error));
}

let listeSalleNom = reactive([]);
let listeSalle = reactive([]);

//Pour r&écuper toutes les salles existantes à indiquer dans le select salle
function chargeSalles(url = "http://localhost:8989/api/salles") {
  const fetchOptions = {method: "GET"};
  fetch(url, fetchOptions)
      .then((response) => {
        return response.json();
      })
      .then((dataJSON) => {
        listeSalle.splice(0, listeSalle.length);
        dataJSON._embedded.salles.forEach((v) => listeSalle.push(v));
        for (let indice = 0; indice < listeSalle.length; indice++) {
          listeSalleNom.push(dataJSON._embedded.salles[indice].nom);
        }
      })
      .catch((error) => console.log(error));
}

function handlerAddObjet(nom, annee, createur, pays, description, nbpossession, categorie, salle, urlPhoto) {
  let myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");
  const fetchOptions = {
    method: "POST",
    headers: myHeaders,
    body: JSON.stringify({
      nom: nom,
      annee: annee,
      createur: createur,
      pays: pays,
      description: description,
      nbpossession: nbpossession,
      categorie: categorie,
      salle: salle,
      urlPhoto: urlPhoto
    }),
  };
  fetch(url, fetchOptions)
      .then((response) => {
        return response.json();
      })
      .then((dataJSON) => {
        console.log(dataJSON);  //AJOUTER MESSAGE DE SUCCES
        //id = dataJSON.id;
        //console.log(id);
        //handlerAddCategorieImage(imageData);
      })
      .catch((error) => console.log(error));
}

chargeCategories();
chargeSalles();

</script>

<style scoped>
</style>