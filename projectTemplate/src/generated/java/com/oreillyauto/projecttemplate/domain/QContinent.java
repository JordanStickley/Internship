package com.oreillyauto.projecttemplate.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QContinent is a Querydsl query type for Continent
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QContinent extends EntityPathBase<Continent> {

    private static final long serialVersionUID = 2145810943L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QContinent continent = new QContinent("continent");

    public final QAnimal animal;

    public final NumberPath<Long> area = createNumber("area", Long.class);

    public final NumberPath<Long> humanPopulation = createNumber("humanPopulation", Long.class);

    public final StringPath name = createString("name");

    public QContinent(String variable) {
        this(Continent.class, forVariable(variable), INITS);
    }

    public QContinent(Path<? extends Continent> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QContinent(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QContinent(PathMetadata metadata, PathInits inits) {
        this(Continent.class, metadata, inits);
    }

    public QContinent(Class<? extends Continent> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.animal = inits.isInitialized("animal") ? new QAnimal(forProperty("animal"), inits.get("animal")) : null;
    }

}

