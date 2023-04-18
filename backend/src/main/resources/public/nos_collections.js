//Fonctions pour l'affichage des collections

//console.log("hello collections JS");

const url = "/api";
getCategories();

//Pour charger toutes les catégories existantes
function getCategories() {
    let fetchOptions = {method: "GET"};
    fetch(url + "/categories", fetchOptions)
        .then((response) => {
            return response.json();
        })
        .then((dataJSON) => {
            let categories = dataJSON._embedded.categories.sort((p1, p2) =>
                p1.nom < p2.nom ? -1 : 1  //On trie les catégories par ordre alphabétique
            );
            let texteHTML = "";
            for (let cat of categories) { //Pour chaque catégorie on indique la façon dont elles doivent apparaitre
                texteHTML = texteHTML + '<li>' + '<embed id="' + cat.id + '" src= "' + cat.urlPhoto + '"/>' + '<br>' + cat.nom + "</li>"; //<ul id=" + 'liste_objets' + "></ul>
            }
            document.getElementById("liste_categories").innerHTML = texteHTML;
        });
}

//En cliquant sur une catégorie on charge les objets qui en font partie
document.getElementById("liste_categories").addEventListener("click", getObjetsCat, once = true);

function getObjetsCat(event) {
    console.log("getObjetsCat");
    const idCategorieClic = event.target.id; //on récupère l'id de la catégorie sur laquelle l'utilisateur a cliqué
    const url = "/categories/" + idCategorieClic + "/objet";
    const fetchOptions = {method: "GET"};
    fetch(url, fetchOptions)
        .then((response) => {
            return response.json();
        })
        .then((dataJSON) => {
            let textHTML = "";
            let previousHTML = "";
            let listeObj = [];
            listeObj.splice(0, listeObj.length);
            dataJSON._embedded.objets.forEach((v) => listeObj.push(v));
            console.log(listeObj);
            for (let indice = 0; indice < listeObj.length; indice++) { //Pour chaque objet on affiche sa photo et son nom
                textHTML += "<li>" + '<embed id="' + dataJSON._embedded.objets[indice].id + '" src= "' + dataJSON._embedded.objets[indice].urlPhoto + '"/>' + '<br>' + dataJSON._embedded.objets[indice].nom + "</li>";
            }
            document.getElementById("liste_categories").innerHTML = previousHTML; //On enlève l'affichage des catégories
            document.getElementById("liste_objets").innerHTML = textHTML; //On affiche les objets
        });
}

//En cliquant sur un objet on affiche sa fiche de présentation
document.getElementById("liste_objets").addEventListener("click", afficherObjet);

function afficherObjet(event) {
    const idObjetClic = event.target.id;
    const url = "/objets/" + idObjetClic;
    const fetchOptions = {method: "GET"};
    fetch(url, fetchOptions)
        .then((response) => {
            return response.json();
        })
        .then((dataJSON) => {
            let textHTML = "";
            let previousHTML = "";
            textHTML += "<div>"
            textHTML += '<h1>' + dataJSON.nom + '</h1>'
            textHTML += '<embed src= "' + dataJSON.urlPhoto + '"/>' + '<br>'
            textHTML += '<h2> En bref </h2>'
            textHTML += '<li> Créateur : ' + dataJSON.createur + '</li>'
            textHTML += '<li> Date de l' + "'" + 'invention : ' + dataJSON.annee + '</li>'
            textHTML += '<li> Pays d' + "'" + 'origine : ' + dataJSON.pays + '</li>'
            textHTML += '<h2> Description </h2>'
            textHTML += '<p class="description">' + dataJSON.description + '</p>'
            textHTML += '<iframe class="video" src="' + dataJSON.urlVideo + '" allow = "accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"></iframe>';
            textHTML += "</div>";
            document.getElementById("liste_objets").innerHTML = previousHTML; //On enlève la liste des objets
            document.getElementById("objet").innerHTML = textHTML; //On affiche la présentation de l'objet sur lequel l'utilisateur a cliqué
        });
}