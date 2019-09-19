package business;

import java.io.Serializable;

import javax.inject.Inject;

import entity.Animal;
import entity.Cliente;
import persistence.dao.AnimalDao;
import persistence.dao.ClienteDao;

public class AdotarAnimalService implements Serializable{
	private static final long serialVersionUID = 1L;
	@Inject
	private Animal animal;
	@Inject
	private Cliente cliente;
	@Inject
	private AnimalDao animalDao;
	@Inject
	private ClienteDao clienteDao;
	
	public AdotarAnimalService() {
	}
	
	public void consultaAnimal(String idAnimal) {
		animal = animalDao.buscar(Integer.parseInt(idAnimal));
	}
	public void consultaCliente(String cpfCliente) {
		cliente = clienteDao.buscar(cpfCliente);
	}
	
	public void adotar(String idAnimal,String cpfCliente) {
		consultaAnimal(idAnimal);
		consultaCliente(cpfCliente);
		animal.setCliente(cliente);		
		animalDao.editar(animal);
	}
	
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public AnimalDao getAnimalDao() {
		return animalDao;
	}

	public void setAnimalDao(AnimalDao animalDao) {
		this.animalDao = animalDao;
	}

	public ClienteDao getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

}
