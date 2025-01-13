// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#usuarios').DataTable();
});

async function cargarUsuarios() {
  try {
    const request = await fetch('api/usuarios',{
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type':'application/json'
      }
    });
    const usuarios = await request.json();
    let listadoValores = '';
    for(let usuario of usuarios){
      let botonEliminar = '<a href=\"#\" onclick="eliminarUsuario('+usuario.usuarioId+')" class=\"btn btn-danger btn-circle\"><i class=\"fas fa-trash\"></i></a>';
      let usuarioValores= ' <tr><td>' +
           usuario.usuarioId +
           '</td><td>' +
           usuario.nombre +
           '</td><td>' +
           usuario.email +
           '</td><td>' +
           usuario.telefono +
           '</td><td>' +
           botonEliminar +
           '</td></tr>';
        listadoValores += usuarioValores
    }
    document.querySelector('#usuarios tbody').outerHTML = listadoValores
    console.log(usuarios);
  } catch (error) {
    console.error('Error:', error);
  }
}
async function eliminarUsuario(id){
  const request = await fetch('api/usuario_eliminar/'+id,{
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type':'application/json'
    }
  });
}
