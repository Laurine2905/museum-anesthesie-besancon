<script setup>
import { ref } from "vue";
// -- donnée réactive pour la saisie du libellé
const nom = ref("");

const emit = defineEmits(["addS"]);

export default {
  data: () => ({
    firstName: '',
    rules: [
      value => {
        if (value) return true

        return 'You must enter a first name.'
      },
    ],
  }),
}
</script>

<template>
  <form @submit.prevent="$emit('addS', nom)">
    <input type="text" v-model="nom" placeholder="nom de la salle ?" />
    <input type="submit" value="valider" />
  </form>

  <v-sheet width="300" class="mx-auto">
    <v-form @submit.prevent>
      <v-text-field
          v-model="nom"
          :rules="rules"
          label="Nom de la salle"
      ></v-text-field>
      <v-btn type="submit" block class="mt-2">Submit</v-btn>
    </v-form>
  </v-sheet>
</template>

<style scoped>

</style>