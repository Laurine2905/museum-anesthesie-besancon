<template>
<h1>Les catégories</h1>

  <v-btn href="/addCategorie">Ajouter une nouvelle catégorie</v-btn>

  <h1>Liste des objets</h1>
  <!-- Pour Afficher la liste sous forme de tableau -->

  <table>
    <!-- Les intitulé des colonnes -->
    <tr>
      <th>Nom de la catégorie</th>
      <th>Modifier</th>
      <th>Supprimer</th>
    </tr>
    <!-- Si le tableau des catégories est vide -->
    <tr v-if="!listeC">
      <td colspan="3">Veuillez patienter, chargement des catégories en cours...</td>
    </tr>
    <!-- Si le tableau des objets n'est pas vide -->
    <!-- On met les données dans les colonnes grâce a une boucle -->
    <tr v-for="cat of listeC" :key="cat.id">
      <td>{{ cat.nom }}</td>
      <td>
        <button @click="ModifierCategorie(cat.id)">Modifier</button>
      </td>
      <td>
      <button @click="SupprimerCategorie(cat.id)">Supprimer</button>
    </td>
    </tr>
  </table>

</template>

<script setup>

</script>

<style scoped>

td,
th {
  border: 1px solid #ddd;
  padding: 8px;
}
th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #232623;
  color: rgb(255, 255, 255);
}

</style>