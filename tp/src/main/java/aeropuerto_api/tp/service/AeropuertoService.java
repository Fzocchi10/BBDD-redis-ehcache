package aeropuerto_api.tp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aeropuerto_api.tp.entity.Aeropuerto;
import aeropuerto_api.tp.repository.AeropuertoRepository;
import jakarta.persistence.OptimisticLockException;


@Service
public class AeropuertoService {
	
	@Autowired
    private AeropuertoRepository aeropuertoRepository;

    public List<Aeropuerto> findAll() {
		System.out.println("Accediendo al servicio.");
		return this.aeropuertoRepository.findAll(); 
	}
	
	@Cacheable(cacheNames={"aeropuertosStore"}, key="#id")
	public Aeropuerto findById(UUID id) {
		System.out.println("Accediendo al servicio EhCache.");
		return this.aeropuertoRepository.findById(id).get(); 
	}

	@Transactional
    @CachePut(value = "aeropuertosStore", key = "#result.id")
    public Aeropuerto updateAeropuerto(Aeropuerto nuevoAeropuerto) {
        Aeropuerto viejoAeropuerto = this.aeropuertoRepository.findById(nuevoAeropuerto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Este id no existe: " + nuevoAeropuerto.getId()));

        viejoAeropuerto.setNombre(nuevoAeropuerto.getNombre());
        viejoAeropuerto.setCiudad(nuevoAeropuerto.getCiudad());
        viejoAeropuerto.setPais(nuevoAeropuerto.getPais());

        try {
            return aeropuertoRepository.save(viejoAeropuerto);
        } catch (OptimisticLockException e) {
            throw new RuntimeException("Error de concurrencia: El aeropuerto fue modificado por otro proceso.", e);
        }
    }
    
    @Transactional
    public void crear(Aeropuerto aeropuerto) {
    	
    	Optional<Aeropuerto> existente = aeropuertoRepository
    		    .findByNombreAndCiudadAndPais(aeropuerto.getNombre(), aeropuerto.getCiudad(), aeropuerto.getPais());
    	
    	Aeropuerto aeropuertoAgregar = new Aeropuerto();
    	
    	aeropuertoAgregar.setId(UUID.randomUUID());
    	aeropuertoAgregar.setCiudad(aeropuerto.getCiudad());
    	aeropuertoAgregar.setNombre(aeropuerto.getNombre());
    	aeropuertoAgregar.setPais(aeropuerto.getPais());
    	
    	

    	if (existente.isPresent()) {
    		  throw new RuntimeException("Ya existe un aeropuerto con ese nombre, ciudad y país.");
    	} else {
    		   aeropuertoRepository.save(aeropuertoAgregar);
    	}
    }
    
}
