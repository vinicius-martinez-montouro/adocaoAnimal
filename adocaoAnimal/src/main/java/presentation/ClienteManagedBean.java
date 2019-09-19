package presentation;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Cliente;
import persistence.dao.ClienteDao;

@Named
@ViewScoped
public class ClienteManagedBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Cliente cliente;
	@Inject
	private ClienteDao clienteDao;
	private String cpfCliente;
	private boolean alterarCadastro = false;
	
	public ClienteManagedBean() {
	}
	public void inserir() {
		try {
			clienteDao.salvar(cliente);
			cliente = new Cliente();
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "CPF já cadastrado!", e.getMessage()));
		}
	}
	
	public void alterar() {
		this.alterarCadastro = true;
	}
	public void salvarAlteracao() {
		clienteDao.editar(cliente);
		this.alterarCadastro = false;
	}
	public void deletar() {
		clienteDao.excluir(cliente);
		cliente = new Cliente();
	}
	
	public List<Cliente> getListarClientes(){
		return clienteDao.listar();
	}
	public void consultaCliente() {
		cliente = clienteDao.buscar(cpfCliente);
	}	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	public boolean isAlterarCadastro() {
		return alterarCadastro;
	}
	public void setAlterarCadastro(boolean alterarCadastro) {
		this.alterarCadastro = alterarCadastro;
	}
	public ClienteDao getClienteDao() {
		return clienteDao;
	}
	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}
	
}
