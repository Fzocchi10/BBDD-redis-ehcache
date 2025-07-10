package aeropuerto_api.tp.entity;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "avion")
public class Avion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private UUID id;
	
    @Column(name = "nombre")
	private String nombre;
	
	@Column(name = "total_de_asientos")
	private int total_de_asientos;
	
	
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
	public int getTotal_de_asientos() {
		return total_de_asientos;
	}
	public void setTotal_de_asientos(int total_de_asientos) {
		this.total_de_asientos = total_de_asientos;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
