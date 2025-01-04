// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#usuarios').DataTable();
});

async function cargarUsuarios() {
  try {
    const request = await fetch('usuarios',{
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type':'application/json'
      }
    });
    const usuarios = await request.json();
    let listadoValores = '';
    for(let usuario of usuarios){
       let usuarioValores= ' <tr><td>' +
           usuario.usuarioId +
           '</td><td>' +
           usuario.nombre +
           '</td><td>' +
           usuario.email +
           '</td><td>' +
           usuario.telefono +
           '</td><td><a href=\"#\" class=\"btn btn-danger btn-circle\"><i class=\"fas fa-trash\"></i></a></td></tr>';
        listadoValores += usuarioValores
    }
    document.querySelector('#usuarios tbody').outerHTML = listadoValores
    console.log(usuarios);
  } catch (error) {
    console.error('Error:', error);
  }


}