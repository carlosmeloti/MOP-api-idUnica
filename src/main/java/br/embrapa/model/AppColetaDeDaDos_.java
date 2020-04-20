package br.embrapa.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AppColetaDeDaDos.class)
public abstract class AppColetaDeDaDos_ {

	public static volatile SingularAttribute<AppColetaDeDaDos, AppAvaliacao> cdAvaliacao;
	public static volatile SingularAttribute<AppColetaDeDaDos, CadEmpresa> cdEmpresa;
	public static volatile SingularAttribute<AppColetaDeDaDos, Long> cdColetaDeDaDos;
	public static volatile SingularAttribute<AppColetaDeDaDos, CadTipoDeVerificador> cdTipoDeVerificador;
	public static volatile SingularAttribute<AppColetaDeDaDos, Integer> nrObservacoes;
	public static volatile SingularAttribute<AppColetaDeDaDos, Integer> nrNaoConformidades;
	public static volatile SingularAttribute<AppColetaDeDaDos, String> txObservacao;

}

