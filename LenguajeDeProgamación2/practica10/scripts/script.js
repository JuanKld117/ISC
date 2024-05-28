document.addEventListener('DOMContentLoaded', function() {
    fetch('https://fi.jcaguilar.dev/v1/persona')
        .then(response => response.json())
        .then(data => {
            const tabla = document.getElementById('tabla-personas');
            data.forEach(persona => {
                const fila = `<tr>
                                <td>${persona.id}</td>
                                <td>${persona.nombre}</td>
                                <td>${persona.apellidoPaterno}</td>
                                <td>${persona.apellidoMaterno}</td>
                                <td>${persona.sexo}</td>
                                <td>
                                    <a href="formulario.html?id=${persona.id}" class="btn btn-primary">Editar</a>
                                </td>
                            </tr>`;
                tabla.innerHTML += fila;
            });
        })
        .catch(error => console.error('Error:', error));
});
