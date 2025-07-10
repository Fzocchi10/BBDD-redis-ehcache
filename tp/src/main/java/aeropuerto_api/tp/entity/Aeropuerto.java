package aeropuerto_api.tp.entity;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(
	    name = "aeropuerto",
	    uniqueConstraints = @UniqueConstraint(columnNames = {"nombre", "ciudad", "pais"})
	)
public class Aeropuerto implements Serializable {

    private static final long serialVersionUID = 1L;
    
	@Id
    private UUID id;
	
	@Column(nullable = false)
    private String nombre;
	
	@Column(nullable = false)
    private String ciudad;
	
	@Column(nullable = false)
    private String pais;

    @Version
    @Column(name = "version")
    private int version;
    
    
    public Aeropuerto() {}

    public Aeropuerto(UUID id, String nombre, String ciudad, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
    }

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
