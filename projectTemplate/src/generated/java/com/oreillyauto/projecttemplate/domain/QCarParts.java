package com.oreillyauto.projecttemplate.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCarParts is a Querydsl query type for CarParts
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCarParts extends EntityPathBase<CarParts> {

    private static final long serialVersionUID = 1579937217L;

    public static final QCarParts carParts = new QCarParts("carParts");

    public final ListPath<Cars, QCars> carsList = this.<Cars, QCars>createList("carsList", Cars.class, QCars.class, PathInits.DIRECT2);

    public final StringPath line = createString("line");

    public final StringPath partNumber = createString("partNumber");

    public final NumberPath<java.math.BigDecimal> price = createNumber("price", java.math.BigDecimal.class);

    public final NumberPath<Integer> qtyOnHand = createNumber("qtyOnHand", Integer.class);

    public final StringPath title = createString("title");

    public QCarParts(String variable) {
        super(CarParts.class, forVariable(variable));
    }

    public QCarParts(Path<? extends CarParts> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCarParts(PathMetadata metadata) {
        super(CarParts.class, metadata);
    }

}

