<template>
  <form @submit.prevent="login">
    <!-- Id input -->
    <div class="form-outline mb-4">
      <!-- <p class="title">Veuillez vous connecter</p> -->
      <label class="form-label" for="form2Example1">Identifiant : </label>
      <input type="text" id="form2Example1" class="form-control" placeholder="Entrez votre identifiant ici" v-model="id" />
    </div>

    <!-- Password input -->
    <div class="form-outline mb-4">
      <label class="form-label" for="form2Example2">Mot de passe : </label>
      <input type="password" id="form2Example2" class="form-control" placeholder="Entrez votre mot de passe ici"
             v-model="password" />
    </div>
    <p class="errorMsg" v-if="errMsg">{{ errMsg }}</p><br>

    <!-- Submit button -->
    <button type="submit" id="button-auth" class="btn btn-primary btn-block mb-4">CONNEXION</button>
  </form>
</template>

<script setup>
import { ref } from 'vue';
//import { log } from "/service/utilisateur/login";

import { useRouter } from 'vue-router';// import router
let id = ref("");
let password = ref("");
let errMsg = ref();
const router = useRouter();

function login() {
  if(id.value=="musee" && password.value=="besancon"){
    router.push('/');
  }else if(id.value!="musee"){
    errMsg.value = 'Identifiant incorrect !'
  }else{
  errMsg.value = 'Mot de passe incorrect !'
}
}

</script>