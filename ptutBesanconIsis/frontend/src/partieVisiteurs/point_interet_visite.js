// -- utilisation de Panonlens
//    https://pchen66.github.io/panolens.js/docs/

// -- l'élement dans lequel s'affichera l'image pano
let app = document.getElementById("app");

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
let panorama = new PANOLENS.ImagePanorama("assets/Salle.jpg");
// -- les point d'interet
let infospot1 = new PANOLENS.Infospot(350, PANOLENS.DataImage.WhiteTile); // l'éachelle et la représentation du point d'interet
infospot1.position.set(0, 0, -5000); // sa position
infospot1.addHoverElement(document.getElementById("infospot1"), 100); // l'élement du DOM a afficher et sa postion verticale

//infospot.addEventListener( 'click',, false );

// -- ajout des points d'interêt sur l'image
panorama.add(infospot1);

// ajout de l'image dans l'afficheur
viewer.add(panorama);

// --- des parametres
//viewer_main.enableControl(PANOLENS.CONTROLS.DEVICEORIENTATION);
//viewer_main.enableEffect(PANOLENS.MODES.CARDBOARD);
//viewer_main.enableControl(PANOLENS.CONTROLS.ORBIT);
//viewer_main.enableEffect(PANOLENS.MODES.NORMAL);
