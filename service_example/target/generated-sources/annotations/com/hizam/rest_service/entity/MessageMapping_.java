package com.hizam.rest_service.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MessageMapping.class)
public abstract class MessageMapping_ {

	public static volatile SingularAttribute<MessageMapping, User> from_id;
	public static volatile SingularAttribute<MessageMapping, User> to_id;
	public static volatile SingularAttribute<MessageMapping, Message> message_id;
	public static volatile SingularAttribute<MessageMapping, Long> id;

}

