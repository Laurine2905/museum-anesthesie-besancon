console.log("hello");

function getCategories(){
    const url = " https://## NOTRE_API ##/categories";
    const fetchOptions = {};

    fetch(url, fetchOptions)
        .then( (response) => {
            console.log("coucou");
            return response.json();
        })
        .then( (dataJSON) => {
            console.log(dataJSON);
            let categories = dataJSON.results;
            let catID = dataJSON.results.id_cat;
            let texthtml = "";
            for(let cat of categories){
                texthtml += "<li id = '" +catID+ "'>" + cat.nom + "</li>";
            }
            document.getElementById("liste_categories").innerHTML = texthtml;
        })
        .catch( (error) => {
            console.log(error)
        });
}


document.getElementById("catID").addEventListener("click", getObjetsPourCategorie);

function getObjetsPourCategorie(){
    const url = " https://## NOTRE_API ##/categories/" + "'catID'";    //event.target.value ?
    const fetchOptions = {};

    fetch(url, fetchOptions)
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