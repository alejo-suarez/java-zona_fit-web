package js.zona_fit.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Cliente {

		@Override
	public String toString() {
		return "Id Cliente: "+ id +" Nombre:  " + nombre +"  Apelllido:  " + apellido +"   Num Membresia:   " + membresia ;
	}
		public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getMembresia() {
		return membresia;
	}
	public void setMembresia(Integer membresia) {
		this.membresia = membresia;
	}
		@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apellido;
	private Integer membresia;
}
