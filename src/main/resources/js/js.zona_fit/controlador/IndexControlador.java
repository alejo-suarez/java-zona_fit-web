package js.zona_fit.controlador;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import js.zona_fit.modelo.Cliente;
import js.zona_fit.servicio.IClienteServicio;
import lombok.Data;
import java.util.List;
@Component
@Data
@ViewScoped
public class IndexControlador {
				@Autowired
				IClienteServicio clienteServicio;
//Se agrega una lista de clientes:
				private List<Cliente>clientes;
				private static final Logger logger =LoggerFactory.getLogger(IndexControlador.class);
		
				@PostConstruct
				public void init() {
						cargarDatos();
				}
				public void cargarDatos() {
						this.clientes = this.clienteServicio.listarClientes();
						this.clientes.forEach(cliente -> logger.info(cliente.toString()));
				}
	}
