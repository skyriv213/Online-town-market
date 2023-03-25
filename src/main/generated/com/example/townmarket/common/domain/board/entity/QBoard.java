package com.example.townmarket.common.domain.board.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    private static final long serialVersionUID = 400321625L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoard board = new QBoard("board");

    public final com.example.townmarket.common.QTimeStamped _super = new com.example.townmarket.common.QTimeStamped(this);

    public final SetPath<com.example.townmarket.common.domain.comment.entity.Comment, com.example.townmarket.common.domain.comment.entity.QComment> comments = this.<com.example.townmarket.common.domain.comment.entity.Comment, com.example.townmarket.common.domain.comment.entity.QComment>createSet("comments", com.example.townmarket.common.domain.comment.entity.Comment.class, com.example.townmarket.common.domain.comment.entity.QComment.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final EnumPath<Board.BoardSubject> subject = createEnum("subject", Board.BoardSubject.class);

    public final StringPath title = createString("title");

    public final com.example.townmarket.common.domain.user.entity.QUser user;

    public QBoard(String variable) {
        this(Board.class, forVariable(variable), INITS);
    }

    public QBoard(Path<? extends Board> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoard(PathMetadata metadata, PathInits inits) {
        this(Board.class, metadata, inits);
    }

    public QBoard(Class<? extends Board> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new com.example.townmarket.common.domain.user.entity.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

