// Call the dataTables jQuery plugin
$(document).ready(function() {
    //onReady
});

async function registrarUsuarios() {
    try {
        let datos = {};
        datos.nombre =document.getElementById('txtNombre').value
        datos.apellido=document.getElementById('txtApellido').value
        datos.email=document.getElementById('txtCorreo').value
        datos.contaseña=document.getElementById('txtClave').value
        let claveRepetida=document.getElementById('txtClaveRepetida').value

        if (claveRepetida!=datos.contaseña){
            alert('LA CONTRASEÑA ES DIFERENTE')
            return;
        }
        const request = await fetch('api/usuario_registrar',{
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type':'application/json'
            }
            ,body: JSON.stringify(datos)
        });
    } catch (error) {
        console.error('Error:', error);
    }
}

