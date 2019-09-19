package enums;

public enum PorteEnum {

	PEQUENO("P"),MEDIO("M"),GRANDE("G");
	private String nome;
	
	private PorteEnum(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	
	public static PorteEnum from(final String valor) {
		PorteEnum porte = null;
		for(PorteEnum p : PorteEnum.values()) {
			if(valor.equals(p.nome) || valor.equals(p.name())) {
				porte = p;
				break;
			}
		}
		return porte;
	}
	
}
