console.log("hello collections JS");

const url = "http://localhost:8989/api";
//const urlHP = "https://hp-api.onrender.com/api/characters/students";

//document.getElementById("click_collection").addEventListener('click', () => {
//    console.log('btn clicked');
//});

getCategories();

function getCategories() {
    let fetchOptions = {method: "GET"};
    console.log("hello getCategories");
    fetch(url + "/categories", fetchOptions)
        .then((response) => {
            console.log("coucou1");
            return response.json();
        })
        .then((dataJSON) => {
            console.log("coucou2");
            let categories = dataJSON._embedded.categories.sort((p1, p2) =>
                p1.nom < p2.nom ? -1 : 1
            );
            let texteHTML = "";
            for (let cat of categories) {
                texteHTML = texteHTML + '<li>' + '<img src= "'+ cat.urlPhoto +'"/>' +'<br>' + cat.nom + "</li>";
            }
            document.getElementById("liste_categories").innerHTML = texteHTML;
        });
}




/*
document.getElementById("liste_categories").addEventListener("click", getObjetsCat);

/!**
 * ajoute dans le DOM les infos sur un pokemon
 * @param event permet de connaître l'url du pokemon
 *!/
function getObjetsCat(event) {
    const url = event.target.value;
    const fetchOptions = { method: "GET" };

    fetch(url, fetchOptions)
        .then((response) => {
            return response.json();
        })
        .then((dataJSON) => {
            console.log(dataJSON);
            let objets = dataJSON.results;
            let texthtml = "";
            for (let obj of objets) {
                texthtml += "<li>" + obj.nom + "</li>";
            }
            document.getElementById("liste_objets").innerHTML = texthtml;
        });
}






document.getElementById("catID").addEventListener("click", getObjetsPourCategorie);

function getObjetsPourCategorie() {
    const fetchOptions = {};

    fetch(url + "categories/catID", fetchOptions)//event.target.value ?
        .then((response) => {
            console.log("coucou bis");
            return response.json();
        })
        .then((dataJSON) => {
            console.log(dataJSON);
            let objets = dataJSON.results;
            let texthtml = "";
            for (let obj of objets) {
                texthtml += "<li>" + obj.nom + "</li>";
            }
            document.getElementById("liste_objets").innerHTML = texthtml;
        })
        .catch((error) => {
            console.log(error)
        });
}

 */