//************FUNCIONES*****************

//Función para cambiar de Idioma (Baeldung)
$(document).ready(function () {
    $("#idioma").change(function () {
        var selectedOption = $('#idioma').val();

        if (selectedOption !== '') {
            let url = '/formulario/devuelve-formulario?idioma=' + selectedOption;
            window.location.replace(url);
        }
    });
});

// Deseleccionar los 'radios' (género) y los 'checkboxes' (aficiones)
function deseleccionarRadYCheck(botonesNombre) {
    const elementos = document.getElementsByName(botonesNombre);
    for (var i = 0; i < elementos.length; i++) {
        if (elementos[i].type === "radio" || elementos[i].type === "checkbox") {
            elementos[i].checked = false;
        }
    }
}

// Seleccionar los 'radios' (género) y los 'checkboxes' (aficiones)
function seleccionarRadYCheck(checkboxNombre) {
    const elementos = document.getElementById(checkboxNombre);
    for (let i = 0; i < elementos.length; i++) {
        if (elementos[i].type === "checkbox") {
            elementos[i].checked = true;
        }
    }
}


// Deseleccionar los 'select' (música)
function deseleccionarSelect(selectName) {
    const elementoSelect = document.getElementById(selectName);
    if (elementoSelect) {
        // Pone el valor vacío.
        elementoSelect.value = "";
    }
}

// Seleccionar los 'select' (música)
function seleccionarSelect(selectName) {
    const elementoSelect = document.getElementById(selectName);
    if (elementoSelect) {
        // Hacemos un bucle que recorra la lista y seleccione todas las opciones
        for (let seleccion of elementoSelect.options) {
            seleccion.selected = true; //
        }
    }
}

// Mostrar contraseñas
function mostrarClave() {
    // Asignamos variables a los campos: clave y confirmarClave
    const varClave = document.getElementById('clave');
    const varConfirm = document.getElementById('confirmarClave');
    // Asignamos variable al botón:
    const botonMostrarClaves = document.getElementById('botonMostrarClaves');

    // Cambiamos el tipo de los campos, y lo pasamos de "password" a "text"
    if (varClave.type === 'password' || varConfirm.type === 'password') {
        varClave.type = 'text';
        varConfirm.type = 'text';
        botonMostrarClaves.innerText = 'Ocultar Claves en Abierto'; // Cambiamos el texto del botón
    } else {
        varClave.type = 'password';
        varConfirm.type = 'password';
        botonMostrarClaves.innerText = 'Mostrar Claves en Abierto'; // Volvemos a cambiar el texto del botón
    }
}

// Funcion generica que vacia el valor de un campo
function vaciarTexto(nombreInput) {
    const elementoTexto = document.getElementById(nombreInput);
    if (elementoTexto) {
        elementoTexto.value = "";
    }
}

// Combina la funcion generica de vaciarTexto con una lista a borrar
function vaciarCampos() {
    const camposTexto = [
        "nombre", "clave", "confirmarClave",
        "fechaNacimiento", "edad", "peso",
        "telefono", "email", "direccionIp"
    ]
    for (let i of camposTexto) {
        vaciarTexto(vaciarTexto(i));
    }
    const camposSelect = [
        "paisSeleccionado", "prefijoSeleccionado",
        "musicasSeleccionadas",
        "aficionesSeleccionadas",
        "idioma"
    ]
    for (let i of camposSelect) {
        deseleccionaSelect(i);
    }
    deseleccionaRadiosYCheckboxes('generoSeleccionado');
}

/* Función que usamos en clase
$(document).ready(function(){
    $('#deseleccionarGeneros').on('click', function () {
        // clear all radio buttons
        $("input[type=radio][name=generoSeleccionado]").prop('checked', false);
    })
});
*/