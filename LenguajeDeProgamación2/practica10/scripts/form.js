const d = document;
const urlDataUser = window.location.href;
const params = new  URLSearchParams(window.location.search);
export const idUser = params.get("id");
const $id = d.querySelector(".id");
const $name = d.querySelector(".name");
const $apPaterno = d.querySelector(".apPaterno");
const $apMaterno = d.querySelector(".apMaterno");
const $selectState = d.querySelector(".estado");

async function recoveryDataUser() {
const response = await fetch(`https://fi.jcaguilar.dev/v1/persona/${idUser}`);
const data = await response.json();
console.log(data);


$id.value = idUser;
$id.disabled = true;
$name.value = data.nombre;
$apPaterno.value = data.apellidoPaterno;
$apMaterno.value = data.apellidoMaterno;
$selectState.selectedIndex = data.estado;

/*  if(!data.sexo === null) { */

    try {
        if(data.sexo.toLowerCase() === "h") {
            d.querySelector(".check-men").checked = true;
        } else if(data.sexo.toLowerCase() == "m") {
            d.querySelector(".check-woman").checked = true;
        } else if(data.sexo.toLowerCase() == "o"){
            d.querySelector(".check-otro").checked = true;
        } else {
            d.querySelector(".check-otro").checked = false;
            d.querySelector(".check-men").checked = false;
            d.querySelector(".check-woman").checked = false;
        }
    } catch (error) {
        
    }
/* } else if(data.sexo === null){
    d.querySelector(".check-otro").checked = false;
} */

}
recoveryDataUser();