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

  <h1>Ajouter une nouvelle catégorie</h1>
  <p>Pour ajouter une nouvelle catégorie remplissez le formulaire ci-dessous et cliquer sur le bouton "submit".</p>
  <p>Une fois la catégorie ajoutée vous serez en mesure de la renseignée comme étant la catégorie d'un objet.</p>

  <v-sheet width="300" class="mx-auto">
    <v-form @submit.prevent="$emit('addC', nom)">
      <v-text-field
          v-model="nom"
          :rules="rules"
          label="Nom de la catégorie"
      ></v-text-field>
      <v-btn type="submit" block class="mt-2">Valider</v-btn>
    </v-form>
  </v-sheet>

</template>

<style scoped>

</style>