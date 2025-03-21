package com.mx.Tienda.Confing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	//es una notacion que se utiliza en clase de configuracion (@configuration) para indicar quee un metodo produce un @bean,
	//que sera administrado por el contenedor de instancias de spring.
	
	//que es un @bean: en spring es un objeto que forma parte del contexto de la aplicacion y ademas es administrado por el contenedor
	//de instancias de Spring.
	//Estos objetos pueden ser inyectado en otras partes del codigo mediante "Inyeccion de dependecias"
	//un bean es una unica instancia que se encuentra almacenada en el contenedor de instancias de spring framework.
	//esto para garantizar que solo exista una sola isntancia de ese obejto

	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	
}

