function getCategories() {
    const fetchOptions = { method: "GET" };
    fetch(url, fetchOptions)
        .then((response) => {
            return response.json();
        })
        .then((dataJSON) => {
            console.log(dataJSON);
            // -- vider la liste des choses
            listeC.splice(0, listeC.length);
            // pour chaque donnée renvoyée par l'API
            //  créer un objet instance de la classe Chose
            //  et l'ajouter dans la liste listeC
            dataJSON.forEach((v) => listeC.push(new Categorie(v.id, v.nom)));     //vérifier les attributs de catégorie
        })
        .catch((error) => console.log(error));
}

// -- utilisation de Panonlens
//    https://pchen66.github.io/panolens.js/docs/

// -- l'élement dans lequel s'affichera l'image pano
let app = document.getElementById("appvisite");

// -- les parametres de l'afficheur de l'image pano
let viewer = new PANOLENS.Viewer({
    enableReticle: false,
    container: app, // le container dans lequel le panon sera affiché
    output: "console",
    viewIndicator: false,
    autoRotate: true, // défilement auto
    autoRotateSpeed: 1,
    autoRotateActivationDuration: 5000,
    dwellTime: 1000
});
// -- l'image panoramique
let panorama = new PANOLENS.ImagePanorama("Images/salle.jpg");
// -- les point d'interet
// sur le vase sur la table 4
let infospot1 = new PANOLENS.Infospot(350, PANOLENS.DataImage.info); // l'éachelle et la représentation du point d'interet
infospot1.position.set(10000, -1500, 2000); // sa position
infospot1.addHoverElement(document.getElementById("infospot1"), 100); // l'élement du DOM a afficher et sa postion verticale

// SUR LE PANNEAU INCENDIE
let infospot2 = new PANOLENS.Infospot(350, PANOLENS.DataImage.info); // l'éachelle et la représentation du point d'interet
infospot2.position.set(-650, 50, -8000); // sa position
infospot2.addHoverElement(document.getElementById("infospot2"), 100); // l'élement du DOM a afficher et sa postion verticale

// sur le sapin
let infospot3 = new PANOLENS.Infospot(350, PANOLENS.DataImage.info); // l'éachelle et la représentation du point d'interet
infospot3.position.set(-4000, 50, 8000); // sa position
infospot3.addHoverElement(document.getElementById("infospot3"), 100); // l'élement du DOM a afficher et sa postion verticale

//infospot.addEventListener( 'click',, false );

// -- ajout des points d'interêt sur l'image
panorama.add(infospot1);
panorama.add(infospot2);
panorama.add(infospot3);

// ajout de l'image dans l'afficheur
viewer.add(panorama);

// --- des parametres
//viewer_main.enableControl(PANOLENS.CONTROLS.DEVICEORIENTATION);
//viewer_main.enableEffect(PANOLENS.MODES.CARDBOARD);
//viewer_main.enableControl(PANOLENS.CONTROLS.ORBIT);
//viewer_main.enableEffect(PANOLENS.MODES.NORMAL);
