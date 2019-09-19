package presentation;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import business.AdotarAnimalService;

@Named
@ViewScoped
public class AdotarAnimalManagedBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private String idAnimal;
	private String cpfCliente;
	private boolean adocaRealizada = false;
	@Inject
	private AdotarAnimalService adotarAnimalService;
	
	public AdotarAnimalManagedBean() {
	}

	public void adotar() {
		try {
			adotarAnimalService.adotar(idAnimal, cpfCliente);
			limpaCampos();
			this.adocaRealizada = true;
		}catch(Exception e) {
			limpaCampos();
			this.adocaRealizada = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Digite valores válidso para os campos Id e CPF!", e.getMessage()));
		}

	}
	public void limpaCampos() {
		this.idAnimal = "";
		this.cpfCliente = "";		
	}
	
	public String getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(String idAnimal) {
		System.out.println("entrou");
		this.idAnimal = idAnimal;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public AdotarAnimalService getAdotarAnimalService() {
		return adotarAnimalService;
	}

	public void setAdotarAnimalService(AdotarAnimalService adotarAnimalService) {
		this.adotarAnimalService = adotarAnimalService;
	}
	public boolean isAdocaRealizada() {
		return adocaRealizada;
	}

	public void setAdocaRealizada(boolean adocaRealizada) {
		this.adocaRealizada = adocaRealizada;
	}


}
