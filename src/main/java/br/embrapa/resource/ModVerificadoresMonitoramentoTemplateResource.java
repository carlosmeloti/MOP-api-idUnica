package br.embrapa.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.embrapa.model.ModVerificadoresMonitoramentoTemplate;
import br.embrapa.repository.ModVerificadoresMonitoramentoTemplateRepository;
import br.embrapa.repository.filter.ModVerificadoresMonitoramentoTemplateFilter;
import br.embrapa.service.ModVerificadoresMonitoramentoTemplateService;



@RestController
@RequestMapping("/modverificadoresmonitoramentotemplate")
public class ModVerificadoresMonitoramentoTemplateResource {
	
	@Autowired
	private ModVerificadoresMonitoramentoTemplateRepository modVerificadoresMonitoramentoTemplateRepository;
	
	@Autowired
	private ModVerificadoresMonitoramentoTemplateService modVerificadoresMonitoramentoTemplateService; 
	
	
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_VERIFICADOR_M') and #oauth2.hasScope('read')")
	public List<ModVerificadoresMonitoramentoTemplate> Pesquisar(ModVerificadoresMonitoramentoTemplateFilter modVerificadoresMonitoramentoTemplateFilter) {
		return modVerificadoresMonitoramentoTemplateRepository.filtrar(modVerificadoresMonitoramentoTemplateFilter);
	}
	
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_VERIFICADOR_M') and #oauth2.hasScope('read')")
	public ResponseEntity <ModVerificadoresMonitoramentoTemplate>buscarPeloCodigo(@PathVariable Long codigo) {
		ModVerificadoresMonitoramentoTemplate modVerificadoresMonitoramentoTemplate = modVerificadoresMonitoramentoTemplateRepository.findOne(codigo);
		return modVerificadoresMonitoramentoTemplate != null ? ResponseEntity.ok(modVerificadoresMonitoramentoTemplate) : ResponseEntity.notFound().build();
		
	}


}
