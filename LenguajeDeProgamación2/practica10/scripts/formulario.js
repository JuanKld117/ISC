document.addEventListener('DOMContentLoaded', async function() {
    async function init() {
        const query = new URLSearchParams(window.location.search);
        const id = query.get('id');

        const respuesta = await fetch('https://fi.jcaguilar.dev/v1/persona/+{id}');
        const datos = await respuesta.json();

        const inpId = document.querySelector('#inp-id');
        inpId.value = id;

        const inpNombre = document.querySelector('#inp-nombre');
        inpNombre.value = datos.nombre;

        const inpPaterno = document.querySelector('#inp-paterno');
        inpPaterno.value = datos.apellidoPaterno;

        const inpMaterno = document.querySelector('#inp-materno');
        inpMaterno.value = datos.apellidoMaterno;

        const selEstado = document.querySelector('#state');
        selEstado.value = datos.estado;

        if (datos.sexo.toLowerCase() === 'h') {
            document.querySelector('#Genero-Masculino').checked = true;
        } else if (datos.sexo.toLowerCase() === 'm') {
            document.querySelector('#Genero-Femenino').checked = true;
        } else {
            document.querySelector('#Genero-Otro').checked = true;
        }

        document.querySelector('#btn-guardar').addEventListener('click', guardar);
    }

    async function guardar(evt) {
        evt.preventDefault();

        const id = document.querySelector('#inp-id').value;
        const nombre = document.querySelector('#inp-nombre').value;
        const paterno = document.querySelector('#inp-paterno').value;
        const materno = document.querySelector('#inp-materno').value;
        const estado = document.querySelector('#state').value;
        const genero = document.querySelector('input[name="Genero"]:checked').value;

        const datos = {
            nombre: nombre,
            apellidoPaterno: paterno,
            apellidoMaterno: materno,
            estado: estado,
            sexo: genero
        };
        
        try {
            const respuesta = await fetch(`https://fi.jcaguilar.dev/v1/persona/1`, {
                method: 'PATCH',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(datos)
            });
        

            if (!respuesta.ok) {
                throw new Error('Error al guardar los cambios.');
            }

            console.log('Cambios guardados exitosamente.');
            // Aquí puedes redirigir al usuario a otra página, mostrar un mensaje de éxito, etc.
        } catch (error) {
            console.error('Error al guardar los cambios:', error);
            // Aquí puedes mostrar un mensaje de error al usuario
        }
    }

    // Redirige al index.html cuando se hace clic en el botón "Cancelar"
    document.getElementById('btn-cancelar').addEventListener('click', function() {
        window.location.href = 'index.html';
    });

    window.addEventListener('load', init);
});
