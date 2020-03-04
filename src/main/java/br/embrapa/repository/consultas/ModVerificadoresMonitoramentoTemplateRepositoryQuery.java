package br.embrapa.repository.consultas;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.embrapa.model.ModVerificadoresMonitoramentoTemplate;
import br.embrapa.repository.filter.CadFrequenciaFilter;
import br.embrapa.repository.filter.ModVerificadoresMonitoramentoTemplateFilter;
import br.embrapa.repository.projections.ResumoVerificadoresMonitoramentoTemplate;

public interface ModVerificadoresMonitoramentoTemplateRepositoryQuery {

	public Page<ModVerificadoresMonitoramentoTemplate> filtrar(ModVerificadoresMonitoramentoTemplateFilter 
			modVerificadoresMonitoramentoTemplateFilter, Pageable pageable);
	
	public List<ResumoVerificadoresMonitoramentoTemplate> resumir(ModVerificadoresMonitoramentoTemplateFilter 
				modVerificadoresMonitoramentoTemplateFilter);

}
