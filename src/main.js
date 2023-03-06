import { createApp } from 'vue'
import App from './App.vue'
// -- fichier css global
import './assets/main.css'
// -- le router
import router from './router'
// -- le framework UI Vuetify
import 'vuetify/styles'
import { createVuetify } from 'vuetify'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
// -- les icones
import { fa } from "vuetify/iconsets/fa";
import { aliases, mdi } from "vuetify/lib/iconsets/mdi";
import "@mdi/font/css/materialdesignicons.css";
import "@fortawesome/fontawesome-free/css/all.css";

// -- paramétrage du framework UI Vuetify pour notre application
const vuetify = createVuetify({
    // -- theme global de l'application
    theme: {
        defaultTheme: "dark",
    },
    // les categories d'icone utilées par l'application
    icons: {
        defaultSet: "mdi",
        aliases,
        sets: {
            mdi,
            fa,
        },
    },
    components,
    directives,
})
// -- création d'une App Vue
const app = createApp(App)
// -- qui utilse un router global
app.use(router)
// -- et aussi le framework UI Vuetify (paramétré ci-dessus)
app.use(vuetify)
app.mount('#app')
