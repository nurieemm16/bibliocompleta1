
  // Función para mostrar el catálogo de libros de la biblioteca usando el método GET
function catalogoShow() {
            fetch('http://localhost:8080/libros')
                .then(response => {
                    if (!response.ok) {
                        throw new Error('No funciona el get' + response.statusText);
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
        document.getElementById('libroshow').style.display = 'block'; 
                })
                .catch(error => console.error('Error libros:', error));

            
        }
        
        document.getElementById('cerrarCatalogo').addEventListener('click', () => {
            document.getElementById('libroshow').style.display = 'none'; 
           
        });

        document.getElementById('cerrarCatalogo').addEventListener('click', () => {
            document.getElementById('catalogoLibros').style.display = 'none'; // Ocultar catálogo
        });
        
       

    // Función para mostrar el Formulario de Libros para prestar un libro

      function mostrarFormularioPrestar() {
    document.getElementById('formularioPrestar').style.display = 'flex';
    document.getElementById('formularioDevolver').style.display = 'none';
    document.getElementById('formularioPublicarLibro').style.display = 'none';
}

 // Función para mostrar el Formulario de Libros para devolver un libro
function mostrarFormularioDevolver() {
    document.getElementById('formularioDevolver').style.display = 'flex';
    document.getElementById('formularioPrestar').style.display = 'none';
    document.getElementById('formularioPublicarLibro').style.display = 'none';
    
    }
    
    
//Función para mostrar el formulario para publicar un libro

 function mostrarPublicarLibro() {
     document.getElementById('formularioPublicarLibro').style.display = 'flex';
    document.getElementById('formularioPrestar').style.display = 'none';
    document.getElementById('formularioDevolver').style.display = 'none';
    
}
    //Función para prestar un libro, utilizando el método POST
    
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

  //Función para Devolver un libro utilizando el método DELETE
async function devolverLibro(event) {
    event.preventDefault();
    const nombre_usuario = document.getElementById('nombre_usuario_devolver').value;
    const titulo = document.getElementById('titulo_devolver').value;
    const telefono = document.getElementById('telefono_devolver').value;
    const fecha_devolucion = document.getElementById('fecha_devolucion').value;

    const response = await fetch('/usuarios/prestamos/devolver', {
        method: 'PUT',
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



//Función para publicar un Libro utilizando el método POST

async function publicarLibro(event) {
    event.preventDefault();
    const titulo = document.getElementById('titulo').value;
    const autor = document.getElementById('autor').value;
    const fecha_publicacion = document.getElementById('fecha_publicacion').value;
    const disponibilidad = true;
    const genero = document.getElementById('genero').value;

    const response = await fetch('/libros', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            titulo,
            autor,
            fecha_publicacion,
            disponibilidad,
            genero
            
        })
    });

    const message = await response.text();
    alert(message);
}