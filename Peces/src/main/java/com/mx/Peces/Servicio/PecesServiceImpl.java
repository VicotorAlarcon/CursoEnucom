package com.mx.Peces.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Peces.Dominio.Peces;
import com.mx.Peces.Repositorio.IPecesRepository;

@Service

public class PecesServiceImpl implements IPecesService {
	
	@Autowired
	private IPecesRepository repository;

	@Override
	public void guardar(Peces pez) {
		repository.save(pez);
		
	}

	@Override
	public void editar(Peces pez) {
		repository.save(pez);
		
	}

	@Override
	public void eliminar(int idPez) {
		repository.deleteById(idPez);
		
	}

	@Override
	public Peces buscar(int idPez) {
		
		return repository.findById(idPez).orElse(null);
	}

	@Override
	public List<Peces> listar() {
		
		return (List<Peces>) repository.findAll();
	}

}
