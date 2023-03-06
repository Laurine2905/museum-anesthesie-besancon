<template>

  <label for="categorie">Sélectionner la catégorie d'objet voulue</label>
  <select id="categorie" name="categorie">
    <option value="test" selected="selected">Testdfghjk</option>
    <option value="test1">Test</option>
    <option value="test2">Test</option>
  </select>
  <!--
  <option v-for="categorie of listeCat" :key="categorie.id">{{categorie.nom}}</option>
  -->

  <h1>Liste des objets</h1>
  <!-- Pour Afficher la liste sous forme de tableau -->

  <table>
    <!-- Les intitulé des colonnes -->
    <tr>
      <th>Nom</th>
      <th>Catégorie</th>
      <th>Supprimer</th>
    </tr>
    <!-- Si le tableau des catégories est vide -->
    <tr v-if="!listeO">
      <td colspan="3">Veuillez patienter, chargement des objets en cours...</td>
    </tr>
    <!-- Si le tableau des objets n'est pas vide -->
    <!-- On met les données dans les colonnes grâce a une boucle -->
    <tr v-for="objet of listeO" :key="objet.id">
      <td>{{ objet.nom }}</td>
      <td>{{ objet.categorie }}</td>
      <td>
        <button @click="SupprimerObjet(objet.id)">Supprimer</button>
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