package br.embrapa.dto;

import br.embrapa.model.CadNivelDeAvaliacao;
import br.embrapa.model.ModVerificadoresMonitoramentoTemplate;
import br.embrapa.model.Verificador_m;

public class TodosOsVerificadores {
	
	private Verificador_m codalfa;
	
	private CadNivelDeAvaliacao nmNivelDeAvaliacao;
	
	private Verificador_m p01_graco;
	
	private ModVerificadoresMonitoramentoTemplate txColetaAnalitica;
	
	private ModVerificadoresMonitoramentoTemplate txColetaAgrupada;

	public TodosOsVerificadores(Verificador_m codalfa, CadNivelDeAvaliacao nmNivelDeAvaliacao, Verificador_m p01_graco,
			ModVerificadoresMonitoramentoTemplate txColetaAnalitica,
			ModVerificadoresMonitoramentoTemplate txColetaAgrupada) {
		this.codalfa = codalfa;
		this.nmNivelDeAvaliacao = nmNivelDeAvaliacao;
		this.p01_graco = p01_graco;
		this.txColetaAnalitica = txColetaAnalitica;
		this.txColetaAgrupada = txColetaAgrupada;
	}

	public Verificador_m getCodalfa() {
		return codalfa;
	}

	public void setCodalfa(Verificador_m codalfa) {
		this.codalfa = codalfa;
	}

	public CadNivelDeAvaliacao getNmNivelDeAvaliacao() {
		return nmNivelDeAvaliacao;
	}

	public void setNmNivelDeAvaliacao(CadNivelDeAvaliacao nmNivelDeAvaliacao) {
		this.nmNivelDeAvaliacao = nmNivelDeAvaliacao;
	}

	public Verificador_m getP01_graco() {
		return p01_graco;
	}

	public void setP01_graco(Verificador_m p01_graco) {
		this.p01_graco = p01_graco;
	}

	public ModVerificadoresMonitoramentoTemplate getTxColetaAnalitica() {
		return txColetaAnalitica;
	}

	public void setTxColetaAnalitica(ModVerificadoresMonitoramentoTemplate txColetaAnalitica) {
		this.txColetaAnalitica = txColetaAnalitica;
	}

	public ModVerificadoresMonitoramentoTemplate getTxColetaAgrupada() {
		return txColetaAgrupada;
	}

	public void setTxColetaAgrupada(ModVerificadoresMonitoramentoTemplate txColetaAgrupada) {
		this.txColetaAgrupada = txColetaAgrupada;
	}
	
	
	

}
