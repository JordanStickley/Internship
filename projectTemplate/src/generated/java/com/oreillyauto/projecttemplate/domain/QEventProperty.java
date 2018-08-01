package com.oreillyauto.projecttemplate.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEventProperty is a Querydsl query type for EventProperty
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEventProperty extends EntityPathBase<EventProperty> {

    private static final long serialVersionUID = -720066214L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEventProperty eventProperty = new QEventProperty("eventProperty");

    public final DateTimePath<java.sql.Timestamp> dateTime = createDateTime("dateTime", java.sql.Timestamp.class);

    public final QEvent event;

    public final StringPath eventValue = createString("eventValue");

    public final NumberPath<java.math.BigInteger> propertyId = createNumber("propertyId", java.math.BigInteger.class);

    public QEventProperty(String variable) {
        this(EventProperty.class, forVariable(variable), INITS);
    }

    public QEventProperty(Path<? extends EventProperty> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEventProperty(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEventProperty(PathMetadata metadata, PathInits inits) {
        this(EventProperty.class, metadata, inits);
    }

    public QEventProperty(Class<? extends EventProperty> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.event = inits.isInitialized("event") ? new QEvent(forProperty("event")) : null;
    }

}

