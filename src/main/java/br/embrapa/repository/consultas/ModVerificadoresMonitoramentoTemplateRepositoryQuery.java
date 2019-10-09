package br.embrapa.repository.consultas;

import java.util.List;

import br.embrapa.model.ModVerificadoresMonitoramentoTemplate;
import br.embrapa.repository.filter.ModVerificadoresMonitoramentoTemplateFilter;

public interface ModVerificadoresMonitoramentoTemplateRepositoryQuery {

	public List<ModVerificadoresMonitoramentoTemplate> filtrar(ModVerificadoresMonitoramentoTemplateFilter 
			modVerificadoresMonitoramentoTemplateFilter);
	
}
