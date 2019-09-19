package entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import enums.PorteEnum;

@Entity
@Table(name = "animal")
public class Animal implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "animal_seq")
	@SequenceGenerator(sequenceName = "seq_animal", name="animal_seq")
	@Column(name = "id_animal")
	private Integer id;
	@Column(name = "raca")
	private String raca;
	@Enumerated(EnumType.STRING)
	@Column(name = "porte")
	private PorteEnum porte;
	@Column(name = "idade")
	private int idade;
	@Column(name = "peso")
	private double peso;
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "cpf")
	private Cliente cliente;

	public Animal() {
	
	}
	
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public PorteEnum getPorte() {
		return porte;
	}
	public void setPorte(PorteEnum porte) {
		this.porte = porte;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
