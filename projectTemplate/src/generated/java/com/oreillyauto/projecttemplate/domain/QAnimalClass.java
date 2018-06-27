package com.oreillyauto.projecttemplate.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAnimalClass is a Querydsl query type for AnimalClass
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAnimalClass extends EntityPathBase<AnimalClass> {

    private static final long serialVersionUID = -1725763993L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAnimalClass animalClass = new QAnimalClass("animalClass");

    public final QAnimal animal;

    public final StringPath className = createString("className");

    public final StringPath hasHair = createString("hasHair");

    public final StringPath hasVertebrae = createString("hasVertebrae");

    public final StringPath warmBlooded = createString("warmBlooded");

    public QAnimalClass(String variable) {
        this(AnimalClass.class, forVariable(variable), INITS);
    }

    public QAnimalClass(Path<? extends AnimalClass> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAnimalClass(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAnimalClass(PathMetadata metadata, PathInits inits) {
        this(AnimalClass.class, metadata, inits);
    }

    public QAnimalClass(Class<? extends AnimalClass> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.animal = inits.isInitialized("animal") ? new QAnimal(forProperty("animal"), inits.get("animal")) : null;
    }

}

