// Call the dataTables jQuery plugin
$(document).ready(function() {
    //onReady
});

async function inciarSesion() {
    try {
        let datos = {};
        datos.email=document.getElementById('txtCorreo').value
        datos.contaseña=document.getElementById('txtClave').value

        const request = await fetch('api/login',{
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type':'application/json'
            }
            ,body: JSON.stringify(datos)
        });
        const respuesta = await request.text();
        if(respuesta == "OK"){
            window.location.href = "usuarios.html";
        } else {
            alert("Las Credenciales son Inconrrectas. Favor Intentar nuevamente.");
        }
    } catch (error) {
        console.error('Error:', error);
    }
}

