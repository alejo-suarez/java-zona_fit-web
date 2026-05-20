package js.zona_fit.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import js.zona_fit.modelo.Cliente;
import js.zona_fit.servicio.IClienteServicio;

@Component("indexControlador")
@Scope(value = "view", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class IndexControlador implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(IndexControlador.class);

	@Autowired
	private IClienteServicio clienteServicio;

	private List<Cliente> clientes = new ArrayList<>();

	@PostConstruct
	public void init() {
		cargarDatos();
	}

	public void cargarDatos() {
		this.clientes = this.clienteServicio.listarClientes();
		if (this.clientes != null) {
			this.clientes.forEach(cliente -> logger.info(cliente.toString()));
		}
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
