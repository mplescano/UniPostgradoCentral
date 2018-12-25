package dominio.negocio;

public class UbigeoView extends Ubigeo {
	private String nombre_pais;
	private String nombre_departamento;
	private String nombre_provincia;
	private String nombre_distrito;
	
	public UbigeoView () {
		
	}

	public String getNombre_departamento() {
	return nombre_departamento;}
	

	public void setNombre_departamento(String nombre_departamento) {
		this.nombre_departamento = nombre_departamento;
	}

	public String getNombre_distrito() {
	return nombre_distrito;}
	

	public void setNombre_distrito(String nombre_distrito) {
		this.nombre_distrito = nombre_distrito;
	}

	public String getNombre_pais() {
	return nombre_pais;}
	

	public void setNombre_pais(String nombre_pais) {
		this.nombre_pais = nombre_pais;
	}

	public String getNombre_provincia() {
	return nombre_provincia;}
	

	public void setNombre_provincia(String nombre_provincia) {
		this.nombre_provincia = nombre_provincia;
	}
}