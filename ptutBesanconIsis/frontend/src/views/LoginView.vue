<script setup>
  function showResult(resultJson) {
    console.log(resultJson);
  }
  function showError(error){
    console.log(error);
  }
  function doRequest(login,mdp) {
    fetch("http://localhost:8989/service/utilisateur/login?login="+login+"&mdp="+mdp)
        .then(response => response.json())
        .then(json => showResult(json))
        .then(error => showError(error));
  }
</script>

<template>

  <h1>Connexion</h1>

  <v-sheet width="300" class="mx-auto">
    <v-form @submit.prevent="doRequest(login,mdp)">
      <v-text-field
          v-model="login"
          :rules="rules"
          label="Identifiant"
      ></v-text-field>
      <v-text-field
          v-model="mdp"
          :rules="rules"
          label="Mot de passe"
      ></v-text-field>
      <v-btn type="submit" block class="mt-2">Valider</v-btn>
    </v-form>
  </v-sheet>

</template>

<style></style>
