document.addEventListener("DOMContentLoaded", function() { //para que el documento esté completamente cargado
    const form = document.getElementById('pedidoForm');//aquí m'està agafant el formulari
    const pedidosList = document.getElementById('pedidosList');//aquí m'està agafant el llistat de pedido

    form.addEventListener('submit', function(event) { // cuando aprete en submit(en el botón), hace las siguientes linias. 
        event.preventDefault();

        const producto = document.getElementById('producto').value; //nos quedaremos con el valor que entre por html, este valor se guardará en esta constante
        const cantidad = document.getElementById('cantidad').value;

        fetch('/api/pedidos', { //la ruta que nosotros le hayamos definido con el controller
            method: 'POST', //el método que queremos
            headers: {
                'Content-Type': 'application/json' //elijo como se mandarán los datos. En este caso serán formato json
            },
            body: JSON.stringify({ producto: producto, cantidad: parseInt(cantidad) }) //Lo rosa son las variables, lo negro es lo q le pasas del formulario. stringify pasa a string el producto que nosotros le hayamos pasado, y parseInt pasa a int la cantidad que nosotros le hayamos pasado desde el navegador
        })
        .then(response => response.json()) //enviamos la solicitud de tipo json
        .then(data => {
            console.log('Success:', data); //si ha ido todo ok, la data contiene el producto y la cantidad, q nos viene de html del formulario
            addPedidoToList(data);// añadimos el pedido a la lista
            form.reset();
        })                                                  //de la 18 al 27 es código de control
        .catch((error) => {
            console.error('Error:', error); //si no funciona bién pues error
        });
    });
function addPedidoToList(pedido) { //pedido es una varliable
    const li = document.createElement('li'); 
    // Crea un nuevo elemento 'li' (lista) en el DOM

    li.textContent = `Producto: ${pedido.producto}, Cantidad: ${pedido.cantidad}`;
    // Asigna el contenido de texto del 'li' con los detalles del pedido (producto y cantidad)

    li.id = `pedido-${pedido.id}`;
    // Asigna un id único al elemento 'li' basado en el id del pedido para identificarlo fácilmente
//cada vez que yo cree un nuevo pedido a la lista, le agrego un boton de eliminar al lado
    const deleteButton = document.createElement('button'); 
    // Crea un nuevo botón de eliminación

    deleteButton.textContent = 'Eliminar';
    // Asigna el texto 'Eliminar' al botón

    deleteButton.classList.add('delete-btn');
    // Agrega la clase 'delete-btn' al botón para poder aplicar estilos CSS

    deleteButton.setAttribute('data-id', pedido.id); 
    // Agrega un atributo 'data-id' al botón con el id del pedido. Esto facilita la identificación del pedido asociado al botón cuando se haga clic en él

    // Agrega un event listener al botón de eliminar
    deleteButton.addEventListener('click', (event) => {
        // Define una función que se ejecutará cuando se haga clic en el botón
        const pedidoId = event.target.getAttribute('data-id');
        // Obtiene el id del pedido del atributo 'data-id' del botón que fue clicado

        console.log(`Eliminar pedido con id: ${pedidoId}`);
        // Imprime en la consola un mensaje indicando el id del pedido que se va a eliminar

        deletePedido(pedidoId);
        // Llama a la función 'deletePedido' pasando el id del pedido para eliminarlo
    });



    pedidosList.appendChild(li);
    // Agrega el elemento 'li' (que ahora contiene el pedido y el botón de eliminación) a la lista de pedidos en el DOM
    li.appendChild(deleteButton);
    // Agrega el botón de eliminación como hijo del elemento 'li'

    
}


    function deletePedido(id) {
        fetch(`/api/pedidos/eliminar/${id}`, { //aquí borramos el elemento en el backend
            method: 'DELETE'
        }).then(response => {
            if (response.ok) {
                alert('Pedido eliminado');//si todo va bién, sale un pop up de pedido eliminado
                // Remover el pedido de la lista en el frontend
                document.getElementById(`pedido-${id}`).remove();//se borra el pedido de la lista del frontend
            } else {
                alert('Error al eliminar el pedido');
            }
        }).catch(error => {
            console.error('Error:', error);
            alert('Error al eliminar el pedido');
        });
    }

    function loadPedidos() { // esto para que cuando carguemos la página, si yo tengo los datos en la base de datos, que te salgan en la pantalla, q no solo salgan los que acabo de introducir 
        fetch('/api/pedidos')
        .then(response => response.json())
        .then(data => {
            data.forEach(pedido => addPedidoToList(pedido));
        });
    }

    loadPedidos();
});
