package com.mx.ATM.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mx.ATM.Dao.DenominacionRepository;
import com.mx.ATM.Entity.Cajero;

@Service

public class CajeroService {
	
	 

	 @Autowired
	    private DenominacionRepository efectivoRepository;

	 
	    public Map<Double, Integer> retirarDinero(double cantidad) {
	        List<Cajero> efectivoDisponible = efectivoRepository.findAllByOrderByDenominaionDesc();
	        Map<Double, Integer> retiro = new LinkedHashMap<>();
	        double restante = cantidad;

	        for (Cajero e : efectivoDisponible) {
	            if (restante >= e.getDenominaion() && e.getCantidad() > 0) {
	                int billetesUsados = Math.min((int) (restante / e.getDenominaion()), e.getCantidad());
	                retiro.put((double) e.getDenominaion(), billetesUsados);
	                restante -= billetesUsados * e.getDenominaion();
	                e.setCantidad(e.getCantidad() - billetesUsados);
	            }
	        }

	        if (restante > 0) {
	            throw new RuntimeException("No hay suficiente efectivo disponible.");
	        }

	        efectivoRepository.saveAll(efectivoDisponible);
	        return  retiro;
	    }
	    
	    public List<Cajero> listar() {
			return efectivoRepository.findAll(Sort.by(Direction.ASC, "idCajero"));
		
		}
	 
	 
	 
}
