console.log("hello collections JS");

const url = "http://localhost:8989/api";

//document.getElementById("click_collection").addEventListener('click', () => {
//    console.log('btn clicked');
//});

document.getElementById("click_collection").addEventListener("click", getCategories);

function getCategories(){
    const fetchOptions = {method : "GET"};

    fetch(url + "/categories", fetchOptions)
        .then( (response) => {
            console.log("coucou");
            return response.json();
        })
        .then( (dataJSON) => {
            console.log(dataJSON);
            let categories = dataJSON._embedded.categories
            let texteHTML = ""
            for(let cat of categories){
                texteHTML = texteHTML + '<img src="'+ urlPhoto +'" />' + cat.categorieNom   //id="'+ cat.id_categorie +'"
            }
            document.getElementById("liste_categories").innerHTML = texteHTML;
        })
        .catch( (error) => {
            console.log(error)
        });
}


// l'entête de la requête
const headers = {
    "Content-Type": "application/json",
};
const fetchOptions = {  method: "GET" };
function nosCategories() {
    console.log("entrée dans la fonction")
    fetch(url+"/categories", fetchOptions)
        .then( (response) => {
            return response.json()
        })
        .then( (dataJSON) => {
            console.log(dataJSON)
            let categories = dataJSON._embedded.categories
            let texteHTML = ""
            for(let cat of categories){
                texteHTML = texteHTML + '<img src="'+ urlPhoto +'" />' + cat.categorieNom   //id="'+ cat.id_categorie +'"
            }
            document.getElementById("liste_categories").innerHTML = texteHTML;
            //for(let image of document.querySelectorAll("#albums > img")){
            //    image.addEventListener("click", infosAlbum);
            //}
        })
        .catch( (error) => console.log(error))
}




document.getElementById("catID").addEventListener("click", getObjetsPourCategorie);

function getObjetsPourCategorie(){
    const fetchOptions = {};

    fetch(url + "categories/catID", fetchOptions)//event.target.value ?
        .then( (response) => {
            console.log("coucou bis");
            return response.json();
        })
        .then( (dataJSON) => {
            console.log(dataJSON);
            let objets = dataJSON.results;
            let texthtml = "";
            for(let obj of objets){
                texthtml += "<li>" + obj.nom + "</li>";
            }
            document.getElementById("liste_objets").innerHTML = texthtml;
        })
        .catch( (error) => {
            console.log(error)
        });
}