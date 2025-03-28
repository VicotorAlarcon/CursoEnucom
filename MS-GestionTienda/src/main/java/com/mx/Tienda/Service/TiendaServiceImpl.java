package com.mx.Tienda.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mx.Tienda.Entity.Tienda;
import com.mx.Tienda.FeingClients.ICientesFeing;
import com.mx.Tienda.FeingClients.IProductosFeing;
import com.mx.Tienda.FeingClients.IProveedoresFeing;
import com.mx.Tienda.Models.Clientes;
import com.mx.Tienda.Models.Productos;
import com.mx.Tienda.Models.Proveedores;
import com.mx.Tienda.Repositori.ITiendaDao;

@Service
@SuppressWarnings("unchecked")
 
public class TiendaServiceImpl implements ITiendaService {
	
	//INyeccion de dependencias 
	
	@Autowired
	private ITiendaDao dao;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ICientesFeing clientesFC;
	
	@Autowired
	private IProductosFeing productosFC;
	
	@Autowired
	private IProveedoresFeing provedorFC;

	//-------------------------------------------------------------- 
	@Override
	public Tienda guardar(Tienda tiend) {
		
		return dao.save(tiend);
	}

	@Override
	public Tienda editar(Tienda tiend) {
		Tienda aux = this.buscar(tiend.getIdTienda());
		if(aux != null) {
			return dao.save(tiend);
		}
		return null;
	}

	@Override
	public Tienda eliminar(int idTienda) {
		Tienda aux = this.buscar(idTienda);
		if(aux != null) {
			dao.deleteById(idTienda);
		}
		return aux;
	}

	@Override
	public Tienda buscar(int idTienda) {
		
		return dao.findById(idTienda).orElse(null);
	}

	@Override
	public List<Tienda> listar() {
		
		return dao.findAll(Sort.by(Direction.DESC,"idTienda"));
	}

	//******************************************* servicios de clientes
	
	//Metodos con FeingClient
	public Clientes saveCliente (Clientes cliente) {
		return clientesFC.save(cliente);
	}
	
	
	public List<Clientes> getClientes(int tiendaId){
		return clientesFC.getClientesByTiendaId(tiendaId);
	}

	
	//Metodos con RestTemplate
	
	public Clientes saveClienteRT (Clientes cliente) {
		ResponseEntity<Clientes> response =		
		restTemplate.postForEntity("http://localhost:8013/Clientes", cliente, Clientes.class);
		
		return response.getBody();
	}
	
	public List<Clientes> getClientesRT(int tiendaId){
		return restTemplate.postForObject("http://localhost:8013/Clientes/Tienda/" + tiendaId, null, List.class);
	}
	
	//******************************************* servicios de Productos
	
	
	public Productos saveProductos(Productos producto) {
		return productosFC.save(producto);
	}
	
	public List<Productos> getProductos(int tiendaId){
		return productosFC.getProductosByTiendaId(tiendaId);
	}
	
	public Productos saveProductosRT(Productos producto) {
		ResponseEntity<Productos> response = restTemplate.postForEntity("http://localhost:8010/Productos", producto, Productos.class);
		return response.getBody();	
		}
	
	
	
	
	public List<Productos> getProductosRT(int tiendaId){
		return restTemplate.postForObject("http://localhost:8010/Productos/tienda" + tiendaId, null, List.class);
	}
	
	//******************************************* servicios de Proveedores
	
	
	public Proveedores saveProveedor (Proveedores provedores) {
		return provedorFC.save(provedores);
	}
	
	public List<Proveedores> getProveedores (int tiendaId){
		return provedorFC.getProveedoresById(tiendaId);
	}
	
	
	public Proveedores saveProveedorRT (Proveedores provedores) {
		ResponseEntity<Proveedores> response = restTemplate.postForEntity("http://localhost:8012/Proveedores", provedores, Proveedores.class);
		return response.getBody();
	}
	
	
	public List<Proveedores> getProveedoresRT(int tiendaId){
		return restTemplate.postForObject("http://localhost:8012/Proveedores/buscarPorTiendaId/" + tiendaId, null, List.class);
	}
	
	
	
	//**************************************
	
	//Metodo para obetener toda la relacion de la tienda y sus modulos (Micro servicios)
	
	public Map<String, Object> obtenerTodosLosModulos(int tiendaId) {
		
		Map<String, Object> resultado = new HashMap<>();
		
		//Consultar y validar tienda
		
		Tienda tienda = this.buscar(tiendaId);
		if(tienda == null) {
			resultado.put("Mensaje", "La tienda con ID " + tiendaId + " No existe.");
			return resultado;
			
		}
		resultado.put("Tienda", tienda);
		
		//consultar y validar los clientes
		
		List<Clientes> clientes = this.getClientes(tiendaId);
		if (clientes == null || clientes.isEmpty()) {
			resultado.put("Clientes", "La tienda no tiene clientes");
		}else {
			resultado.put("Clientes", clientes);	
		}
		
		
		//Consultar y validar los productos
		
		List<Productos> productos = this.getProductos(tiendaId);
		if(productos ==null || productos.isEmpty()) {
			resultado.put("Products", "La tienda no tiene productos");
		}else {
			resultado.put("Clientes", "La tienda no tiene Productos");
		}
		
		
		//Consultar y validar proveedores
		
		List<Proveedores> proveedores = this.getProveedoresRT(tiendaId);
		if(proveedores == null || proveedores.isEmpty()) {
			resultado.put("Proveedores", "La tienda no tiene proveedores");
		}else {
			resultado.put("Proveedores", proveedores);
		}
		
		return resultado;
	}
	
	
	

}



















