package js.zona_fit.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import js.zona_fit.modelo.Cliente;
import js.zona_fit.repositorio.ClienteRepositorio;


@Service
public class ClienteServicio implements IClienteServicio{
@Autowired
			private ClienteRepositorio clienteRepositorio;

	@Override
			public List<Cliente> listarClientes() {
					List<Cliente>clientes = clienteRepositorio.findAll();
					return clientes;
			}

	@Override
			public Cliente buscarClientePorId(Integer idCliente) {
		    		Cliente cliente = clienteRepositorio.findById(idCliente).orElse(null);
			return cliente;
			}

	@Override
			public void guardarCliente(Cliente cliente) {
					clienteRepositorio.save(cliente);
			}

	@Override
			public void eliminarCliente(Cliente cliente) {
					clienteRepositorio.delete(cliente);
			}
}
