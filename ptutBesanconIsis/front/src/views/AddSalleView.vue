<script setup>
import { ref } from "vue";
// -- donnée réactive pour la saisie du libellé
const nom = ref("");

const emit = defineEmits(["addS"]);

</script>


<script>
export default {
  data: () => ({
    nom: '',
    rules: [
      value => {
        if (value) return true

        return "Vous devez renseigner le nom d'une nouvelle salle."
      },
    ],
  }),
}
</script>

<template>

  <h1>Ajouter une nouvelle salle</h1>
  <p>Pour ajouter une nouvelle salle remplissez le formulaire ci-dessous et cliquer sur le bouton "submit".</p>
  <p>Une fois la salle ajoutée vous serez en mesure de la renseignée comme étant la salle d'exposition d'un objet.</p>

  <v-sheet width="300" class="mx-auto">
    <v-form @submit.prevent="$emit('addS', nom)">
      <v-text-field
          v-model="nom"
          :rules="rules"
          label="Nom de la salle"
      ></v-text-field>
      <v-btn type="submit" block class="mt-2">Valider</v-btn>
    </v-form>
  </v-sheet>

</template>

<style scoped>

</style>