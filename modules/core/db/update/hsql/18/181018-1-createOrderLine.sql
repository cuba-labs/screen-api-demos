create table SAD_ORDER_LINE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PRODUCT varchar(255),
    PRICE decimal(19, 2),
    QUANTITY decimal(19, 2),
    ORDER_ID varchar(36),
    --
    primary key (ID)
);
