import { createRouter, createWebHistory } from "vue-router";

import ModifsView from "../views/ModifsView.vue";
import ObjetsView from "../views/ObjetsView.vue";
import CategoriesView from "../views/CategoriesView.vue";
import SallesView from "../views/SallesView.vue";
import AddSalleView from "../views/AddSalleView.vue";
import AddCategorieView from "@/views/AddCategorieView.vue";
import AddObjetView from "@/views/AddObjetView.vue";
import LoginView from "@/views/LoginView.vue";

// === définition des routes de l'application
// --- principalement les items du menu
// --- mais aussi des navigations internes comme 'master/detail'

// !!! important : la navigation doit se faire entre des "views" qui ne gèrent que l'affichage
// !!!  le code fonctionnel doit être uniquement dans les 'components'
const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: "/login",
            name: "login",
            component: LoginView,
        },
        {
            path: "/",
            name: "accueil_admin",
            component: ModifsView,
        },
        {
            path: "/objets",
            name: "objets",
            component: ObjetsView,
        },
        {
            path: "/addObjets",
            name: "addObjets",
            component: AddObjetView,
        },
        {
            path: "/categories",
            name: "categories",
            component: CategoriesView,
        },
        {
            path: "/addCategorie",
            name: "addCategorie",
            component: AddCategorieView,
        },
        {
            path: "/salles",
            name: "salles",
            component: SallesView,
        },
        {
            path: "/addSalle",
            name: "addSalle",
            component: AddSalleView,
        }
    ],
});

export default router;
