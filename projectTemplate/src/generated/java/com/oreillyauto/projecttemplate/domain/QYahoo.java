package com.oreillyauto.projecttemplate.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QYahoo is a Querydsl query type for Yahoo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QYahoo extends EntityPathBase<Yahoo> {

    private static final long serialVersionUID = 584643083L;

    public static final QYahoo yahoo = new QYahoo("yahoo");

    public final BooleanPath active = createBoolean("active");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath firstName = createString("firstName");

    public final StringPath id = createString("id");

    public final StringPath lastName = createString("lastName");

    public final DatePath<java.sql.Date> startDate = createDate("startDate", java.sql.Date.class);

    public QYahoo(String variable) {
        super(Yahoo.class, forVariable(variable));
    }

    public QYahoo(Path<? extends Yahoo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QYahoo(PathMetadata metadata) {
        super(Yahoo.class, metadata);
    }

}

