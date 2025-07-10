package aeropuerto_api.tp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aeropuerto_api.tp.entity.Avion;
import aeropuerto_api.tp.repository.AvionRepository;


@Service
public class AvionService {
	
	@Autowired
	private AvionRepository avionRepository;
	

	public List<Avion> findAll() {
		System.out.println("Accediendo al servicio 1.");
		return this.avionRepository.findAll(); 
	}
	
	@Cacheable(value = "avionCache")
	public Avion findById(UUID id) {
		System.out.println("Accediendo al servicio Redis Cache.");
		return this.avionRepository.findById(id).get(); 
	}
	
	@CachePut(value="avionCache", key="#result.id")
	public Avion updateNombre(Avion avion) {
        Avion avionViejo = avionRepository.findById(avion.getId())
                .orElseThrow(() -> new IllegalArgumentException("El avion con este ID "+ avion.getId() + " no existe"));

        avionViejo.setNombre(avion.getNombre());
        avionViejo.setTotal_de_asientos(avion.getTotal_de_asientos());

        return avionRepository.save(avionViejo);
    }
	
	@Transactional
    public void crear(Avion avion) {
    	
    	Optional<Avion> existente = avionRepository
    		    .findByNombre(avion.getNombre());
    	
    	Avion avionAgregar = new Avion();
    	
    	avionAgregar.setId(UUID.randomUUID());
    	avionAgregar.setNombre(avion.getNombre());
    	avionAgregar.setTotal_de_asientos(avion.getTotal_de_asientos());
    	
    	if (existente.isPresent()) {
    		  throw new RuntimeException("Ya existe un avion con ese nombre.");
    	} else {
    		   avionRepository.save(avionAgregar);
    	}
    }

}
