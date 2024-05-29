import { idUser } from "./form.js";

const d = document;
const $btnSend = d.querySelector("#send");
const $btnCancel = d.querySelector("#btn-cancel")

const $body = d.querySelector("body");


$btnSend.addEventListener("click", async (e) => {
    e.preventDefault();
const $id = d.querySelector(".id").value;
const $name = d.querySelector(".name").value;
const $apPaterno = d.querySelector(".apPaterno").value;
const $apMaterno = d.querySelector(".apMaterno").value;
const $selectState = d.querySelector(".estado");

const selectedIndex = $selectState.selectedIndex;


const $genero = document.querySelectorAll('input[name="exampleRadios"]');
let selectedG;
for(const radio of $genero) {
    if(radio.checked) {
        selectedG = radio.value;
        break;}
}
let gender;
switch(selectedG) {
    case "m": 
    gender = "m";
    break;
    case 'h':
    gender = 'h';
    break;
  case 'o':
    gender = 'o';
    break;
  default:
    gender = '';
}

   try {const dataUpdate = {
        idPersona : idUser,
        nombre: $name,
        apellidoPaterno: $apPaterno,
        apellidoMaterno: $apMaterno,
        estado: selectedIndex,
        sexo: gender
} 
const options = {
    method: "PATCH",
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(dataUpdate)
}

const url = await fetch(`https://fi.jcaguilar.dev/v1/persona`, options);

if(url.ok) {
    $body.innerHTML += /*html*/ `
    <div class="alert alert-success" role="alert">
    Cambios hechos correctamente
  </div>
    `;

    setTimeout(() => {
        window.location.href = "./index.html";
    }, 1000);
} else {
    $body.innerHTML += /*html*/ `
    <div class="alert alert-danger" role="alert">
    Ocurrio un error al guardar los datos
  </div>
    `;
}
 


} catch (err) {
        console.log(err)
   }



});
$btnCancel.addEventListener("click", (e) => {
    window.location.href = "./index.html";
});