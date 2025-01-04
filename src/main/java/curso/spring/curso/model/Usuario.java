package curso.spring.curso.model;

public class Usuario {
	private Long usuarioId;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private String contaseña;
	
	
	public Long getUsuarioId() {
		return usuarioId;
	}
	
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getContaseña() {
		return contaseña;
	}
	public void setContaseña(String contaseña) {
		this.contaseña = contaseña;
	}
	
}
