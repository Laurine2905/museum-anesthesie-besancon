<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>

  <v-layout>
    <!--  la barre de navigation en haut -->
    <v-app-bar
        color=#6fa8dc
        density="compact"
    >

      <!-- le titre de la barre de navigation -->
      <v-app-bar-title>Espace administrateur</v-app-bar-title>

      <!-- les boutons de la barre de navigation
      <div class="bandeau_text" block>
        <v-btn variant="outlined" color="black">
          <RouterLink to="/">Accueil</RouterLink>
        </v-btn>
        <v-btn variant="outlined" color="black">
          <RouterLink to="/objets">Objets</RouterLink>
        </v-btn>
        <v-btn variant="outlined" color="black">
          <RouterLink to="/categories">Catégories</RouterLink>
        </v-btn>
        <v-btn variant="outlined" color="black">
          <RouterLink to="/salles">Salles</RouterLink>
        </v-btn>
        <v-btn variant="outlined" color="black">
          <RouterLink to="/histoires">Histoires</RouterLink>
        </v-btn>
      </div> -->
    </v-app-bar>

    <!--  la zone d'affichage du contenu de l'application -->
    <v-main>
      <v-container fluid>
        <!-- les "composant view" s'afficheront ici -->
        <RouterView />
      </v-container>
    </v-main>
  </v-layout>


</template>

<style scoped>
</style>