package br.com.magna.pea2.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LocadoraModel.class)
public abstract class EventoModel_ {

	public static volatile SingularAttribute<LocadoraModel, Long> codigo;
	public static volatile SingularAttribute<LocadoraModel, String> cidade;
	public static volatile SingularAttribute<LocadoraModel, String> nomeEvento;
	public static volatile SingularAttribute<LocadoraModel, LocalDate> data;
	public static volatile SingularAttribute<LocadoraModel, Long> id;

}

