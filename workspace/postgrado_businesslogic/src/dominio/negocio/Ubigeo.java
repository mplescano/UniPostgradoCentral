package dominio.negocio;

public class Ubigeo implements Cloneable {
	public static final String PERU = "51";
	public static final String DPT_LIMA = "15";
	public static final String PRV_LIMA = "01";
	
	private String cod_pais;
	private String cod_departamento;
	private String cod_provincia;
	private String cod_distrito;
	private String id;
    private String nombre;
    /**
     * Creates a new instance of the Ubigeo bean
     */
    public Ubigeo() {}

    
    
    
    /**
     * Sets 
     * @param cod_pais is 
     */
    public void setCod_pais(String cod_pais) {
      this.cod_pais = cod_pais;
    }

    /**
     * Returns 
     * @return 
     */
    public String getCod_pais() {
      return cod_pais;
    }

    /**
     * Sets 
     * @param cod_departamento is 
     */
    public void setCod_departamento(String cod_departamento) {
      this.cod_departamento = cod_departamento;
    }

    /**
     * Returns 
     * @return 
     */
    public String getCod_departamento() {
      return cod_departamento;
    }

    /**
     * Sets 
     * @param cod_provincia is 
     */
    public void setCod_provincia(String cod_provincia) {
      this.cod_provincia = cod_provincia;
    }

    /**
     * Returns 
     * @return 
     */
    public String getCod_provincia() {
      return cod_provincia;
    }

    /**
     * Sets 
     * @param cod_distrito is 
     */
    public void setCod_distrito(String cod_distrito) {
      this.cod_distrito = cod_distrito;
    }

    /**
     * Returns 
     * @return 
     */
    public String getCod_distrito() {
      return cod_distrito;
    }

    /**
     * Sets 
     * @param nombre is 
     */
    public void setNombre(String nombre) {
      this.nombre = nombre;
    }

    /**
     * Returns 
     * @return 
     */
    public String getNombre() {
      return nombre;
    }
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		Ubigeo u = (Ubigeo) o;
		if (u != null && this.id.equals(u.id)) {
			return true;				
		}
		else {
			return super.equals(o);
		}
	}

	//@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}