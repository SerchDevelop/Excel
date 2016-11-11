package mx.indra.bean;

import java.io.Serializable;
import java.util.List;

public class MercadoDiaAdelantoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String centralElectrica;
	private List<UnidadGeneradoraBean> unidadGeneradora;

	
	public MercadoDiaAdelantoBean(){
		
	}


	public String getCentralElectrica() {
		return centralElectrica;
	}


	public void setCentralElectrica(String centralElectrica) {
		this.centralElectrica = centralElectrica;
	}


	public List<UnidadGeneradoraBean> getUnidadGeneradora() {
		return unidadGeneradora;
	}


	public void setUnidadGeneradora(List<UnidadGeneradoraBean> unidadGeneradora) {
		this.unidadGeneradora = unidadGeneradora;
	}

}
