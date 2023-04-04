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

let infospot2 = new PANOLENS.Infospot(350, PANOLENS.DataImage.Setting); // l'éachelle et la représentation du point d'interet
infospot2.position.set(0, 0, 0); // sa position
infospot2.addHoverElement(document.getElementById("infospot2"), 100); // l'élement du DOM a afficher et sa postion verticale

let infospot3 = new PANOLENS.Infospot(350, PANOLENS.DataImage.Info); // l'éachelle et la représentation du point d'interet
infospot3.position.set(-1500, 0, 5000); // sa position
infospot3.addHoverElement(document.getElementById("infospot3"), 100); // l'élement du DOM a afficher et sa postion verticale

let infospot4 = new PANOLENS.Infospot(350, PANOLENS.DataImage.Info); // l'éachelle et la représentation du point d'interet
infospot4.position.set(5000, 1500, 3500); // sa position
infospot4.addHoverText("Le parking d''ISIS");
//infospot.addEventListener( 'click',, false );

// -- ajout des points d'interêt sur l'image
panorama.add(infospot1);
panorama.add(infospot2);
panorama.add(infospot3);
panorama.add(infospot4);

// ajout de l'image dans l'afficheur
viewer.add(panorama);

// --- des parametres
//viewer_main.enableControl(PANOLENS.CONTROLS.DEVICEORIENTATION);
//viewer_main.enableEffect(PANOLENS.MODES.CARDBOARD);
//viewer_main.enableControl(PANOLENS.CONTROLS.ORBIT);
//viewer_main.enableEffect(PANOLENS.MODES.NORMAL);
