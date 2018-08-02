package com.oreillyauto.projecttemplate.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEvent is a Querydsl query type for Event
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEvent extends EntityPathBase<Event> {

    private static final long serialVersionUID = 566795365L;

    public static final QEvent event = new QEvent("event");

    public final DateTimePath<java.sql.Timestamp> dateTime = createDateTime("dateTime", java.sql.Timestamp.class);

    public final NumberPath<java.math.BigInteger> eventId = createNumber("eventId", java.math.BigInteger.class);

    public final ListPath<EventProperty, QEventProperty> eventPropertyList = this.<EventProperty, QEventProperty>createList("eventPropertyList", EventProperty.class, QEventProperty.class, PathInits.DIRECT2);

    public final StringPath eventType = createString("eventType");

    public final BooleanPath smsSent = createBoolean("smsSent");

    public QEvent(String variable) {
        super(Event.class, forVariable(variable));
    }

    public QEvent(Path<? extends Event> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEvent(PathMetadata metadata) {
        super(Event.class, metadata);
    }

}

