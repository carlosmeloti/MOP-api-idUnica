package br.embrapa.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.embrapa.model.ModVerificadoresMonitoramentoTemplate;
import br.embrapa.repository.ModVerificadoresMonitoramentoTemplateRepository;

@Service
public class ModVerificadoresMonitoramentoTemplateService {

	@Autowired
	private ModVerificadoresMonitoramentoTemplateRepository modVerificadoresMonitoramentoTemplateRepository;
	
	public ModVerificadoresMonitoramentoTemplate atualizar(Long codigo, ModVerificadoresMonitoramentoTemplate modVerificadoresMonitoramentoTemplate) {
		
		ModVerificadoresMonitoramentoTemplate modVerificadoresMonitoramentoTemplateSalva = buscarVerificadorPeloCodigo(codigo);
		BeanUtils.copyProperties(modVerificadoresMonitoramentoTemplate, modVerificadoresMonitoramentoTemplateSalva, "codigo");
		return modVerificadoresMonitoramentoTemplateRepository.save(modVerificadoresMonitoramentoTemplateSalva);
	}
	

	public ModVerificadoresMonitoramentoTemplate buscarVerificadorPeloCodigo(Long codigo) {
		ModVerificadoresMonitoramentoTemplate modVerificadoresMonitoramentoTemplateSalva = modVerificadoresMonitoramentoTemplateRepository.findOne(codigo);
		if (modVerificadoresMonitoramentoTemplateSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return modVerificadoresMonitoramentoTemplateSalva;
	}
	
}
