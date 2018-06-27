package com.oreillyauto.projecttemplate.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAnimal is a Querydsl query type for Animal
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAnimal extends EntityPathBase<Animal> {

    private static final long serialVersionUID = 269000081L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAnimal animal = new QAnimal("animal");

    public final QAnimalClass animalClass;

    public final ListPath<Continent, QContinent> continentList = this.<Continent, QContinent>createList("continentList", Continent.class, QContinent.class, PathInits.DIRECT2);

    public final StringPath continentName = createString("continentName");

    public final StringPath legCount = createString("legCount");

    public final StringPath lifeExpectancy = createString("lifeExpectancy");

    public final StringPath name = createString("name");

    public final StringPath sound = createString("sound");

    public QAnimal(String variable) {
        this(Animal.class, forVariable(variable), INITS);
    }

    public QAnimal(Path<? extends Animal> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAnimal(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAnimal(PathMetadata metadata, PathInits inits) {
        this(Animal.class, metadata, inits);
    }

    public QAnimal(Class<? extends Animal> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.animalClass = inits.isInitialized("animalClass") ? new QAnimalClass(forProperty("animalClass"), inits.get("animalClass")) : null;
    }

}

