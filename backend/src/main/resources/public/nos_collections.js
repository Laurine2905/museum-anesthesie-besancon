//Fonctions pour l'affichage des collections

//console.log("hello collections JS");

const url = "/api";
getCategories();

//Pour charger toutes les catégories existantes et les afficher sous forme d'une galerie photo
function getCategories() {
    let fetchOptions = {method: "GET"};
    fetch(url + "/categories", fetchOptions)
        .then((response) => {
            return response.json();
        })
        .then((dataJSON) => {
            //On récupère toutes les catégories et on les met dans la liste "categories"
            let categories = dataJSON._embedded.categories.sort((p1, p2) =>
                p1.nom < p2.nom ? -1 : 1  //On trie les catégories par ordre alphabétique
            );
            let texteHTML = "";
            for (let cat of categories) { //Pour chaque catégorie, on indique la façon dont elles doivent apparaitre (photo + nom)
                texteHTML = texteHTML + '<li>' + '<embed id="' + cat.id + '" src= "' + cat.urlPhoto + '"/>' + '<br>' + cat.nom + "</li>";
            }
            //On a choisi un format <embed> plutôt que <img> pour en faire un élément embarqué en espérant que ça génère moins d'erreurs
            //L'id est placé sur l'image donc le visiteur doit cliquer sur l'image et non pas sur le nom de la catégorie pour accéder à son contenu
            document.getElementById("liste_categories").innerHTML = texteHTML;
        });
}

//En cliquant sur une catégorie, on charge les objets qui en font partie
document.getElementById("liste_categories").addEventListener("click", getObjetsCat);

//Pour charger les objets de la catégorie choisie et les afficher en galerie de photos
function getObjetsCat(event) {
    //console.log("getObjetsCat");
    const idCategorieClic = event.target.id; //on récupère l'id de la catégorie sur laquelle l'utilisateur a cliqué (l'id est placé sur la photo)
    const fetchOptions = {method: "GET"};
    fetch(url + "/categories/" + idCategorieClic + "/objet", fetchOptions)
        .then((response) => {
            return response.json();
        })
        .then((dataJSON) => {
            let textHTML = "";
            let previousHTML = "";
            let listeObj = [];
            listeObj.splice(0, listeObj.length); //On vide la liste des objets
            dataJSON._embedded.objets.forEach((v) => listeObj.push(v)); //On ajoute les objets de la catégorie à la liste
            //console.log(listeObj);
            for (let indice = 0; indice < listeObj.length; indice++) { //Pour chaque objet, on affiche sa photo et son nom
                textHTML += "<li>" + '<embed id="' + dataJSON._embedded.objets[indice].id + '" src= "' + dataJSON._embedded.objets[indice].urlPhoto + '"/>' + '<br>' + dataJSON._embedded.objets[indice].nom + "</li>";
            }
            //On a choisi un format <embed> plutôt que <img> pour en faire un élément embarqué en espérant que ça génère moins d'erreurs
            //L'id est placé sur l'image donc le visiteur doit cliquer sur l'image et non pas sur le nom de l'objet pour accéder à son contenu
            document.getElementById("liste_categories").innerHTML = previousHTML; //On enlève l'affichage des catégories
            document.getElementById("liste_objets").innerHTML = textHTML; //On affiche les objets
        });
}

//En cliquant sur un objet, on affiche sa fiche de présentation
document.getElementById("liste_objets").addEventListener("click", afficherObjet);

//Pour afficher la présentation de l'objet
function afficherObjet(event) {
    const idObjetClic = event.target.id; //on récupère l'id de l'objet sur lequelle l'utilisateur a cliqué (l'id est placé sur la photo)
    const fetchOptions = {method: "GET"};
    fetch(url + "/objets/" + idObjetClic, fetchOptions)
        .then((response) => {
            return response.json();
        })
        .then((dataJSON) => {
            let textHTML = "";
            let previousHTML = "";
            textHTML += "<div>"
            textHTML += '<h1>' + dataJSON.nom + '</h1>'
            textHTML += '<embed src= "' + dataJSON.urlPhoto + '"/>' + '<br>'
            //On met en avant un résumé très bref de l'objet
            textHTML += '<h2> En bref </h2>'
            textHTML += '<li> Créateur : ' + dataJSON.createur + '</li>'
            textHTML += '<li> Date de l' + "'" + 'invention : ' + dataJSON.annee + '</li>'
            textHTML += '<li> Pays d' + "'" + 'origine : ' + dataJSON.pays + '</li>'
            //On affiche ensuite une description plus complète de l'objet
            textHTML += '<h2> Description </h2>'
            textHTML += '<p class="description">' + dataJSON.description + '</p>'
            /* Cette fonctionnalité n'a pas été testée (update : urlVideo n'existe plus, il faudra passer par les multimédias ou bien ajouter un String urlVideo à Objet)
            if(dataJSON.urlVideo != null){
                textHTML += '<iframe class="video" src="' + dataJSON.urlVideo + '" allow = "accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"></iframe>';
            }
            */
            //Il faut traiter les multimédias
            textHTML += "</div>";
            document.getElementById("liste_objets").innerHTML = previousHTML; //On enlève la liste des objets
            document.getElementById("objet").innerHTML = textHTML; //On affiche la présentation de l'objet sur lequel l'utilisateur a cliqué
        });
}