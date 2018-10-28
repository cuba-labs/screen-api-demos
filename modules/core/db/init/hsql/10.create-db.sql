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
    NUMBER_ varchar(255),
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
    NUM integer not null,
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
-- begin SAD_AIRPORT
create table SAD_AIRPORT (
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
    --
    primary key (ID)
)^
-- end SAD_AIRPORT
-- begin SAD_TERMINAL
create table SAD_TERMINAL (
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
    AIRPORT_ID varchar(36),
    --
    primary key (ID)
)^
-- end SAD_TERMINAL
-- begin SAD_MEETING_POINT
create table SAD_MEETING_POINT (
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
    TERMINAL_ID varchar(36),
    --
    primary key (ID)
)^
-- end SAD_MEETING_POINT
-- begin SAD_NOTE
create table SAD_NOTE (
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
    MEETING_POINT_ID varchar(36),
    --
    primary key (ID)
)^
-- end SAD_NOTE
