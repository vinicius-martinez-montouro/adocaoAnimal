package presentation;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Animal;
import entity.Cliente;
import enums.PorteEnum;
import persistence.dao.AnimalDao;

@Named
@ViewScoped
public class AnimalManagedBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@Inject
	private Animal animal;
	@Inject
	private AnimalDao animalDao;
	private boolean alterarCadastro = false;
	private String idAnimal;
	
	public AnimalManagedBean() {
	}
			
	public void inserir() { 
		animalDao.salvar(animal);
		animal = new Animal();
	}
	
	public List<Animal> getListarAnimais(){
		return animalDao.listar();
	}
	public void alterar() {
		this.alterarCadastro = true;
	}
	public void salvarAlteracao() {
		animalDao.editar(animal);
		this.alterarCadastro = false;	
	}
	public void deletar() {
		animalDao.excluir(animal);
		animal = new Animal();
	}
	
	public void consultaAnimal() {
		try {
			animal = animalDao.buscar(Integer.parseInt(idAnimal));
			if(animal == null) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Não exite animal cadastrado com esse ID!", null));
			}
		}catch(NumberFormatException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Digite um valor numérico!", e.getMessage()));
		}
	}
	
	public PorteEnum[] getPorteEnum() {
		return PorteEnum.values();
	}		
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public String getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(String idAnimal) {
		this.idAnimal = idAnimal;
	}

	public AnimalDao getAnimalDao() {
		return animalDao;
	}

	public void setAnimalDao(AnimalDao animalDao) {
		this.animalDao = animalDao;
	}

	public boolean isAlterarCadastro() {
		return alterarCadastro;
	}

	public void setAlterarCadastro(boolean alterarCadastro) {
		this.alterarCadastro = alterarCadastro;
	}
	
}
