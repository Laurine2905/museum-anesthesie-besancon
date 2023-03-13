<script setup>
import { ref } from "vue";
// -- donnée réactive pour la saisie du libellé
const nom = ref("");

const emit = defineEmits(["addC"]);

</script>


<script>
export default {
  data: () => ({
    nom: '',
    rules: [
      value => {
        if (value) return true

        return "Vous devez renseigner le nom d'une nouvelle catégorie."
      },
    ],
  }),
}
</script>

<template>

  <h1>Ajouter un nouvel objet</h1>
  <p>Pour ajouter un nouvel objet remplissez le formulaire ci-dessous et cliquer sur le bouton "valider".</p>
  <p>Une fois l'objet ajouté vous serez en mesure de le visualiser dans les collections du musée.</p>

  <v-card width="500" class="mx-auto" title="Nouvel objet">
    <v-container @submit.prevent="$emit('addC', nom)">
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
      <v-textarea
          name="input-7-1"
          variant="filled"
          label="Description"
          auto-grow
          model-value=""
      ></v-textarea>
      <v-text-field
          v-model="nb_possession"
          :rules="rules"
          label="Combien de fois l'objet est-il présenté dans le musée ?"
          type="number"
      ></v-text-field>
      <v-text-field
          v-model="url_photo"
          :rules="rules"
          label="Lien de l'image"
      ></v-text-field>
      <v-text-field
          v-model="categorie"
          :rules="rules"
          label="Catégorie de l'objet"
          type="Categorie"
      ></v-text-field>
      <v-btn type="submit" block class="mt-2">Valider</v-btn>
    </v-container>
  </v-card>

</template>

<style scoped>

</style>