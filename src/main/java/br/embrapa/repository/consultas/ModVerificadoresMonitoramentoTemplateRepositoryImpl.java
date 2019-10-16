package br.embrapa.repository.consultas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import br.embrapa.model.AppAvaliacao_;
import br.embrapa.model.ModVerificadoresMonitoramentoTemplate;
import br.embrapa.model.ModVerificadoresMonitoramentoTemplate_;
import br.embrapa.model.Verificador_m_;
import br.embrapa.repository.filter.ModVerificadoresMonitoramentoTemplateFilter;

public class ModVerificadoresMonitoramentoTemplateRepositoryImpl implements ModVerificadoresMonitoramentoTemplateRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<ModVerificadoresMonitoramentoTemplate> filtrar(
			ModVerificadoresMonitoramentoTemplateFilter modVerificadoresMonitoramentoTemplateFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ModVerificadoresMonitoramentoTemplate> criteria = builder .createQuery(ModVerificadoresMonitoramentoTemplate.class);
		Root<ModVerificadoresMonitoramentoTemplate> root = criteria.from(ModVerificadoresMonitoramentoTemplate.class);
		
		Predicate[] predicates = criarRestricoes(modVerificadoresMonitoramentoTemplateFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ModVerificadoresMonitoramentoTemplate> query = manager.createQuery(criteria);
		return query.getResultList();
	}
	
	
	


	private Predicate[] criarRestricoes(
			ModVerificadoresMonitoramentoTemplateFilter modVerificadoresMonitoramentoTemplateFilter,
			CriteriaBuilder builder, Root<ModVerificadoresMonitoramentoTemplate> root) {

		List<Predicate> predicates = new ArrayList<>();
		
		if (modVerificadoresMonitoramentoTemplateFilter.getCdTemplate() != null) {
			predicates.add(
					builder.equal(root.get(ModVerificadoresMonitoramentoTemplate_.cdTemplate), modVerificadoresMonitoramentoTemplateFilter.getCdTemplate()));
		}
		
		if (modVerificadoresMonitoramentoTemplateFilter.getCdVerificador() != null) {
			predicates.add(
					builder.equal(root.get(ModVerificadoresMonitoramentoTemplate_.cdVerificador).get(Verificador_m_.codigo), modVerificadoresMonitoramentoTemplateFilter.getCdVerificador()));
		}
		
		if(!StringUtils.isEmpty(modVerificadoresMonitoramentoTemplateFilter.getNmVerificador())) {
			predicates.add(builder.like(
					builder.lower(root.get(ModVerificadoresMonitoramentoTemplate_.cdVerificador).get(Verificador_m_.nmverificador)), "%" + modVerificadoresMonitoramentoTemplateFilter.getNmVerificador().toLowerCase() + "%"));
		};
		
		if(!StringUtils.isEmpty(modVerificadoresMonitoramentoTemplateFilter.getCodalfa())) {
			predicates.add(builder.like(
					builder.lower(root.get(ModVerificadoresMonitoramentoTemplate_.cdVerificador).get(Verificador_m_.codalfa)), "%" + modVerificadoresMonitoramentoTemplateFilter.getCodalfa().toLowerCase() + "%"));
		};
		return predicates.toArray(new Predicate[predicates.size()]);

	}

	

}
