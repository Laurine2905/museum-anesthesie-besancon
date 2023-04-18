<!-- Page de connexion à l'espace administrateur -->

<template>
  <v-sheet rounded>
    <v-card class="mx-auto px-6 py-8" max-width="344">

      <v-form @submit.prevent="login">
        <!-- Id input -->
        <h2 class="title">Veuillez vous connecter</h2>
        <br>
        <v-text-field
            type="text"
            placeholder="Entrez votre identifiant ici"
            label="Identifiant"
            v-model="id"
        ></v-text-field>

        <!-- Password input -->
        <v-text-field
            type="password"
            placeholder="Entrez votre mot de passe ici"
            label="Mot de passe"
            v-model="password"

        ></v-text-field>

        <p class="errorMsg" v-if="errMsg">{{ errMsg }}</p><br>

        <!-- Submit button -->
        <v-btn
            type="submit"
            id="button-auth"
            class="btn btn-primary btn-block mb-4"
            variant="elevated"
            color="success"
        >CONNEXION
        </v-btn>
      </v-form>
    </v-card>
  </v-sheet>

</template>

<script setup>
import {ref} from 'vue';
//import { log } from "/service/utilisateur/login";

import {useRouter} from 'vue-router';
let id = ref("");
let password = ref("");
let errMsg = ref();
const router = useRouter();

function login() {
  if (id.value == "musee" && password.value == "besancon") {
    router.push('/accueil_admin');
  } else if (id.value != "musee") {
    errMsg.value = 'Identifiant incorrect !'
  } else {
    errMsg.value = 'Mot de passe incorrect !'
  }
}

</script>

<style scoped>

</style>