const d = document;
const $bodyTable = d.getElementById("table-body");

const $iconEdit = `Editar`;

async function recoveryData() {
    const response = await fetch("https://fi.jcaguilar.dev/v1/persona");
    const data = await response.json();
    console.log(data);

    if ($bodyTable) {
        data.forEach(Element => {
            $bodyTable.innerHTML += /*html*/` 
            <tr>
                <td>${Element.id}</td>
                <td>${Element.nombre}</td>
                <td>${Element.apellidoPaterno}</td>
                <td>${Element.apellidoMaterno}</td>
                <td>${Element.sexo}</td>
                <td><a class="btn btn-primary" id="action-id" href="form.html?id=${Element.id}">${$iconEdit}</a></td>
            </tr>
            `;
        });
    }
}

recoveryData();
