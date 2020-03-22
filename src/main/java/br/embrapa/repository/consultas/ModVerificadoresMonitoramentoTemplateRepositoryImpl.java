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

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import br.embrapa.dto.TodosOsVerificadores;
import br.embrapa.model.CadNivelDeAvaliacao_;
import br.embrapa.model.CadTipoDeVerificador_;
import br.embrapa.model.ModVerificadoresMonitoramentoTemplate;
import br.embrapa.model.ModVerificadoresMonitoramentoTemplate_;
import br.embrapa.model.Verificador_m_;
import br.embrapa.repository.filter.ModVerificadoresMonitoramentoTemplateFilter;
import br.embrapa.repository.projections.ResumoVerificadoresMonitoramentoTemplate;
import br.embrapa.repository.projections.ResumoVerificadoresMonitoramentoTemplateTeste;

public class ModVerificadoresMonitoramentoTemplateRepositoryImpl implements ModVerificadoresMonitoramentoTemplateRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	public List<TodosOsVerificadores> todosVerificadores(Long cdTemplate) {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		
		CriteriaQuery<TodosOsVerificadores> criteriaQuery = criteriaBuilder.
				createQuery(TodosOsVerificadores.class);
		
		Root<ModVerificadoresMonitoramentoTemplate> root = criteriaQuery.from(ModVerificadoresMonitoramentoTemplate.class);
		
		criteriaQuery.select(criteriaBuilder.construct(TodosOsVerificadores.class, 
				root.get(ModVerificadoresMonitoramentoTemplate_.cdVerificador).get(Verificador_m_.codalfa),
				root.get(ModVerificadoresMonitoramentoTemplate_.cdVerificador).get(Verificador_m_.cadNivelDeAvaliacao).get(CadNivelDeAvaliacao_.nmNivelDeAvaliacao),
				root.get(ModVerificadoresMonitoramentoTemplate_.cdVerificador).get(Verificador_m_.p01_graco),
				root.get(ModVerificadoresMonitoramentoTemplate_.txColetaAgrupada),
				root.get(ModVerificadoresMonitoramentoTemplate_.txColetaAnalitica),
				root.get(ModVerificadoresMonitoramentoTemplate_.cdVerificador).get(Verificador_m_.nmverificador)
				)).distinct(true);
		
		criteriaQuery.where(
				criteriaBuilder.equal(root.get(ModVerificadoresMonitoramentoTemplate_.cdTemplate), 
						cdTemplate));
		
		/*
		 * criteriaQuery.groupBy(root.get(Lancamento_.tipo),
		 * root.get(Lancamento_.pessoa));
		 */
		
		TypedQuery<TodosOsVerificadores> typedQuery = manager
				.createQuery(criteriaQuery);
		
		return typedQuery.getResultList();
	}
	
	@Override
	public Page<ModVerificadoresMonitoramentoTemplate> filtrar(ModVerificadoresMonitoramentoTemplateFilter modVerificadoresMonitoramentoTemplateFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ModVerificadoresMonitoramentoTemplate> criteria = builder .createQuery(ModVerificadoresMonitoramentoTemplate.class);
		Root<ModVerificadoresMonitoramentoTemplate> root = criteria.from(ModVerificadoresMonitoramentoTemplate.class);
		
		Predicate[] predicates = criarRestricoes(modVerificadoresMonitoramentoTemplateFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ModVerificadoresMonitoramentoTemplate> query = manager.createQuery(criteria);
		adiconarRestricoesDePaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(modVerificadoresMonitoramentoTemplateFilter));
	}
	
	public List<ResumoVerificadoresMonitoramentoTemplate> resumir(
			ModVerificadoresMonitoramentoTemplateFilter modVerificadoresMonitoramentoTemplateFilter) {
		CriteriaBuilder builder = manager .getCriteriaBuilder();
		CriteriaQuery<ResumoVerificadoresMonitoramentoTemplate> criteria = builder.createQuery(ResumoVerificadoresMonitoramentoTemplate.class);
		Root<ModVerificadoresMonitoramentoTemplate> root = criteria.from(ModVerificadoresMonitoramentoTemplate.class);
	
		criteria.select(builder.construct(ResumoVerificadoresMonitoramentoTemplate.class
				, root.get(ModVerificadoresMonitoramentoTemplate_.cdTipoDeVerificador).get(CadTipoDeVerificador_.cdTipoDeVerificador)
				, root.get(ModVerificadoresMonitoramentoTemplate_.cdVerificador).get(Verificador_m_.cdVerificador)
				, root.get(ModVerificadoresMonitoramentoTemplate_.cdVerificador).get(Verificador_m_.codalfa)
				, root.get(ModVerificadoresMonitoramentoTemplate_.cdVerificador).get(Verificador_m_.cadNivelDeAvaliacao).get(CadNivelDeAvaliacao_.sigla)
				, root.get(ModVerificadoresMonitoramentoTemplate_.cdVerificador).get(Verificador_m_.nmverificador)
				)).distinct(true);
		 
		
		Predicate[] predicates = criarRestricoes(modVerificadoresMonitoramentoTemplateFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ResumoVerificadoresMonitoramentoTemplate> query = manager.createQuery(criteria);
		return query.getResultList();
	}
	

	private void adiconarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalDeRegistrosPorPagina = 100;//pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalDeRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalDeRegistrosPorPagina);
		
	}
	
	private Predicate[] criarRestricoes(ModVerificadoresMonitoramentoTemplateFilter modVerificadoresMonitoramentoTemplateFilter, CriteriaBuilder builder,
			Root<ModVerificadoresMonitoramentoTemplate> root) {
		List<Predicate> predicates = new ArrayList<>();
		if (modVerificadoresMonitoramentoTemplateFilter.getCdTemplate() != null) {
			predicates.add(
					builder.equal(root.get(ModVerificadoresMonitoramentoTemplate_.cdTemplate), modVerificadoresMonitoramentoTemplateFilter.getCdTemplate()));
		}
		
		if (modVerificadoresMonitoramentoTemplateFilter.getCdEmpresa() != null) {
			predicates.add(
					builder.equal(root.get(ModVerificadoresMonitoramentoTemplate_.cdEmpresa), modVerificadoresMonitoramentoTemplateFilter.getCdEmpresa()));
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
	

	private Long total(ModVerificadoresMonitoramentoTemplateFilter modVerificadoresMonitoramentoTemplateFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<ModVerificadoresMonitoramentoTemplate> root = criteria.from(ModVerificadoresMonitoramentoTemplate.class);
		
		Predicate[] predicates = criarRestricoes(modVerificadoresMonitoramentoTemplateFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}









	


	
	
	

}
