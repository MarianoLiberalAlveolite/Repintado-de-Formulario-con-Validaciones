$(document).ready(function() {
    ("#idioma").change(function() {
        var selectedOption = $('#idioma').val();
        if (selectedOption != '') {
            window.location.replace('devuelve-formulario?lang=' + selectedOption);
        }
    });
});