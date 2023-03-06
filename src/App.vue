<script setup>
import { ref } from 'vue'
import { RouterLink, RouterView } from 'vue-router'
const drawer = ref(false)
</script>

<template>
  <v-layout>
    <!--  la barre de navigation en haut -->
    <v-app-bar
        color="primary"
        density="compact"
    >
      <!-- mettre l'icone dans le 'slot prepend' de 'v-app-bar' soit au début à gauche -->
      <template v-slot:prepend>
        <!--  un clic sur l'icone cache/affiche la zone de menu de gauche -->
        <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      </template>
      <!-- le titre de la barre de navigation -->
      <v-app-bar-title>Spotify</v-app-bar-title>
      <!-- les boutons de la barre de navigation-->
      <v-btn>
        <RouterLink to="/">Home</RouterLink>
      </v-btn>

      <v-btn id="menu-recherche">Rechercher ...</v-btn>
      <v-menu activator="#menu-recherche"> <!-- le menu s'affichera qd l'élément d'id 'menu-recherche' ici 'v-btn' sera activé-->
        <v-list>
          <v-list-item>
            <v-list-item-title><RouterLink to="/albums">Albums</RouterLink></v-list-item-title>
          </v-list-item>
          <v-list-item>
            <v-list-item-title><RouterLink to="/artists">Artistes</RouterLink></v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>

      <v-btn>
        <RouterLink to="/about">About</RouterLink>
      </v-btn>

      <!-- mettre l'icone dans le 'slot append' de 'v-app-bar' soit au fond à droite -->
      <template v-slot:append>
        <v-btn id="menu-droite" icon="mdi-dots-vertical"></v-btn>
        <v-menu activator="#menu-droite">  <!-- le menu s'affichera qd l'élément d'id 'menu-droite' ici 'v-btn' sera activé-->
          <v-list>
            <v-list-item>
              <v-list-item-title>Choix1</v-list-item-title>
            </v-list-item>
            <v-list-item>
              <v-list-item-title>Choix2</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
      </template>
    </v-app-bar>

    <!--  zone de menu de gauche caché / visible en fonction du booléen 'drawer'-->
    <v-navigation-drawer app v-model="drawer" color="primary">
      <v-list-item>
        <v-list-item-title class="text-h6"> Spotify</v-list-item-title>
        <v-list-item-subtitle> Menu gaauche</v-list-item-subtitle>
      </v-list-item>
      <v-divider></v-divider>
      <v-list dense nav>
        <v-list-item link>
          <v-list-item-title>Item 1</v-list-item-title>
        </v-list-item>
        <v-list-item link>
          <v-list-item-title>Item 2</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    <!--  la zone d'affichage du contenu de l'application -->
    <v-main>
      <v-container fluid>
        <!-- les "composant view" s'afficheront ici -->
        <RouterView />
      </v-container>
      <!--  le footer -->
      <v-footer color="primary">
        <div>
          {{ new Date().getFullYear() }} — <strong>Vuetify</strong>
        </div>
      </v-footer>
    </v-main>
  </v-layout>
</template>

<style scoped>
.v-main {
  padding:10px;
}
</style>
