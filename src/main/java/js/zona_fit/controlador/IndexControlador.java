package js.zona_fit.controlador;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import js.zona_fit.modelo.Cliente;
import js.zona_fit.servicio.IClienteServicio;
import lombok.Getter;
import lombok.Setter;

@Component("indexControlador")
@Scope("view")
@Getter
@Setter
public class IndexControlador implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IClienteServicio clienteServicio;

	private List<Cliente> clientes;

	private static final Logger logger = LoggerFactory.getLogger(IndexControlador.class);

	@PostConstruct
	public void init() {
		cargarDatos();
	}

	public void cargarDatos() {
		this.clientes = this.clienteServicio.listarClientes();
		this.clientes.forEach(cliente -> logger.info(cliente.toString()));
	}
}
