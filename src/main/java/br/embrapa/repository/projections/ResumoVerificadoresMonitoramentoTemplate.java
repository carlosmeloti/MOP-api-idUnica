package br.embrapa.repository.projections;

public class ResumoVerificadoresMonitoramentoTemplate {
	
	private Long cdVerificador;
	private String codalfa;
	private String sigla;
	private String nmVerificador;

	public ResumoVerificadoresMonitoramentoTemplate(Long cdVerificador, String codalfa, String sigla, String nmVerificador) {
		this.cdVerificador = cdVerificador;
		this.codalfa = codalfa;
		this.sigla = sigla;
		this.nmVerificador = nmVerificador;
	}

	public Long getCdVerificador() {
		return cdVerificador;
	}

	public void setCdVerificador(Long cdVerificador) {
		this.cdVerificador = cdVerificador;
	}

	public String getCodalfa() {
		return codalfa;
	}

	public void setCodalfa(String codalfa) {
		this.codalfa = codalfa;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNmVerificador() {
		return nmVerificador;
	}

	public void setNmVerificador(String nmVerificador) {
		this.nmVerificador = nmVerificador;
	}
	
	
	
	
	
	
	
}
