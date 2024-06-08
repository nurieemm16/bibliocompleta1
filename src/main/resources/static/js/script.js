
    
       function catalogoShow() {
            fetch('http://localhost:8080/libros')
                .then(response => {
                    if (!response.ok) {
                        throw new Error('No funciona ' + response.statusText);
                    }
                    return response.json();
                })
                .then(libros => {
                    const catalogoLibros = document.getElementById('catalogoLibros');
                    catalogoLibros.innerHTML = libros.map(libro => `
                        <div>
                            <h3>TÍTULO:</h3>
                            <p>${libro.titulo}</p>
                            <h3>AUTOR:</h3>
                            <p>${libro.autor}</p>
                            <h3>FECHA PUBLICACIÓN:</h3>
                            <p>${libro.fecha_publicacion}</p>
                            <h3>DISPONIBILIDAD:</h3>
                            <p>${libro.disponibilidad ? 'Disponible' : 'No disponible'}</p>
                            <h3>GÉNERO:</h3>
                            <p>${libro.genero}</p>
                        </div>
                        <br>
                    `).join('');
                })
                .catch(error => console.error('Error libros:', error));
        }
        
        
        
      function mostrarFormularioPrestar() {
    document.getElementById('formularioPrestar').style.display = 'block';
    document.getElementById('formularioDevolver').style.display = 'none';
}

function mostrarFormularioDevolver() {
    document.getElementById('formularioPrestar').style.display = 'none';
    document.getElementById('formularioDevolver').style.display = 'block';
}

async function prestarLibro(event) {
    event.preventDefault();
    const nombre_usuario = document.getElementById('nombre_usuario_prestar').value;
    const titulo = document.getElementById('titulo_prestar').value;
    const telefono = document.getElementById('telefono_prestar').value;
    const fecha_prestamo = document.getElementById('fecha_prestamo').value;

    const response = await fetch('/usuarios/prestamos', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            nombre_usuario,
            titulo,
            telefono,
            fecha_prestamo
        })
    });

    const message = await response.text();
    alert(message);
}

async function devolverLibro(event) {
    event.preventDefault();
    const nombre_usuario = document.getElementById('nombre_usuario_devolver').value;
    const titulo = document.getElementById('titulo_devolver').value;
    const telefono = document.getElementById('telefono_devolver').value;
    const fecha_devolucion = document.getElementById('fecha_devolucion').value;

    const response = await fetch('/usuarios/prestamos/devolver', {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            nombre_usuario,
            titulo,
            telefono,
            fecha_devolucion
        })
    });

    const message = await response.text();
    alert(message);
}