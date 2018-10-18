-- begin SAD_CONTRACT
create table SAD_CONTRACT (
    ID varchar(36) not null,
    VERSION integer,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TITLE varchar(255),
    --
    primary key (ID)
)^
-- end SAD_CONTRACT
-- begin SAD_ORDER
create table SAD_ORDER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUM varchar(255),
    DATE date not null,
    CUSTOMER_ID varchar(36),
    --
    primary key (ID)
)^
-- end SAD_ORDER
-- begin SAD_ORDER_LINE
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
)^
-- end SAD_ORDER_LINE
-- begin SAD_CUSTOMER
create table SAD_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    EMAIL varchar(100),
    --
    primary key (ID)
)^
-- end SAD_CUSTOMER
