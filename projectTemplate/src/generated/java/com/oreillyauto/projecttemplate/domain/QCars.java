package com.oreillyauto.projecttemplate.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCars is a Querydsl query type for Cars
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCars extends EntityPathBase<Cars> {

    private static final long serialVersionUID = 1403677684L;

    public static final QCars cars = new QCars("cars");

    public final ListPath<CarParts, QCarParts> carPartsList = this.<CarParts, QCarParts>createList("carPartsList", CarParts.class, QCarParts.class, PathInits.DIRECT2);

    public final NumberPath<Integer> cYear = createNumber("cYear", Integer.class);

    public final StringPath make = createString("make");

    public final StringPath model = createString("model");

    public final StringPath vid = createString("vid");

    public QCars(String variable) {
        super(Cars.class, forVariable(variable));
    }

    public QCars(Path<? extends Cars> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCars(PathMetadata metadata) {
        super(Cars.class, metadata);
    }

}

