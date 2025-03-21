package com.mx.Bicicleta.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Bicicleta.Dominio.Bicicleta;
import com.mx.Bicicleta.Repositorio.IBicicletaRepository;

@Service

public class BicicletaServiceImpl implements IBicicletasService {

	// Inyeccion de dependencias

	@Autowired
	private IBicicletaRepository repository;

	@Override
	public void guardar(Bicicleta bici) {
		repository.save(bici);

	}

	@Override
	public void editar(Bicicleta bici) {
		repository.save(bici);

	}

	@Override
	public void eliminar(int idBici) {
		repository.deleteById(idBici);

	}

	@Override
	public Bicicleta buscar(int idBici) {

		return repository.findById(idBici).orElse(null);
	}

	@Override
	public List<Bicicleta> listar() {

		return (List<Bicicleta>) repository.findAll();
	}

}
