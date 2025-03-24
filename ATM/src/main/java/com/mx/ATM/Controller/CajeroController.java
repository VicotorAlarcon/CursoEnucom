package com.mx.ATM.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ATM.Entity.Cajero;
import com.mx.ATM.Service.CajeroService;


@RestController
@RequestMapping("/api/cajero")
public class CajeroController {
	
	@Autowired
    private CajeroService cajeroService;
	
	
	   @PostMapping("/retirar/{cantidad}")
	    public ResponseEntity<Map<Double, Integer>> retirar(@PathVariable double cantidad) {
	        return ResponseEntity.ok(cajeroService.retirarDinero(cantidad));
	   }
	       


	   
	   @GetMapping
		public List<Cajero> listar(){
			return cajeroService.listar();
		}
}